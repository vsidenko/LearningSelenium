package pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Log;

public class NavigationElements {
    WebDriver driver;
    //_____UserProfileDropdown(Login+Profile)*************Elements STARTS

    @FindBy(css = ".hidden-xs")
    private static WebElement menuToogleUserNameDropdown;
    @FindBy(css = ".user-footer .pull-right .btn-default")
    private static WebElement logoutButton;
    @FindBy(css = ".user-footer .pull-left .btn-default")
    private static WebElement userProfileInDropdownMenu;

    //______________UserProfileDropdown(Login+Profile)*************Elements ENDS
    public void clickMenuToggleUserNameDropdown() {
        try {
            Log.info("Check if menu toggle 'username' dropdown is displayed");
            menuToogleUserNameDropdown.isDisplayed();
            Log.info("Click the menu toggle 'username' dropdown.");
            menuToogleUserNameDropdown.click();
        }catch (NoSuchElementException e){
            Log.error("The menu toggle 'username' wasn't found or not clickable.");
            throw e;
        }
    }
    public void clickLogoutButton() {
        try {
            Log.info("Check 'Logout' button is displayed");
            logoutButton.isDisplayed();
            Log.info("Click 'Logout' button.");
            logoutButton.click();
        }catch (NoSuchElementException e){
            Log.error("The 'Logout' button wasn't found or not clickable.");
            throw e;
        }
    }



    //______________UserProfileDropdown(Login+Profile)*****************Methods STARTS


    //______________UserProfileDropdown(Login+Profile)*****************Methods ENDS

    public NavigationElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
