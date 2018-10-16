package vacations.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import vacations.driver_factory.BrowserFactory;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"vacations"},
        tags = {"@smoke"})

public class SmokeTest extends AbstractTestNGCucumberTests {
    @AfterTest
    public void quitDriver() {
        BrowserFactory.closeAllDriver();
    }
}

