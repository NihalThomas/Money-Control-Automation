package stepdefinitions;

import io.cucumber.java.en.*;
import pages.PersonalLoanCalculatorPage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExcelReader;
import utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;

import java.util.List;
import java.util.Map;

public class PersonalLoanCalculatorSteps {
    private PersonalLoanCalculatorPage personalLoanPage = new PersonalLoanCalculatorPage(DriverFactory.getDriver());
    private ExtentTest test;

    @Given("I open the Personal Loan calculator page")
    public void i_open_personal_loan_page() {
        test = ExtentReportManager.createTest("Personal Loan Calculator Test");
        personalLoanPage.openPage(ConfigReader.getProperty("personal_loan_calculator_url"));
        test.info("Opened Personal Loan Calculator page");
    }

    @When("I fill in the Personal Loan form with data from excel {string}")
    public void i_fill_personal_loan_form(String sheetName) throws Exception {
        List<Map<String, String>> testData = ExcelReader.readExcel("src/main/resources/testdata/PersonalLoanCalculatorData.xlsx", sheetName);
        personalLoanPage.fillForm(testData.get(0));
        test.info("Filled Personal Loan form with data from " + sheetName);
    }

    @Then("I take a screenshot of the Personal Loan page")
    public void i_take_screenshot_personal_loan() throws Exception {
    	String screenshotPath = personalLoanPage.takeScreenshot("PersonalLoan");
        test.pass("Screenshot taken for Personal Loan page").addScreenCaptureFromPath(screenshotPath);
    }

    @Then("I take a screenshot of the Personal Loan negative result")
    public void i_take_screenshot_personal_loan_negative() throws Exception {
    	String screenshotPath = personalLoanPage.takeScreenshot("PersonalLoan_Negative");
        test.pass("Screenshot taken for Personal Loan negative result").addScreenCaptureFromPath(screenshotPath);
    }
}