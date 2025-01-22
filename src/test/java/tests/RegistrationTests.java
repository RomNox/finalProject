package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTests extends TestBase{

    @Test
    public void newUserRegistrationPosTest(){

        //click on sign up button

        driver.findElement(By.cssSelector("[href='#/register']")).click();
        //enter first name
        driver.findElement(By.xpath("//input[@id='firstName']")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).clear();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Alex");
        //enter last name
        driver.findElement(By.xpath("//input[@id='lastName']")).click();
        driver.findElement(By.xpath("//input[@id='lastName']")).clear();
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Pereira");
        //enter email
        driver.findElement(By.xpath("//input[@id='email']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pereira@gm.com");
        //enter password
        driver.findElement(By.xpath("//input[@id='password']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pereira123!");
        //check checkboxes
        driver.findElement(By.xpath("//input[@id='consent']")).click();
        driver.findElement(By.xpath("//input[@id='policy']")).click();
        //click on create account
        driver.findElement(By.xpath("//button[contains(text(),'Create account')]")).click();
        //verify that Welcome is present
        Assert.assertTrue(isElementPresent(By.xpath("//h2[contains(text(),'Welcome')]")));

    }

    @Test
    public void existedUserRegistrationNegTest(){

        driver.findElement(By.cssSelector("[href='#/register']")).click();

        driver.findElement(By.xpath("//input[@id='firstName']")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).clear();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Alex");

        driver.findElement(By.xpath("//input[@id='lastName']")).click();
        driver.findElement(By.xpath("//input[@id='lastName']")).clear();
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Pereira");

        driver.findElement(By.xpath("//input[@id='email']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("leeden585@gmail.com");

        driver.findElement(By.xpath("//input[@id='password']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Pereira123!");

        driver.findElement(By.xpath("//input[@id='consent']")).click();
        driver.findElement(By.xpath("//input[@id='policy']")).click();

        driver.findElement(By.xpath("//button[contains(text(),'Create account')]")).click();

        Assert.assertTrue(isElementPresent(By.xpath("//div[contains(text(),'An error occurred during registration. You may have entered an existing email.')]")));

    }

    public boolean isAlertDisplayed(){
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        if (alert == null){
            return false;
        } else {
            return true;
        }
    }
}
