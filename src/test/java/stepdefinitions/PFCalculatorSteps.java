package stepdefinitions;

import io.cucumber.java.en.*;
import pages.PFCalculatorPage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExcelReader;
import utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;

import java.util.List;
import java.util.Map;

public class PFCalculatorSteps {
    private PFCalculatorPage pfPage = new PFCalculatorPage(DriverFactory.getDriver());
    private ExtentTest test;

    @Given("I open the PF calculator page")
    public void i_open_pf_calculator_page() {
        test = ExtentReportManager.createTest("PF Calculator Test");
        pfPage.openPage(ConfigReader.getProperty("pf_calculator_url"));
        test.info("Opened PF Calculator page");
    }

    @When("I fill in the PF form details with data from excel {string}")
    public void i_fill_in_pf_form_details(String sheetName) throws Exception {
        List<Map<String, String>> testData = ExcelReader.readExcel("src/main/resources/testdata/PFCalculatorData.xlsx", sheetName);
        pfPage.fillForm(testData.get(0));
        test.info("Filled PF form with data from " + sheetName);
    }

    @When("I submit the PF form without values")
    public void i_submit_pf_form_without_values() {
        pfPage.submitForm();
        test.info("Submitted PF form without values");
    }

    @And("I click on the calculate button for PF")
    public void i_click_calculate_button() {
        pfPage.submitForm();
        test.info("Clicked calculate button");
    }

    @Then("I take a screenshot of the PF result")
    public void i_take_screenshot() throws Exception {
    	String screenshotPath = pfPage.takeScreenshot("PF_Result"); //This Line and Below
    	test.pass("Screenshot taken for PF result").addScreenCaptureFromPath(screenshotPath);
    }

    @Then("I take a screenshot of the PF negative result")
    public void i_take_screenshot_negative() throws Exception {
    	String screenshotPath = pfPage.takeScreenshot("PF_Negative"); // This Line and Below
    	test.pass("Screenshot taken for PF negative result").addScreenCaptureFromPath(screenshotPath);
    }
}