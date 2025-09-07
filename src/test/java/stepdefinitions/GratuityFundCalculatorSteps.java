package stepdefinitions;

import io.cucumber.java.en.*;
import pages.GratuityFundCalculatorPage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExcelReader;
import utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;

import java.util.List;
import java.util.Map;

public class GratuityFundCalculatorSteps {
    private GratuityFundCalculatorPage gratuityPage = new GratuityFundCalculatorPage(DriverFactory.getDriver());
    private ExtentTest test;

    @Given("I open the Gratuity Fund calculator page")
    public void i_open_gratuity_fund_calculator_page() {
        test = ExtentReportManager.createTest("Gratuity Fund Calculator Test");
        gratuityPage.openPage(ConfigReader.getProperty("gratuity_fund_calculator_url"));
        test.info("Opened Gratuity Fund Calculator page");
    }

    @When("I fill in the Gratuity Fund form with data from excel {string}")
    public void i_fill_gratuity_fund_form(String sheetName) throws Exception {
        List<Map<String, String>> testData = ExcelReader.readExcel("src/main/resources/testdata/GratuityFundCalculatorData.xlsx", sheetName);
        gratuityPage.fillForm(testData.get(0));
        test.info("Filled Gratuity Fund form with data from " + sheetName);
    }
    
    
    @When("I enter zero salary and submit the form")
    public void i_enter_zero_salary_and_submit_form() {
        test = ExtentReportManager.createTest("Gratuity Fund Calculator Negative Test - Salary Zero");
        gratuityPage.enterZeroSalary();
        gratuityPage.submitForm();
        test.info("Entered zero salary and clicked submit");
    }

    @And("I click on the submit button for Gratuity")
    public void i_click_on_the_submit_button() {
        gratuityPage.submitForm();
        test.info("Clicked submit button for Gratuity");
    }

    @Then("I take a screenshot of the Gratuity Fund result")
    public void i_take_screenshot_of_gratuity_result() throws Exception {
    	String screenshotPath = gratuityPage.takeScreenshot("GratuityFund");
        test.pass("Screenshot taken for Gratuity Fund result").addScreenCaptureFromPath(screenshotPath);
    }
    
    @Then("I take a screenshot of the Gratuity Fund negative result")
    public void i_take_screenshot_of_gratuity_negative_result() throws Exception {
        String screenshotPath = gratuityPage.takeScreenshot("GratuityFund_Negative");
        test.pass("Screenshot taken for Gratuity Fund negative result")
            .addScreenCaptureFromPath(screenshotPath);
    }
}