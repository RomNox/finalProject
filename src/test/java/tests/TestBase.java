package tests;

import appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected ApplicationManager app;

    @BeforeMethod
    public void setUp() {
        // Указываем браузер (по умолчанию Chrome)
        app = new ApplicationManager("chrome");
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        // Завершаем сессию браузера
        app.stop();
    }
}
