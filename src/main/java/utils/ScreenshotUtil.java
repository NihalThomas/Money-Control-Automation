package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver, String fileName) throws Exception {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        Path screenshotsDir = Path.of("screenshots");
        if (!Files.exists(screenshotsDir)) {
            Files.createDirectories(screenshotsDir); // ✅ Create folder if missing
        }

        Path destination = screenshotsDir.resolve(fileName + "_" + timestamp + ".png");
        Files.copy(src.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
        return destination.toAbsolutePath().toString();

    }
}
