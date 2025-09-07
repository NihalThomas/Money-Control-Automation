package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ScreenshotUtil;

import java.util.Map;

public class PFCalculatorPage extends BasePage {

    private By ageField = By.id("id_your_age");
    private By basicSalaryField = By.name("basic_salary_monthly");
    private By yourContributionField = By.name("your_contribution");
    private By employerContributionField = By.name("employers_contribuion");
    private By annualSalaryIncreaseField = By.name("annual_increase_in_salary");
    private By retirementAgeField = By.name("intend_to_retire");
    private By currentEPFBalanceField = By.name("current_epf_balance");
    private By interestRateField = By.name("current_interest_rate");
    private By calculateButton = By.xpath("//img[@src='https://images.moneycontrol.com/images/wealth/calculate.gif']");

    public PFCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void openPage(String url) {
        driver.get(url);
        removeObstructions();
    }

    public void fillForm(Map<String, String> data) {
        safeSendKeys(ageField, data.get("id_your_age"));
        safeSendKeys(basicSalaryField, data.get("basic_salary_monthly"));
        safeSendKeys(yourContributionField, data.get("your_contribution"));
        safeSendKeys(employerContributionField, data.get("employers_contribuion"));
        safeSendKeys(annualSalaryIncreaseField, data.get("annual_increase_in_salary"));
        safeSendKeys(retirementAgeField, data.get("intend_to_retire"));
        safeSendKeys(currentEPFBalanceField, data.get("current_epf_balance"));
        safeSendKeys(interestRateField, data.get("current_interest_rate"));
    }

    private void safeSendKeys(By locator, String value) {
        if (value != null && !value.trim().isEmpty()) {
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(value);
        } else {
            System.out.println("Skipping empty or null value for: " + locator);
        }
    }

    public void submitForm() {
        removeObstructions();
        WebElement calcButton = wait.until(ExpectedConditions.elementToBeClickable(calculateButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", calcButton);
    }

    public String takeScreenshot(String fileName) throws Exception {
        return ScreenshotUtil.takeScreenshot(driver, fileName); //This Line
    }
}
