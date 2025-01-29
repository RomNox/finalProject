package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    public RegistrationPage enterUserData(String firstName, String lastName, String email, String password) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(emailField, email);
        type(passwordField, password);
        return this;
    }

    @FindBy(xpath = "//input[@id='consent']")
    WebElement consent;

    @FindBy(xpath = "//input[@id='policy']")
    WebElement policy;

    public RegistrationPage checkBoxes() {
        click(consent);
        click(policy);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Create account')]")
    WebElement createAccountButton;

    public RegistrationPage clickOnCreateAccountButton() {
        click(createAccountButton);
        return new RegistrationPage(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'An error occurred during registration. You may have entered an existing email.')]")
    WebElement warningMessage;

    public RegistrationPage verifyMessageOfExistedUser(String text) {
        Assert.assertTrue(warningMessage.getText().contains(text));
        return this;
    }

    @FindBy(xpath = "//div[contains(text(),'Password must be at least 8 characters long, include one uppercase letter, one number, and one special character.')]")
    WebElement invalidPassword;

    public RegistrationPage verifyMessageOfInvalidPassword(String text) {
        Assert.assertTrue(invalidPassword.getText().contains(text));
        return this;
    }
}
