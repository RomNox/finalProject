package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import appmanager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tests.listeners.TestListener;

import java.time.Duration;

public class TestBase {

    WebDriver driver;
  
  @BeforeMethod
    public void setUp() {
        app = new ApplicationManager();
        app.init();
    }
  
  @AfterMethod
    public void tearDown() {
        if (app != null) {
            WebDriver driver = app.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }
    }
  
  
    public boolean isHomeComponentPresent(){
        return driver.findElements(By.xpath("//h1[contains(text(),'Welcome to Pet Service')]")).size()>0;
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }



@Listeners(TestListener.class)
public class TestBase {
    protected ApplicationManager app;
    

}

