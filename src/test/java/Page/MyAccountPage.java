package Page;

import Core.Driver;
import Map.MyAccountMap;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    MyAccountMap myAccountMap;
    public MyAccountPage(){
        myAccountMap = new MyAccountMap();
        PageFactory.initElements(Driver.getDriver(),myAccountMap);
    }
    public void clicklinkUser(){
        myAccountMap.linkUser.click();
    }
    public void clicklinkMyaccount(){
        Driver.visibilityOf(myAccountMap.linkMyaccount);
        myAccountMap.linkMyaccount.click();
    }
    public void clicklinkEdit(){
        Driver.visibilityOf(myAccountMap.linkEdit);
        myAccountMap.linkEdit.click();
    }
    public void clickbtnDelete(){
        Driver.visibilityOf(myAccountMap.btnDelete);
        myAccountMap.btnDelete.click();

    }
    public void clickbtnYes(){
        Driver.visibilityOf(myAccountMap.btnYes);
        myAccountMap.btnYes.click();
    }
    public String getextUsuario(){
        Driver.visibilityOf(myAccountMap.textUsuario);
        return myAccountMap.textUsuario.getText();
    }
    public String gettextConfirmaExclusao(){
        Driver.visibilityOf(myAccountMap.txtConfirmaExclusao);
        return myAccountMap.txtConfirmaExclusao.getText();
    }
}
