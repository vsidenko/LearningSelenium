package pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Log;


public class LoginPage {
    WebDriver driver;
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(css = ".btn")
    private WebElement submitButton;

    //____________________________________________________________________Login Methods start
    public void enterName(String name) {
        try {
            Log.info("Checking if the Username field is displayed.");
            usernameField.isDisplayed();
            Log.info("Entering username");
            usernameField.sendKeys(name);
        } catch (NoSuchElementException e) {
            Log.error("Failed to enter username.");
            throw e;
        }
    }


    public void enterPassword(String pass) {
        try {
            Log.info("Checking if the Password field is displayed.");
            passwordField.isDisplayed();
            Log.info("Entering password.");
            passwordField.sendKeys(pass);
        } catch (NoSuchElementException e) {
            Log.error("Failed to enter password");
            throw e;
        }
    }


    public void clickLogin() {
        try {
            Log.info("Checking if the Login button is displayed");
            submitButton.isDisplayed();
            Log.info("Click Login button");
            submitButton.click();
        } catch (NoSuchElementException e) {
            Log.info("The login button is not displayed or not clickable.");
            throw e;
        }

    }
    //--------------------------------------------------------------------Login Methods End


    //--------------------------------------------------------------------Login constructor start

    public void authenticate(String name,String pass){
        enterPassword(pass);
        enterName(name);
        clickLogin();
    }
    //--------------------------------------------------------------------Login constructor End

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}