package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

}
