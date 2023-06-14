package Steps;

import Page.EditMyaccountPage;
import Page.MyAccountPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

public class EditMyaccoutnSteps {
    EditMyaccountPage editMyaccountPage;
    MyAccountPage myAccountPage;
    Map<String,String> mapDados;
    @Dado("que esteja na pagina de alteracao de conta")
    public void queEstejaNaPaginaDeAlteracaoDeConta() {
       myAccountPage = new MyAccountPage();
       myAccountPage.clicklinkUser();
       myAccountPage.clicklinkMyaccount();
       myAccountPage.clicklinkEdit();
    }
    @Quando("altero os valores dos seguintes campos")
    public void alteroOsValoresDosSeguintesCampos(Map<String,String> map) {
        mapDados = map;
       editMyaccountPage = new EditMyaccountPage();
       editMyaccountPage.setinpFirstname(map.get("firstname"));
       editMyaccountPage.setinpLastname(map.get("lastname"));
    }
    @Quando("realizao o clique em Salvar")
    public void realizaoOCliqueEmSalvar() {
       editMyaccountPage.clickbtnSave();
    }
    @Entao("a alteracao deve ser exibidsa na pagina MyAccount")
    public void aAlteracaoDeveSerExibidsaNaPaginaMyAccount() {
        String nome = mapDados.get("firstname")+" "+mapDados.get("lastname");
        Assert.assertEquals(nome,myAccountPage.getextUsuario());
    }
}
