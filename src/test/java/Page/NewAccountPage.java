package Page;

import Core.Driver;
import Map.NewAccountMap;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
    NewAccountMap newAccountMap;
    public NewAccountPage(){
        newAccountMap = new NewAccountMap();
        PageFactory.initElements(Driver.getDriver(),newAccountMap);
    }
    public String gettextCreateAccount(){
        Driver.visibilityOf(newAccountMap.textCreateAccount);
        return newAccountMap.textCreateAccount.getText();
    }
    public void setinpUsername(String username){
        Driver.visibilityOf(newAccountMap.inpUsername);
        newAccountMap.inpUsername.sendKeys(username);
    }
    public void setinpEmail(String email){
        newAccountMap.inpEmail.sendKeys(email);
    }
    public void setiinpPassword(String password){
        newAccountMap.inpPassword.sendKeys(password);
    }
    public void setinpConfirmaPassword(String password){
        newAccountMap.inpConfirmaPassword.sendKeys(password);
    }
    public void selectslcountry(String country){
        Select select = new Select(newAccountMap.slCountry);
        select.selectByVisibleText(country);

    }
    public void clickbtnRegister(){
        newAccountMap.btnRegister.click();
    }
    public void clickinpIagree(){
        newAccountMap.inpIagree.click();
    }

}
