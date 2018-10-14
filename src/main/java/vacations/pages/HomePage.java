package vacations.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = "#header #logo")
    private WebElement siteLogo;

    @FindBy(css = "#user_information")
    private WebElement loggedUserInformation;

    @FindBy(css = "#content .flash_notice")
    private WebElement signedInSuccessfullyBanner;

    public HomePage(WebDriver pDriver) {
        super(pDriver);
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
