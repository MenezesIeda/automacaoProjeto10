package Steps;

import Core.Driver;
import Enulls.Browser;
import Page.LoginPage;
import Page.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class LoginSteps {
    LoginPage loginPage;
    NewAccountPage newAccountPage;
    String username;

    @Before
    public void inicializaNavegador(Scenario cenario) {
        new Driver(Browser.CHROME);
        Driver.setNomeCenario(cenario.getName());
        Driver.criaDiretorio();
    }

    @After
    public void finalizaNavegador(Scenario cenario) throws IOException {

        if (cenario.isFailed()) {
            Driver.printScreen("cenario com erro");
        }
        Driver.getDriver().quit();
    }

    @Dado("que a modal esteja aberta")
    public void queAModalEstejaAberta() {
        Driver.getDriver().get("https://advantageonlineshopping.com/#/");
        loginPage = new LoginPage();
        loginPage.clickbtnLogin();
        loginPage.visibilityOfBtnFechar();
        loginPage.aguardaLoader();

    }

    @Quando("for realizado o clique fora da modal")
    public void forRealizadoOCliqueForaDaModal() {
        loginPage.clickdivFechaModal();

    }

    @Então("a janela modal deve ser fechada")
    public void aJanelaModalDeveSerFechada() throws Exception {
        try {
            loginPage.invisibilityOfBtnFechar();
        } catch (Exception e) {
            throw new Exception("A janela nao foi fechada");
        }

    }

    @Quando("for realizado o clique no icone do fechar modal")
    public void forRealizadoOCliqueNoIconeDoFecharModal() {

        loginPage.clickbtnIconeFechar();


    }

    @Quando("for realizado o clique no link Create NewAccount")
    public void forRealizadoOCliqueNoLinkCreateNewAccount() {
        loginPage.linkCreateAccount();

    }

    @Então("a pagina Create NewAccount deve ser exibida")
    public void aPaginaCreateNewAccountDeveSerExibida() {

        newAccountPage = new NewAccountPage();
        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.gettextCreateAccount());
    }

    @Quando("os campos de login sejam preenchidos da seguinte forma")
    public void osCamposDeLoginSejamPreenchidosDaSeguinteForma(Map<String, String> map) throws IOException {
        username = map.get("username");
        loginPage.setinpUsername(map.get("username"));
        loginPage.setinpPassword(map.get("password"));
        boolean remember = Boolean.parseBoolean(map.get("remember"));
        if (remember) {
            loginPage.clickinpRemember();
        }
        Driver.printScreen("login com todos os campos preenchidos");
    }


    @Quando("for realizado o clique no botao sign in")
    public void forRealizadoOCliqueNoBotaoSignIn() {
        loginPage.clickbtnSigIn();
    }

    @Entao("deve ser possivel logar no sistema")
    public void deveSerPossivelLogarNoSistema() throws IOException {
        Assert.assertEquals(username, loginPage.gettextLogado());
        Driver.printScreen("logado no sistema");
    }

    @Entao("o sistema devera exibir uma mensagem de erro")
    public void oSistemaDeveraExibirUmaMensagemDeErro() {
        Assert.assertEquals("Incorrect user name or password.", loginPage.gettextErroLogin());
    }

    @Entao("o botao sign in deve permanecer desabilitado")
    public void oBotaoSignInDevePermanecerDesabilitado() {
        boolean enable = loginPage.isbtnSigin();
        Assert.assertFalse(enable);

    }

    @Dado("que esteja logado no sistema")
    public void queEstejaLogadoNoSistema(Map<String, String> map) throws IOException {
        queAModalEstejaAberta();
        osCamposDeLoginSejamPreenchidosDaSeguinteForma(map);
        forRealizadoOCliqueNoBotaoSignIn();
        deveSerPossivelLogarNoSistema();

    }
}