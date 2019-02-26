import Data.LoginCredentials;
import Data.targetUrl;
import pages.Dashboard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.NavigationElements;
import utilities.Log;

import java.util.concurrent.TimeUnit;


public class loginPageTest {
    private WebDriver driver;
    private LoginPage lp;
    private BasePage bp;
    private NavigationElements nm;
    private Dashboard db;

    @BeforeClass
    public void setUp() {
        Log.info("Setting up browser.");
        //***************BROWSER_SETUP*****************START
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //***************BROWSER_SETUP*****************END

        //***************PAGE_INSTANTIATIONS*****************START
        bp = new BasePage(driver);
        lp = new LoginPage(driver);
        nm = new NavigationElements(driver);
        db = new Dashboard(driver);
        //***************PAGE_INSTANTIATIONS*****************END
        Log.info("Opening the login page.");
        driver.get(targetUrl.getLogin());

    }

    @Test(dataProvider = "inputsInvalid", dataProviderClass = LoginCredentials.class)
    public void testInvalidAuthorization(String name, String pass) throws Exception {
        Log.startLog("Test invalid authorisation");
        lp.authenticate(name, pass);
        bp.urlMatch(targetUrl.getLogin());
        Log.endLog("Test invalid authorisation");


    }

    @Test(dataProvider = "inputsValid", dataProviderClass = LoginCredentials.class, priority = 1)
    public void testValidAuthorization(String name, String pass) throws Exception {
        Log.startLog("Test valid authorisation");

        Log.info("Authenticating with valid credentials");
        lp.authenticate(name, pass);
        Thread.sleep(1000);
        db.clickUpdateDashboard();
        Log.endLog("Test valid authorisation");

    }

    @Test(priority = 2)
    public void testLogout() throws Exception {
        Log.startLog("testLogout");
        nm.clickMenuToggleUserNameDropdown();
        nm.clickLogoutButton();
        Log.info("Trying to click login button after The user is logged out.");
        lp.clickLogin();
        Log.info("Trying to open dashboard after user is logged out.");
        driver.get(targetUrl.getDashboard());
        Log.info("Checking if the user isn't able to open dashboard page after logged out.");
        Assert.assertNotEquals(driver.getCurrentUrl(), targetUrl.getDashboard());
        Log.endLog("testLogout");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        driver.quit();
    }
}
