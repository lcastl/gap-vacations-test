package vacations.stepsdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactoryFinder;
import vacations.pages.HomePage;
import vacations.pages.LoginPage;
import vacations.utils.TestInfo;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;
    //HomePage homePage;

    public LoginSteps(){
        loginPage = new LoginPage(driver);
        //homePage = new HomePage(driver);
    }

    @Given("^I am at the GAP vacations management site$")
    public void iAmAtTheGAPVacationsManagementSite() {
        loginPage.openTheLoginPage(TestInfo.environment);
    }

    @When("^I login with a valid (.*) and (.*)$")
    public void iLoginWithAValidUserNameAndPassword(String userName, String password) {
        loginPage.performLogin(userName, password);
    }

    @Then("^I verify that the user navigated to the home page$")
    public void iVerifyThatTheUserNavigatedToTheHomePage() {
        assertThat("The user couldn't navigate to the home page", loginPage.verifyUserIsAtHomePage());
    }

    @And("^I verify that the site logo is displayed$")
    public void iVerifyThatTheSiteLogoIsDisplayed() {
        assertThat("The site's logo wasn't found", loginPage.verifyTheSiteLogoIsDisplayed());
    }

    @And("^I verify that the Signed in successfully banner is displayed$")
    public void iVerifyThatTheSignedInSuccessfullyBannerIsDisplayed() {
        assertThat("The Signed in successfully banner wasn't displayed", loginPage.verifySignedInSuccessfullyBanner());
    }
}
