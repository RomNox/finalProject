package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest(){
        //driver.findElement(By.xpath("//h1[contains(text(),'Welcome to Pet Service')]"));
        //System.out.println("Home Component: " + isHomeComponentPresent());
        Assert.assertTrue(isHomeComponentPresent());
    }

}
