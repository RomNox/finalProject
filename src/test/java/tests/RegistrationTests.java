package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).selectSignUp();
    }

    @Test
    public void newUserRegistrationPositiveTest(){
        new RegistrationPage(driver)
                .enterUserData("Alex", "Pereira", "pereira7@gmail.com", "Pereira123!")
                .checkBoxes()
                .clickOnCreateAccountButton();
        new LoginPage(driver).verifySuccessRegistration("Welcome");
    }

    @Test
    public void newUserRegistrationNegativeTest(){
        new RegistrationPage(driver)
                .enterUserData("Alex", "Pereira", "pereira@gmail.com", "Pereira123!")
                .checkBoxes()
                .clickOnCreateAccountButton()
                .verifyMessageOfExistedUser("An error occurred during registration. You may have entered an existing email.");
    }

    @Test
    public void registrationWithInvalidPasswordNegativeTest(){
        new RegistrationPage(driver)
                .enterUserData("Alex", "Pereira", "pereira@gmail.com", "qqqqqqqqq")
                .checkBoxes()
                .clickOnCreateAccountButton()
                .verifyMessageOfInvalidPassword("Password must be at least 8 characters long, include one uppercase letter, one number, and one special character.");
    }

    @Test
    public void registrationWithInvalidEmailNegativeTest(){
        new RegistrationPage(driver)
                .enterUserData("Alex", "Pereira", "pereiragmail.com", "Admin123!")
                .checkBoxes()
                .clickOnCreateAccountButton();
        Assert.assertTrue(verifyMessageOfInvalidEmail());
    }

    @Test
    public void registrationWithoutCheckboxesNegativeTest(){
        new RegistrationPage(driver)
                .enterUserData("Alex", "Pereira", "pereiragmail.com", "Admin123!")
                .clickOnCreateAccountButton();
        Assert.assertTrue(checkBoxValidationTest());
    }
}
