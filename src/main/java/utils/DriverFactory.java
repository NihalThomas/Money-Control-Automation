package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                System.out.println("Initializing ChromeDriver...");
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                // Disable DevTools to avoid WebSocket issues
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
                // Optional: Run in headless mode for debugging
                // options.addArguments("--headless");
                driver = new ChromeDriver(options);
                System.out.println("ChromeDriver initialized successfully.");
            } catch (Exception e) {
                System.err.println("Failed to initialize ChromeDriver: " + e.getMessage());
                e.printStackTrace();
                throw new RuntimeException("Driver initialization failed", e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("ChromeDriver quit successfully.");
            } catch (Exception e) {
                System.err.println("Error quitting ChromeDriver: " + e.getMessage());
            }
            driver = null;
        }
    }
}