package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Log;

public class Dashboard {
    private WebDriver driver;
    @FindBy(xpath = "//a[@class='btn btn-success']")
    private WebElement updateDashboard;

    //--------------------------------------------------------------------Dashboard Methods START
    public void clickUpdateDashboard() {
        try {
            Log.info("Checking if update dashboard button is displayed.");
            Assert.assertEquals(updateDashboard.getAttribute("title"), "Update dashboard");
            //Is it okay to use getAttribute?
            Log.info("Clicking the update dashboard button.");
            updateDashboard.click();
        } catch (AssertionError e) {
            Log.error("The update dashboard button isn't displayed");
            throw e;
        }
    }


    //--------------------------------------------------------------------Dashboard Methods END
    public Dashboard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}

