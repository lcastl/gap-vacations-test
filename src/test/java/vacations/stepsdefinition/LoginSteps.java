package vacations.stepsdefinition;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import vacations.driver_factory.BrowserFactory;
import vacations.pages.HomePage;
import vacations.pages.LoginPage;
import vacations.utils.TestInfo;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginSteps {

    private WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @Before
    public void beforeTest() {
        driver = BrowserFactory.getBrowser("Chrome");
        TestInfo.setStoredDriver(driver);
    }

    @Given("^I am at the GAP vacations management site$")
    public void iAmAtTheGAPVacationsManagementSite() {
        loginPage = new LoginPage(driver);
        loginPage.openTheLoginPage(TestInfo.environment);
    }

    @When("^I login with a valid (.*) and (.*)$")
    public void iLoginWithAValidUserNameAndPassword(String userName, String password) {
        loginPage.performLogin(userName, password);
    }

    @Then("^I verify that the user navigated to the home page$")
    public void iVerifyThatTheUserNavigatedToTheHomePage() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        assertThat("The user couldn't navigate to the home page", homePage.verifyUserIsAtHomePage());
    }

    @And("^I verify that the site logo is displayed$")
    public void iVerifyThatTheSiteLogoIsDisplayed() {
        assertThat("The site's logo wasn't found", homePage.verifyTheSiteLogoIsDisplayed());
    }

    @And("^I verify that the Signed in successfully banner is displayed$")
    public void iVerifyThatTheSignedInSuccessfullyBannerIsDisplayed() {
        assertThat("The Signed in successfully banner wasn't displayed", homePage.verifySignedInSuccessfullyBanner());
    }
}
