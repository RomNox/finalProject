package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        // Используем app.getDriver() для получения драйвера
        new HomePage(app.getDriver()).selectSignUp();
    }

    @Test
    public void newUserRegistrationPositiveTest() {
        new RegistrationPage(app.getDriver())
                .enterUserData("Alex", "Pereira", "pereira1@gmail.com", "Pereira123!")
                .checkBoxes()
                .clickOnCreateAccountButton();
        new LoginPage(app.getDriver()).verifySuccessRegistration("Welcome");
    }

    @Test
    public void newUserRegistrationNegativeTest() {
        new RegistrationPage(app.getDriver())
                .enterUserData("Alex", "Pereira", "pereira@gmail.com", "Pereira123!")
                .checkBoxes()
                .clickOnCreateAccountButton()
                .verifyMessageOfExistedUser("An error occurred during registration. You may have entered an existing email.");
    }
}
