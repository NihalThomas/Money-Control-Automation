package pages;

import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtil;

public class CarLoanEMICalculatorPage extends BasePage {

    public CarLoanEMICalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void openPage(String url) {
        driver.get(url);
        removeObstructions();
    }

    public String takeScreenshot(String fileName) throws Exception {
    	return ScreenshotUtil.takeScreenshot(driver, fileName);
    }
}