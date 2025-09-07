package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ScreenshotUtil;

import java.util.Map;

public class PersonalLoanCalculatorPage extends BasePage {

    private By amountField = By.id("amount1");
    private By interestField = By.id("amount2");
    private By tenureField = By.id("amount3");

    public PersonalLoanCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void openPage(String url) {
        driver.get(url);
        removeObstructions();
    }

    public void fillForm(Map<String, String> data) {
        removeObstructions();
        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(amountField));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", amountInput);
        amountInput.clear();
        amountInput.sendKeys(data.get("loan_amount"));

        WebElement interestInput = wait.until(ExpectedConditions.visibilityOfElementLocated(interestField));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", interestInput);
        interestInput.clear();
        interestInput.sendKeys(data.get("interest_rate"));

        WebElement tenureInput = wait.until(ExpectedConditions.visibilityOfElementLocated(tenureField));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tenureInput);
        tenureInput.clear();
        tenureInput.sendKeys(data.get("tenure"));

        try {
            Thread.sleep(1000); // Wait for results
        } catch (InterruptedException e) {
        }
    }

    public String takeScreenshot(String fileName) throws Exception {
    	return ScreenshotUtil.takeScreenshot(driver, fileName);
    }
}