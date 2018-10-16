package vacations.utils;

import org.openqa.selenium.WebDriver;

public class TestInfo {

    public static final String environment = "https://vacations-management.herokuapp.com/users/sign_in";
    public static final String ChromedriverPath = "C:/ChromeDriver/chromedriver.exe";
    public static final String browser = "Chrome";

    private static WebDriver storedDriver;

    public static WebDriver getStoredDriver() {
        return storedDriver;
    }

    public static void setStoredDriver(WebDriver storedDriver) {
        TestInfo.storedDriver = storedDriver;
    }
}
