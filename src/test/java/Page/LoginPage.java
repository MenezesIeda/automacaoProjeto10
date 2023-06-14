package Page;

import Core.Driver;
import Map.LoginMap;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    LoginMap loginMap;
    public LoginPage(){
        loginMap = new LoginMap();
        PageFactory.initElements(Driver.getDriver(),loginMap);
    }
    public void clickbtnLogin(){
        Driver.visibilityOf(loginMap.btnLogin);
        loginMap.btnLogin.click();
    }
    public void clickdivFechaModal(){

        loginMap.divFechaModal.click();
    }
    public void clickbtnIconeFechar(){
        Driver.visibilityOf(loginMap.btnIconeFechar);
        loginMap.btnIconeFechar.click();
    }
    public void setinpUsername(String usename){
        if (usename!=null){
            loginMap.inpUsername.sendKeys(usename);
        }

    }
    public void setinpPassword(String password){
        if(password!=null){
            loginMap.inpPassword.sendKeys(password);
        }


    }
    public void clickinpRemember(){
        loginMap.inpRemember.click();
    }
    public void clickbtnSigIn(){
        loginMap.btnSigIn.click();
    }
    public boolean isbtnSigin(){
        return loginMap.btnSigIn.isEnabled();
    }
    public void linkCreateAccount(){

        loginMap.linkCreateNewAccount.click();
    }
    public String gettextErroLogin(){
        Driver.visibilityOf(loginMap.textErroLogin);
        return loginMap.textErroLogin.getText();
    }
    public String gettextLogado(){
        Driver.visibilityOf(loginMap.textLogado);
        return loginMap.textLogado.getText();
    }
    public void visibilityOfBtnFechar(){
        Driver.visibilityOf(loginMap.btnIconeFechar);
    }
    public void invisibilityOfBtnFechar(){
        Driver.invisibilityOf(loginMap.btnIconeFechar);
    }
    public void aguardaLoader(){
        Driver.attributeChange(loginMap.divLoader, "display","none");
    }
    public String getextLogado(){
        Driver.visibilityOf(loginMap.textLogado);
        return loginMap.textLogado.getText();

    }
    public String getextErroLogin(){
        Driver.visibilityOf(loginMap.textErroLogin);
        return loginMap.textErroLogin.getText();
    }
    public void visibilityOfBtnIconeFechar(){
        Driver.visibilityOf(loginMap.divFechaModal);
    }
    public void invsibilityOfIconeFechar(){
        Driver.invisibilityOf(loginMap.divFechaModal);
    }
}
