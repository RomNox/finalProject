package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BaseHelper {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

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
