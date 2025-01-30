package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest(){



        //driver.findElement(By.xpath("//h1[contains(text(),'Welcome to Pet Service')]"));
        //System.out.println("Home Component: " + isHomeComponentPresent());
       new HomePage(driver).verifyHomeComponentPresent("Welcome to Pet Service");

    }

}