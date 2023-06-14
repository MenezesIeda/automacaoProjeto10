package Steps;

import Core.Driver;
import Page.LoginPage;
import Page.NewAccountPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

public class NewAccountSteps {
    NewAccountPage newAccountPage;
    String username;
    @Dado("que a pagina newAccount esteja sendo exibida")
    public void queAPaginaNewAccountEstejaSendoExibida() {
        newAccountPage = new NewAccountPage();
        Driver.getDriver().get("https://advantageonlineshopping.com/#/");
        Driver.getDriver().get("https://advantageonlineshopping.com/#/register");
        Assert.assertEquals("CREATE ACCOUNT",newAccountPage.gettextCreateAccount());

    }
    @Quando("os campos de cadastro estiverem preenchido")
    public void osCamposDeCadastroEstiveremPreenchido(Map<String,String> map) {
        username = map.get("username");
        newAccountPage.setinpUsername(map.get("username"));
        newAccountPage.setinpEmail(map.get("email"));
        newAccountPage.setiinpPassword(map.get("password"));
        newAccountPage.setinpConfirmaPassword(map.get("password"));
        newAccountPage.selectslcountry(map.get("country"));
        newAccountPage.clickinpIagree();
        newAccountPage.clickbtnRegister();

    }
    @Entao("deve ser possivel logar no sistema apos o cadastro")
    public void deveSerPossivelLogarNoSistemaAposOCadastro() {
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(username,loginPage.gettextLogado());
    }

}
