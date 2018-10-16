package vacations.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, 15);
        this.driver = driver;
    }

    public void openTheLoginPage(String environment) {
        getDriver().get(environment);
        getDriver().manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void dispose() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

    public boolean validateVisibilityOfWebElement(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean waitUntilElementAppears(WebElement locator) {
        try {
            getWait().until(ExpectedConditions.invisibilityOf(locator));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void selectFromDropDownByValue(WebElement cmbElement, String value) {
        Select select = new Select(cmbElement);
        select.selectByValue(value);
    }

    public void selectFromDropDownByIndex(WebElement cmbElement, int value) {
        Select select = new Select(cmbElement);
        select.selectByIndex(value);
    }
}
