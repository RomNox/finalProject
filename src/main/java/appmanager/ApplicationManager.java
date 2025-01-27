package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class ApplicationManager {

    private WebDriver driver;

    public ApplicationManager() {
    }

    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://pets-care-u2srs.ondigitalocean.app/");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

}
