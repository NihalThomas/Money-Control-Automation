package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ScreenshotUtil;

import java.util.Map;

public class GratuityFundCalculatorPage extends BasePage {

    private By yesOption = By.xpath("//span[@class='rdbx openblock']");
    private By salaryField = By.id("salary");
    private By yearField = By.id("year");
    private By calculateButton = By.id("graduity_calc_btn");

    public GratuityFundCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void openPage(String url) {
        driver.get(url);
        removeObstructions();
        WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(yesOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", yes);
    }

    public void fillForm(Map<String, String> data) {
        WebElement salaryInput = wait.until(ExpectedConditions.elementToBeClickable(salaryField));
        salaryInput.clear();
        salaryInput.sendKeys(data.get("salary"));

        WebElement yearInput = wait.until(ExpectedConditions.elementToBeClickable(yearField));
        yearInput.clear();
        yearInput.sendKeys(data.get("years"));
    }

    public void submitForm() {
        WebElement calcButton = wait.until(ExpectedConditions.elementToBeClickable(calculateButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", calcButton);
    }

    public String takeScreenshot(String fileName) throws Exception {
    	return ScreenshotUtil.takeScreenshot(driver, fileName);
    }
    
    public void enterZeroSalary() {
        WebElement salaryInput = wait.until(ExpectedConditions.elementToBeClickable(salaryField));
        salaryInput.clear();
        salaryInput.sendKeys("0");

        WebElement yearInput = wait.until(ExpectedConditions.elementToBeClickable(yearField));
        yearInput.clear();
        yearInput.sendKeys("10"); // Default years for negative test
    }

}