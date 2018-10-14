package vacations.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUsersPage extends BasePage {

    @FindBy(id = "notice")
    private WebElement lblSuccessfulMessage;

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

    @FindBy(id = "employee_leader_name")
    private WebElement drdStartWorkingYear;

    @FindBy(id = "employee_leader_name")
    private WebElement drdStartWorkingMonth;

    @FindBy(id = "employee_leader_name")
    private WebElement drdStartWorkingDay;

    @FindBy(name = "commit")
    private WebElement btnCreateEmployee;


    public CreateUsersPage(WebDriver pDriver) {
        super(pDriver);
    }
}
