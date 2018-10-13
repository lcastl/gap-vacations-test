package vacations.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageFactory {


    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver pDriver) {
        System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
        if (driver == null) {
            pDriver = new ChromeDriver();
            wait = new WebDriverWait(pDriver, 10);
            this.driver = pDriver;
        }
        PageFactory.initElements(pDriver, this);
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

}
