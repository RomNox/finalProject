package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'Welcome')]")
    WebElement welcomeText;

    public LoginPage verifySuccessRegistration(String text) {
        Assert.assertTrue(welcomeText.getText().contains(text));
        return this;
    }

    @FindBy(xpath = "//div[contains(text(),'An error occurred during registration. You may have entered an existing email.')]")
    WebElement warningMessage;

    public LoginPage verifyMessageOfExistedUser(String text) {
        Assert.assertTrue(warningMessage.getText().contains(text));
        return this;
    }


    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;



    public void login(String email, String password) {
        logger.info("Attempting to login with email: {}", email);

       type(emailField, email);
       type(passwordField, password);
        loginButton.click();

        logger.info("Login button clicked.");
    }

}