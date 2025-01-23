package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class ApplicationManager {

    private WebDriver driver;

    public ApplicationManager(String chrome) {
    }

    /**
     * Инициализация WebDriver и открытие главной страницы.
     */
    public void init() {
        // Создание экземпляра WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Открытие главной страницы
        driver.get("https://pets-care-u2srs.ondigitalocean.app/");
    }

    /**
     * Возвращает текущий экземпляр WebDriver.
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Закрытие WebDriver после выполнения тестов.
     */
    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
