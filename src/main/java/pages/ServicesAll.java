package pages;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.Log;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

public class ServicesAll {
    WebDriver driver;
    //--------------------------------------------------------------------List of elements START
    @FindBy(css = "[ng-style='Viewport\\.rowStyle\\(rowRenderIndex\\)']")
    List<WebElement> services;
    @FindBy(xpath = "//bootstrap-decorator[@form='schemaForm.form[0]']//input")
    WebElement topSaveButton;
    @FindBy(id = "toast-container")
    WebElement checkIfserviceIsSaved;


    //--------------------------------------------------------------------List of elements ENDS

    //--------------------------------------------------------------------Methods START

    public void clickTopSaveButton() throws RuntimeException {
        try {
            Log.info("Trying to save service by clicking the top 'Save' button");
            topSaveButton.click();
            Assert.assertTrue(checkIfserviceIsSaved.isDisplayed());
            Log.info("The service was successfully saved");
        } catch (Exception e) {
            Log.error("Failed *** The service wasn't saved.");
            throw new RuntimeException("Failed *** The service wasn't saved.");
        }
    }


    public void selectService(String setIDorNameOrStatus) {
        try {
            for (WebElement service : services) {
                if (service.getText().toLowerCase().contains(setIDorNameOrStatus)) {
                    Log.info("Selecting the service : " + setIDorNameOrStatus);
                    service.click();
                }
            }
        } catch (Exception e) {
            Log.error("Service : " + setIDorNameOrStatus + " wasn't found");
            throw new RuntimeException("Service : " + setIDorNameOrStatus + " wasn't found");
        }
    }
    //--------------------------------------------------------------------Methods END

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    //----------------------Service_General_INFO_Locators--------------START
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    @FindBy(id = "Name")
    private WebElement nameInputField;
    @FindBy(name = "Service_type")
    private WebElement serviceType;
    @FindBy(id = "Website")
    private WebElement serviceWebsite;
    @FindBy(id = "LoginPage")
    private WebElement serviceLoginPage;
    @FindBy(id = "Hosting_company")
    private WebElement serviceHostingCompany;
    @FindBy(xpath = "//bootstrap-decorator[@form='schemaForm.form[13]']//button")
    private WebElement hostingCompanyTryParseButton;

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    //----------------------Service_General_INFO_Locators--------------END
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //**********************************************************************
    //----------------------Service_General_INFO_METHODS--------------START
    //**********************************************************************

    public void fillServiceName(String name) {
        Log.info("Clearing the service name field.");
        nameInputField.clear();
        Log.info("Entering service name");
        nameInputField.sendKeys(name);
    }

    public void selectServiceType(String VisibleText) {
        Select selectServiceType = new Select(serviceType);
        Log.info("Selecting " + VisibleText + " service type.");
        selectServiceType.selectByVisibleText(VisibleText);
    }

    public void generalInfoofillServiceWebsite(String serviceUrl) {
        Log.info("Clearing the service website field.");
        serviceWebsite.clear();
        Log.info("Entering service Website.");
        serviceWebsite.sendKeys(serviceUrl);
    }

    public void fillServiceLoginUrl(String serviceLoginUrl) {
        Log.info("Clearing the service Login url field.");
        serviceLoginPage.clear();
        Log.info("Entering service Login Url.");
        serviceLoginPage.sendKeys(serviceLoginUrl);
    }

    public void parseHostingCompany() {
        Log.info("Starting to parse general info");
        hostingCompanyTryParseButton.click();
    }

    public void enterHostingCompany(String HostingCompanyName) {
        Log.info("Entering hosting company name.");
        serviceHostingCompany.sendKeys(HostingCompanyName);
    }


    //**********************************************************************
    //----------------------Service_General_INFO_METHODS--------------END
    //**********************************************************************


    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    //----------------------ADDITIONAL_SERVICE_INFO_LOCATORS--------------START
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    @FindBy(id = "Domain_age")
    private WebElement domainAgeInput;
    @FindBy(xpath = "//bootstrap-decorator[@form='schemaForm.form[16]']//button")
    private WebElement parseServiceDomainAge;
    @FindBy(id = "Service_URLs")
    private WebElement serviceUrlsList;
    @FindBy(xpath = "//bootstrap-decorator[@form='schemaForm.form[19]']//button")
    private WebElement parseServiceUrls;
    @FindBy(id = "admin_service_urls")
    private WebElement serviceAdminUrlsList;
    @FindBy(id = "Terms_and_conditions")
    private WebElement serviceTermsAndConditions;
    @FindBy(id = "Description")
    private WebElement serviceDescription;
    @FindBy(xpath = "//bootstrap-decorator[@form='schemaForm.form[26]']//button")
    private WebElement parseServiceDescription;
    @FindBy(name = "Category")
    private WebElement selctServiceCategory;
    @FindBy(name = "CategoryFP")
    private WebElement selctServiceCategoryFP;
    @FindBy(id = "Last_reported_breach")
    private WebElement serviceLastReportedBreach;
    @FindBy(name = "Company_type")
    private WebElement selctServiceCompanyType;
    @FindBy(id = "Popularity")
    private WebElement servicePopularity;
    @FindBy(xpath = "//bootstrap-decorator[@form='schemaForm.form[37]']//button")
    private WebElement parsePopularity;
    @FindBy(id = "Found_year")
    private WebElement serviceFoundYear;
    @FindBy(id = "Headquarters_location")
    private WebElement serviceHQlocation;
    @FindBy(id = "Data_center_location")
    private WebElement serviceDataCenterLocation;
    @FindBy(id = "Provider")
    private WebElement serviceProviderCompany;
    @FindBy(id = "Location")
    private WebElement serviceProviderLocation;

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    //----------------------ADDITIONAL_SERVICE_INFO_LOCATORS--------------END
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    //**********************************************************************
    //----------------------ADDITIONAL_SERVICE_INFO_METHODS---------------START
    //**********************************************************************


    public void enterDomainAge(String domainAge) {
        Log.info("Entering domain age.");
        domainAgeInput.sendKeys(domainAge);
    }

    public void parseDomainAge() {
        Log.info("Clearing the domain age.");
        domainAgeInput.clear();
        Log.info("Trying to parse the domain age.");
        parseServiceDomainAge.click();
        Assert.assertNotNull(domainAgeInput.getText());
    }

    public void enterServiceUrls(String serviceUrls) {
        Log.info("Clearing the service urls field");
        serviceUrlsList.clear();
        Log.info("Entering service urls.");
        serviceUrlsList.sendKeys(serviceUrls);
    }

    public void parseServiceUrls() {
        Log.info("Trying to parse service URLs");
        parseServiceUrls.click();
        Assert.assertNotNull(serviceUrlsList);
    }

    public void enterAdminServiceUrls(String adminServiceUrls) {
        Log.info("Clearing the Admin service urls field.");
        serviceAdminUrlsList.clear();
        Log.info("Entering admin service urls.");
        serviceAdminUrlsList.sendKeys(adminServiceUrls);
    }

    public void enterTermsAndConditionsUrl(String TermsAndConditionsURL) {
        Log.info("Clearing the terms and conditions urls field.");
        serviceTermsAndConditions.clear();
        Log.info("Entering Terms And Conditions url.");
        serviceTermsAndConditions.sendKeys(TermsAndConditionsURL);
    }

    public void enterServiceDescription(String ServiceDescription) {
        Log.info("Clearing the service description field.");
        serviceDescription.clear();
        Log.info("Entering service descrption.");
        serviceDescription.sendKeys(ServiceDescription);
    }

    public void parseServiceDescription() {
        Log.info("Trying to parse service description.");
        parseServiceDescription.click();
        Assert.assertNotNull(serviceDescription);
    }

    public void selectServiceCategory(String VisibleText) {
        try {
            Select selectServiceType = new Select(selctServiceCategory);
            Log.info("Selecting " + VisibleText + " service category.");
            selectServiceType.selectByVisibleText(VisibleText);
        } catch (Exception e) {
            Log.error("Service category " + VisibleText + " wasn't found.");
            throw e;
        }
    }

    public void selectServiceCategoryFP(String VisibleText) {
        try {
            Select selectServiceType = new Select(selctServiceCategoryFP);
            Log.info("Selecting " + VisibleText + " service FP category.");
            selectServiceType.selectByVisibleText(VisibleText);
        } catch (Exception e) {
            Log.error("Service FP category " + VisibleText + " wasn't found.");
            throw e;
        }
    }

    public void enteringTheLastReportedBreachDate(String LastReportedBreachDate) {
        Log.info("Clearing the last reported breach date field.");
        serviceLastReportedBreach.clear();
        Log.info("Entering the last reported breach date.");
        serviceLastReportedBreach.sendKeys(LastReportedBreachDate);
    }

    public void selectServiceCompanyType(String ServiceCompanyType) {
        try {
            Select selectServiceType = new Select(selctServiceCompanyType);
            Log.info("Selecting " + ServiceCompanyType + " service company type.");
            selectServiceType.selectByVisibleText(ServiceCompanyType);
        } catch (Exception e) {
            Log.error("Service company type " + ServiceCompanyType + " wasn't found.");
            throw e;
        }
    }

    public void parseServicePopularity() {
        Log.info("Trying to parse service popularity.");
        parsePopularity.click();
        Assert.assertNotNull(servicePopularity);
    }

    public void enterServicePopularity(String servicePopularity) {
        //Log.info("Clearing the service popularity field.");
        //parsePopularity.sendKeys(Keys.);
        Log.info("Entering service popularity.");
        parsePopularity.sendKeys(servicePopularity);
    }

    public void enterServiceFoundYear(String ServiceFoundYear) {

        Log.info("Entering service foundation year.");
        serviceFoundYear.sendKeys(ServiceFoundYear);
    }

    public void enterHeadQuartersLocation(String HeadQuartersLocation) {
        Log.info("Clearing the HQ location field.");
        serviceHQlocation.clear();
        Log.info("Entering service HQ Location.");
        serviceHQlocation.sendKeys(HeadQuartersLocation);
    }

    public void enterDataCenterLocation(String DataCenterLocation) {
        Log.info("Clearing the data center location field.");
        serviceDataCenterLocation.clear();
        Log.info("Entering data center location.");
        serviceDataCenterLocation.sendKeys(DataCenterLocation);
    }

    public void enterServiceProviderCompany(String ServiceProviderCompany) {
        Log.info("Clearing the service provider company field.");
        serviceProviderCompany.clear();
        Log.info("Entering service provider company.");
        serviceProviderCompany.sendKeys(ServiceProviderCompany);
    }

    public void enterProviderCompanyLocation(String ProviderCompanyLocation) {
        Log.info("Clearing the provider company location field.");
        serviceProviderLocation.clear();
        Log.info("Entering service provider company location.");
        serviceProviderLocation.sendKeys(ProviderCompanyLocation);
    }


    //**********************************************************************
    //----------------------ADDITIONAL_SERVICE_INFO_METHODS---------------END
    //**********************************************************************

    //**********************************************************************
    //----------------------CONSTRUCTORS---------------START
    //**********************************************************************

    //Creating four constructors in order to spread providing data methods.

    /*1-5 parameters__START
    Name
    Service type - ---------  select
    Website
    LoginPage
    parse Hosting company
    //1-5 parameters__END*/
    public void constructor_1_5(String name, String selectServiceType, String website, String loginPageUrl,
                                String hostingCompany) {
        fillServiceName(name);
        selectServiceType(selectServiceType);
        generalInfoofillServiceWebsite(website);
        fillServiceLoginUrl(loginPageUrl);
        enterHostingCompany(hostingCompany);
    }

    /*6-10 parameters__START
    Domain age
    Service URLs
    Admin service urls
    Terms and conditions
    ServiceDescription
    //6-10 parameters__END*/
    public void constructor_6_10(String serviceDomainAge, String serviceURLs, String serviceAdminUrls,
                                 String serviceTermsAndConditionsURL, String serviceDescription) {
        enterDomainAge(serviceDomainAge);
        enterServiceUrls(serviceURLs);
        enterAdminServiceUrls(serviceAdminUrls);
        enterTermsAndConditionsUrl(serviceTermsAndConditionsURL);
        enterServiceDescription(serviceDescription);
    }


    /*/11-15 parameters__START
    Category -   ------      select
    CategoryFP -------------- select
    Last reported breach
    Company type ---------- select
    Popularity
    //11-15 parameters__END*/

    public void constructor_11_15(String selectServiceCategory, String selectServiceCategoryFP, String LastReportedBreachDate,
                                  String selectCompanyType, String enterPopularity) {
        selectServiceCategory(selectServiceCategory);
        selectServiceCategoryFP(selectServiceCategoryFP);
        enteringTheLastReportedBreachDate(LastReportedBreachDate);
        selectServiceCompanyType(selectCompanyType);
        enterServicePopularity(enterPopularity);
    }

    /*16-20 parameters__START
    Found year
    Headquarters location
    Datacenter location
    Provider
    Provider location
    //16-20 parameters__END*/
    public void constructor_16_20(String serviceCompanyFoundYear, String hqLocation, String dataCenterLocation, String serviceProvider,
                                  String serviceProviderLocation) {
        enterServiceFoundYear(serviceCompanyFoundYear);
        enterHeadQuartersLocation(hqLocation);
        enterDataCenterLocation(dataCenterLocation);
        enterServiceProviderCompany(serviceProvider);
        enterProviderCompanyLocation(serviceProviderLocation);
    }
    //**********************************************************************
    //----------------------CONSTRUCTORS---------------END
    //**********************************************************************

    public ServicesAll(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
