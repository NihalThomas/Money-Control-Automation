package stepdefinitions;

import io.cucumber.java.en.*;
import pages.CarLoanEMICalculatorPage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;

public class CarLoanEMICalculatorSteps {
    private CarLoanEMICalculatorPage carLoanPage = new CarLoanEMICalculatorPage(DriverFactory.getDriver());
    private ExtentTest test;

    @Given("I open the Car Loan EMI calculator page")
    public void i_open_car_loan_page() {
        test = ExtentReportManager.createTest("Car Loan EMI Calculator Test");
        carLoanPage.openPage(ConfigReader.getProperty("car_loan_emi_calculator_url"));
        test.info("Opened Car Loan EMI Calculator page");
    }

    @Then("I take a screenshot of the Car Loan page")
    public void i_take_screenshot_car_loan() throws Exception {
    	String screenshotPath = carLoanPage.takeScreenshot("CarLoan");
        test.pass("Screenshot taken for Car Loan page").addScreenCaptureFromPath(screenshotPath);
    }
}