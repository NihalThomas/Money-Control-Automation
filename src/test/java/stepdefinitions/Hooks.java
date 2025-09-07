package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.AfterAll;
import utils.DriverFactory;
import utils.ExtentReportManager;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.getDriver(); // Start browser before each scenario
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver(); // Close browser after each scenario
    }

    @AfterAll
    public static void afterAll() {
        ExtentReportManager.flushReport(); // Flush report once after all scenarios
    }
}
