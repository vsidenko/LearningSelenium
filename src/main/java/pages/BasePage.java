package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Log;


public class BasePage {
    private static WebDriver driver;
    private static WebElement element;


    //__________________________________________________________________________________Some methods
    public static boolean isClickable(WebElement webe) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(webe));
            return true;
        } catch (Exception e) {
            throw new RuntimeException("The " + webe + " element is not clicable");
        }
    }
//___________________________________________________________________________________Some methods ends


//___________________________________________________________________________________Some checks

    public void urlMatch(String expectedUrl) throws Exception {
        Log.info("Checking the expected url is matching to the current url.");
        String currentUrl = driver.getCurrentUrl();
        try {
            Assert.assertEquals(currentUrl, expectedUrl);
        } catch (AssertionError e) {
            Log.error("URL Check failed *** Current url : " + currentUrl + " ***  Expected url : " + expectedUrl);
            throw e;
        }
        Log.info("The url check passed.");
    }

//___________________________________________________________________________________Some checks ends

    //___________________________________________________________________________________Some exceptions START


    //___________________________________________________________________________________Some exceptions ENDS
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

