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

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void performLogin(String userName, String password) {
        waitUntilElementAppears(txtEmail);
        txtEmail.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnSignIn.click();
    }

    public boolean verifyLoginPageIsVisible() {
        return validateVisibilityOfWebElement(txtEmail);
    }
}
