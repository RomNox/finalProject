package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tests.listeners.TestListener;

@Listeners(TestListener.class)
public class TestBase {

    protected ApplicationManager app; // Инициализация ApplicationManager

    @BeforeMethod
    public void setUp() {
        app = new ApplicationManager(); // Создание объекта ApplicationManager
        app.init(); // Инициализация драйвера в ApplicationManager
    }

    @AfterMethod
    public void tearDown() {
        if (app != null) {
            app.stop(); // Завершение работы драйвера через ApplicationManager
        }
    }

    /**
     * Проверка наличия главного компонента на странице.
     * @return true, если элемент найден; false, если нет.
     */
    public boolean isHomeComponentPresent() {
        return app.getDriver()
                .findElements(By.xpath("//h1[contains(text(),'Welcome to Pet Service')]"))
                .size() > 0;
    }

    /**
     * Проверка наличия элемента на странице.
     * @param locator Локатор элемента.
     * @return true, если элемент найден; false, если нет.
     */
    public boolean isElementPresent(By locator) {
        return app.getDriver().findElements(locator).size() > 0;
    }
}

