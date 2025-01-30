package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest(){

       new HomePage(driver).verifyHomeComponentPresent("Welcome to Pet Service");

    }

}