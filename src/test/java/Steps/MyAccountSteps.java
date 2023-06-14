package Steps;

import Map.MyAccountMap;
import Page.MyAccountPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class MyAccountSteps {
    MyAccountPage myAccountPage;
    @Dado("que estena na pagina MyAccount")
    public void queEstenaNaPaginaMyAccount() {
     myAccountPage = new MyAccountPage();
     myAccountPage.clicklinkUser();
     myAccountPage.clicklinkMyaccount();

    }
    @Quando("for efetuado clique em Delete e Yes")
    public void forEfetuadoCliqueEmDeleteEYes() {
        myAccountPage.clickbtnDelete();
        myAccountPage.clickbtnYes();
    }
    @Entao("o usuario deve ser excluido")
    public void oUsuarioDeveSerExcluido() {
        Assert.assertEquals("Account deleted successfully",myAccountPage.gettextConfirmaExclusao());
    }

}
