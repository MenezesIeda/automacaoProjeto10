package Page;

import Core.Driver;
import Map.EditAccountMap;
import org.openqa.selenium.support.PageFactory;

public class EditMyaccountPage {
    EditAccountMap editAccountMap;
    public EditMyaccountPage(){
        editAccountMap = new EditAccountMap();
        PageFactory.initElements(Driver.getDriver(),editAccountMap);
    }
    public void setinpFirstname(String firstname){
        Driver.visibilityOf(editAccountMap.inpFirstname);
        editAccountMap.inpFirstname.sendKeys(firstname);
    }
    public void setinpLastname(String lastname){
        editAccountMap.inpLastname.sendKeys(lastname);
    }
    public void clickbtnSave(){
        editAccountMap.btnSave.click();
    }
}
