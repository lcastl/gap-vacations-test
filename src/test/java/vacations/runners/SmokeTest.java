package vacations.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"vacations"},
        tags = {"@smoke"})
public class SmokeTest extends AbstractTestNGCucumberTests {
}
