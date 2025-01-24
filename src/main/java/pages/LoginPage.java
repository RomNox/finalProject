package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import helpers.BaseHelper;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
  
  private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

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


    public void navigateToLoginPage() {
        driver.get("https://pets-care-u2srs.ondigitalocean.app/#/login");
    }

    public void login(String email, String password) {
        logger.info("Attempting to login with email: {}", email);

        clearAndType(emailField, email);
        clearAndType(passwordField, password);
        loginButton.click();

        logger.info("Login button clicked.");
    }

}
