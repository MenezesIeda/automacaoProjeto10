package Core;

import Enulls.Browser;
import io.cucumber.messages.internal.com.google.protobuf.compiler.PluginProtos;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Driver {
   private static WebDriver driver;
   private static WebDriverWait wait;
   private static String nomeCenario;
   private static File diretorio;
   private static int numPrint;
    public Driver(Browser navegador){
        switch (navegador){
            case CHROME:
                starchrome();
                break;
            case FIREFOX:
                starfirefox();
                break;
        }
        wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
        driver.get("https://advantageonlineshopping.com/#/");

    }

    private static void starfirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    private static void starchrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        boolean headless = Boolean.parseBoolean(System.getProperty("headless"));
        chromeOptions.setHeadless(headless);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1280,720));
    }

    public static WebDriver getDriver() {
        return driver;
    }
    public static void visibilityOf(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void invisibilityOf(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public static void attributeChange(WebElement element, String attribute, String value){
        wait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public static String getNomeCenario() {
        return nomeCenario;
    }

    public static void setNomeCenario(String nomeCenario) {
        Driver.nomeCenario = nomeCenario;
    }
    public static void criaDiretorio(){
        String caminho = "src/test/resources/evidencias";
        diretorio = new File(caminho+"/"+nomeCenario);
        diretorio.mkdir();
        numPrint=0;

    }

    public static File getDiretorio() {
        return diretorio;
    }
    public static void printScreen(String passo) throws IOException {
        numPrint ++;
        File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String caminho= diretorio.getPath()+"/"+numPrint+"-"+passo+".png";
         FileUtils.copyFile(file, new File(caminho));


    }

}
