package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest(){
        new HomePage(driver).verifyHomeComponentPresentTest("Welcome to Pet Service");
    }

}
