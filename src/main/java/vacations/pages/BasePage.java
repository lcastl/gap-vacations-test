package vacations.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vacations.utils.TestInfo;

public class BasePage extends PageFactory {


    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver pDriver) {
        System.setProperty(TestInfo.driverBrowser, TestInfo.driverPath);
        if (driver == null) {
            pDriver = new ChromeDriver();
            wait = new WebDriverWait(pDriver, 15);
            this.driver = pDriver;
        }
        PageFactory.initElements(pDriver, this);
    }

    public void openTheLoginPage(String environment) {
        getDriver().get(environment);
        getDriver().manage().window().maximize();
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }

    public boolean validateVisibilityOfWebElement(WebElement element){
        try {
            element.isDisplayed();
            return true;
        }catch (Exception ex){
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

}
