package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://pets-care-u2srs.ondigitalocean.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }

    public boolean isHomeComponentPresent(){
        return driver.findElements(By.xpath("//h1[contains(text(),'Welcome to Pet Service')]")).size()>0;
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }




    
}
