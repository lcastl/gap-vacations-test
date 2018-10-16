package vacations.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vacations.utils.UserInformation;

import java.util.List;

public class CreateUsersPage extends BasePage {

    @FindBy(css = "#site_content h1")
    private WebElement lblNewEmployee;

    @FindBy(id = "employee_first_name")
    private WebElement txtFirstName;

    @FindBy(id = "employee_last_name")
    private WebElement txtLastName;

    @FindBy(id = "employee_email")
    private WebElement txtEmail;

    @FindBy(id = "employee_identification")
    private WebElement txtIdentification;

    @FindBy(id = "employee_leader_name")
    private WebElement txtLeaderName;

    @FindBy(id = "employee_start_working_on_1i")
    private WebElement drdStartWorkingYear;

    @FindBy(id = "employee_start_working_on_2i")
    private WebElement drdStartWorkingMonth;

    @FindBy(id = "employee_start_working_on_3i")
    private WebElement drdStartWorkingDay;

    @FindBy(name = "commit")
    private WebElement btnCreateEmployee;

    @FindBy(id = "notice")
    private WebElement lblSuccessfulMessage;

    public CreateUsersPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyNewEmployeePageIsDisplayed() {
        waitUntilElementAppears(lblNewEmployee);
        return validateVisibilityOfWebElement(lblNewEmployee);
    }

    public void enterUserInformation(List<UserInformation> userInfo) {
        String[] date;
        String year;
        String day;
        int month;

        for (UserInformation user : userInfo) {
            txtFirstName.sendKeys(user.getFirstName());
            txtLastName.sendKeys(user.getLastName());
            txtEmail.sendKeys(user.getEmail());
            txtIdentification.sendKeys(user.getIdentification());
            txtLeaderName.sendKeys(user.getLeaderName());

            date = user.getDateIn().split("-");
            day = date[0];
            month = Integer.parseInt(date[1]) - 1;
            year = date[2];

            selectFromDropDownByValue(drdStartWorkingYear, year);
            selectFromDropDownByIndex(drdStartWorkingMonth, month);
            selectFromDropDownByValue(drdStartWorkingDay, day);
        }
    }

    public void clickOnCrateEmployeeButton() {
        waitUntilElementAppears(btnCreateEmployee);
        btnCreateEmployee.click();
    }

    public boolean verifyEmployeeCreation(String successfulMessage) {
        waitUntilElementAppears(lblSuccessfulMessage);
        if (lblSuccessfulMessage.getText().trim().equals(successfulMessage.trim())) {
            return true;
        } else {
            return false;
        }
    }
}
