package vacations.stepsdefinition;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import vacations.driver_factory.BrowserFactory;
import vacations.pages.CreateUsersPage;
import vacations.pages.HomePage;
import vacations.pages.LoginPage;
import vacations.pages.UsersListPage;
import vacations.utils.TestInfo;
import vacations.utils.UserInformation;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginSteps {

    private WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CreateUsersPage createUsersPage;
    UsersListPage usersListPage;

    @Before
    public void beforeTest() {
        driver = BrowserFactory.getBrowser(TestInfo.browser);
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

    @Given("^I am at the home page$")
    public void iAmAtTheHomePage() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.verifyUserIsAtHomePage();
    }

    @When("^I click on Create a new employee link$")
    public void iClickOnCreateANewEmployeeLink() {
        homePage.clickOnCreateANewEmployee();
    }

    @Then("^I verify that the new employee page is displayed$")
    public void iVerifyThatTheNewEmployeePageIsDisplayed() {
        createUsersPage = PageFactory.initElements(driver, CreateUsersPage.class);
        assertThat("The new employee page wasn't displayed", createUsersPage.verifyNewEmployeePageIsDisplayed());
    }

    @When("^I enter the employee information$")
    public void iEnterTheEmployeeInformation(List<UserInformation> userInfo) {
        createUsersPage.enterUserInformation(userInfo);

    }

    @And("^I click on Create Employee button$")
    public void iClickOnCreateEmployeeButton() {
        createUsersPage.clickOnCrateEmployeeButton();
    }

    @Then("^I verify that the message (.*) is displayed$")
    public void iVerifyThatTheMessageIsDisplayed(String successfulMessage) {
        assertThat("The employee was not created", createUsersPage.verifyEmployeeCreation(successfulMessage));
    }

    @When("^I search for a given user (.*) in the list$")
    public void iSearchForAGivenUserInTheList(String leaderName) {
        usersListPage = PageFactory.initElements(driver, UsersListPage.class);
        usersListPage.searchUser(leaderName);
    }

    @Then("^I verify that the found user information is the same than the given user$")
    public void iVerifyThatTheFoundUserInformationIsTheSameThanTheGivenUser(DataTable userInfo) {
        assertThat("The user was not found", usersListPage.verifyUserInformationMatches(userInfo));
    }

}
