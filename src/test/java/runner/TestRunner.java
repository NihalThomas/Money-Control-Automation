package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utils.DriverFactory;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        Object[][] scenarios = super.scenarios();
        System.out.println("Found " + scenarios.length + " scenarios to execute.");
        if (scenarios.length == 0) {
            System.out.println("No scenarios found. Check feature files, tags, and glue path.");
        } else {
            for (Object[] scenario : scenarios) {
                System.out.println("Scenario: " + scenario[0]);
            }
        }
        return scenarios;
    }

    @Parameters({"cucumber.tags"})
    public void setCucumberTags(String tags) {
        if (tags != null && !tags.isEmpty()) {
            System.out.println("Applying tags: " + tags);
            System.setProperty("cucumber.filter.tags", tags);
        } else {
            System.out.println("No tags provided in testng.xml.");
        }
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}