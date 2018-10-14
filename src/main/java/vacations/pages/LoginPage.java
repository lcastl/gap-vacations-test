package vacations.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user_email")
    private WebElement txtEmail;

    @FindBy(id = "user_password")
    private WebElement txtPassword;

    @FindBy(className = "submit")
    private WebElement btnSignIn;

    @FindBy(css = "#header #logo")
    private WebElement siteLogo;

    @FindBy(css = "#user_information")
    private WebElement loggedUserInformation;

    @FindBy(css = "#content .flash_notice")
    private WebElement signedInSuccessfullyBanner;

    public LoginPage(WebDriver pDriver) {
        super(pDriver);
    }

    public void performLogin(String userName, String password) {
        waitUntilElementAppears(txtEmail);
        txtEmail.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnSignIn.click();
    }

    public boolean verifyUserIsAtHomePage() {
        waitUntilElementAppears(loggedUserInformation);
        return validateVisibilityOfWebElement(loggedUserInformation);
    }

    public boolean verifyTheSiteLogoIsDisplayed() {
        waitUntilElementAppears(siteLogo);
        return validateVisibilityOfWebElement(siteLogo);
    }

    public boolean verifySignedInSuccessfullyBanner() {
        waitUntilElementAppears(signedInSuccessfullyBanner);
        return validateVisibilityOfWebElement(signedInSuccessfullyBanner);
    }
}
