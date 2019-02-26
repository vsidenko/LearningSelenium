import Data.AllServices;
import Data.LoginCredentials;
import Data.targetUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;


import java.util.concurrent.TimeUnit;

import pages.ServicesAll;
import utilities.Log;


public class services_All_Page_Test {

    private WebDriver driver;
    private ServicesAll servAll;
    private LoginPage lp;


    @BeforeClass(description = "Class Level Setup")
    public void setUp() {
        Log.info("Setting up the ChromeBrowser");

        //***************BROWSER_SETUP*****************START
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //***************BROWSER_SETUP*****************END

        //******************PAGE_INSTANTIATIONS***************START
        servAll = new ServicesAll(driver);
        lp = new LoginPage(driver);
        //***************PAGE_INSTANTIATIONS*****************END

        //***************METHODS**************************START
        //Open login page
        Log.info("Opening the Login page");
        driver.get(targetUrl.getLogin());

        //***************METHODS**************************END
    }
    @Test(dataProvider = "inputsValid", dataProviderClass = LoginCredentials.class)
    public void loginTest(String name,String pass){
        Log.info("Trying to login with valid credentials");
        lp.authenticate(name,pass);
    }

    @Test(dataProvider = "validServiceInfo", dataProviderClass = AllServices.class,priority = 1)
    public void generalDomainIf(String name,String SelectServiceType,String Website,String LoginPage,String HostingCompany,
                                String DomainAge,String ServiceUrls,String AdminServiceUrls,String TermsAndConditions,
                                String ServiceDescription,String selectCategory,String selectCategoryFP,
                                String lastReportedBreach,String selectCompanyType,String ServicePopularity, String ServiceFoundYear,
                                String serviceHeadQuartersLocation,String serviceDataCenterLocation,String ServiceProvider,
                                String serviceProviderLocation){
        //Test starts
        Log.startLog("testServiceList");

        Log.info("Opening the Services_all page");
        driver.get(targetUrl.getServices_All());
        servAll.selectService("13134");//
        servAll.constructor_1_5(name,SelectServiceType,Website,LoginPage,HostingCompany);
        servAll.constructor_6_10(DomainAge,ServiceUrls,AdminServiceUrls,TermsAndConditions,ServiceDescription);
        servAll.constructor_11_15(selectCategory,selectCategoryFP,lastReportedBreach,selectCompanyType,ServicePopularity);
        servAll.constructor_16_20(ServiceFoundYear,serviceHeadQuartersLocation,serviceDataCenterLocation,ServiceProvider,serviceProviderLocation);
        servAll.clickTopSaveButton();



        //Test ends
        Log.endLog("testServiceList");
    }

    @AfterClass
    public void tearDown() {
        Log.info("Closing the browser");
        driver.quit();
    }
}
