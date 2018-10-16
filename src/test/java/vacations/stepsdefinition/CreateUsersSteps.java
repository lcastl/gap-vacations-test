package vacations.stepsdefinition;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import vacations.driver_factory.BrowserFactory;
import vacations.pages.CreateUsersPage;
import vacations.pages.HomePage;
import vacations.utils.TestInfo;
import vacations.utils.UserInformation;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class CreateUsersSteps {

    WebDriver driver;
    CreateUsersPage createUsersPage;
    HomePage homePage;

    @After
    public void quitDriver(){
        BrowserFactory.closeAllDriver();
    }

    @When("^I click on Create a new employee link$")
    public void iClickOnCreateANewEmployeeLink() {
        homePage = PageFactory.initElements(TestInfo.getStoredDriver(), HomePage.class);
        homePage.clickOnCreateANewEmployee();
    }

    @Then("^I verify that the new employee page is displayed$")
    public void iVerifyThatTheNewEmployeePageIsDisplayed() {
        createUsersPage = PageFactory.initElements(TestInfo.getStoredDriver(), CreateUsersPage.class);
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
}



