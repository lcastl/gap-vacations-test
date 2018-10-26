package vacations.testcases;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import vacations.driverfactory.BrowserFactory;
import vacations.pages.CreateUsersPage;
import vacations.pages.HomePage;
import vacations.pages.LoginPage;
import vacations.pages.UsersListPage;
import vacations.utils.TestInfo;
import vacations.utils.UserInformation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;

public class VacationsTests {

    WebDriver driver;

    LoginPage loginPage;
    HomePage homePage;
    CreateUsersPage createUsersPage;
    UsersListPage usersListPage;

    @BeforeClass(alwaysRun = true)
    public void setWebDriver() {
        driver = BrowserFactory.getBrowser(TestInfo.browser);
    }

    @AfterClass
    public void quitDriver() {
        BrowserFactory.closeAllDriver();
    }

    @DataProvider(name = "getUserInfo")
    public Object[][] getData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/resources/data/UserData.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("userInfo");
        List<UserInformation> testData = new Gson().fromJson(dataSet, new TypeToken<List<UserInformation>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }

    @Test(description = "Given I am at the GAP vacations management site")
    public void openGapVacationSite() {
        loginPage = new LoginPage(driver);
        loginPage.openTheLoginPage(TestInfo.environment);
        assertThat("login page is not visible", loginPage.verifyLoginPageIsVisible());
    }

    @Test(description = "When I login with a valid user name and password")
    @Parameters({"userName", "password"})
    public void loginWitValidCredentials(String userName, String password) {
        loginPage.performLogin(userName, password);
    }

    @Test(description = "Then I verify that the user navigated to the home page")
    public void verifyThatTheUserNavigatedToTheHomePage() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        assertThat("The user couldn't navigate to the home page", homePage.verifyUserIsAtHomePage());
    }

    @Test(description = "And I verify that the site logo is displayed")
    public void verifyThatTheSiteLogoIsDisplayed() {
        assertThat("The site's logo wasn't found", homePage.verifyTheSiteLogoIsDisplayed());
    }

    @Test(description = "And I verify that the Signed in successfully banner is displayed")
    public void verifyThatTheSignedInSuccessfullyBannerIsDisplayed() {
        assertThat("The Signed in successfully banner wasn't displayed", homePage.verifySignedInSuccessfullyBanner());
    }

    @Test(description = "Given I am at the home page")
    public void givenIamAtTheHomePage() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.verifyUserIsAtHomePage();
    }

    @Test(description = "When I click on Create a new employee link")
    public void clickOnCreateANewEmployeeLink() {
        homePage.clickOnCreateANewEmployee();
    }

    @Test(description = "The I verify that the new employee page is displayed")
    public void verifyThatTheNewEmployeePageIsDisplayed() {
        createUsersPage = PageFactory.initElements(driver, CreateUsersPage.class);
        assertThat("The new employee page wasn't displayed", createUsersPage.verifyNewEmployeePageIsDisplayed());
    }

    @Test(description = "When I enter the employee information", dataProvider = "getUserInfo")
    public void enterTheEmployeeInformation(UserInformation userInfo) {
        createUsersPage.enterUserInformation(userInfo);
    }

    @Test(description = "And I click on Create Employee button")
    public void clickOnCreateEmployeeButton() {
        createUsersPage.clickOnCrateEmployeeButton();
    }

    @Test(description = "Then I verify that the message is displayed")
    @Parameters("successfulMessage")
    public void verifyThatTheMessageIsDisplayed(String successfulMessage) {
        assertThat("The employee was not created", createUsersPage.verifyEmployeeCreation(successfulMessage));
    }

    @Test(description = "When I search for a given user in the list")
    @Parameters("leaderName")
    public void searchForAGivenUserInTheList(String leaderName) {
        usersListPage = PageFactory.initElements(driver, UsersListPage.class);
        usersListPage.searchUser(leaderName);
    }

    @Test(description = "Then I verify that the found user information is the same than the given user", dataProvider = "getUserInfo")
    public void verifyThatTheFoundUserInformationIsTheSameThanTheGivenUser(UserInformation userInfo) {
        assertThat("The user was not found", usersListPage.verifyUserInformationMatches(userInfo));
    }
}
