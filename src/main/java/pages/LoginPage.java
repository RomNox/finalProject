package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class LoginPage extends BasePage {

    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Локаторы
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, 'text-red-500')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//h2[contains(text(),'Welcome')]")
    WebElement welcomeText;

    // Вход в систему
    public LoginPage login(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        click(loginButton);
        return this;
    }

    // Проверка успешного входа
    public LoginPage verifySuccessLogin(String expectedUrlPart) {
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains(expectedUrlPart)),
                "URL не изменился!");
        return this;
    }

    // Проверка сообщения об ошибке
    public LoginPage verifyErrorMessage(String expectedMessage) {
        Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(errorMessage, expectedMessage)),
                "Ошибка не отображается!");
        return this;
    }

    // Проверка валидации пустых полей
    public LoginPage verifyEmptyFieldsValidation() {
        Assert.assertEquals(getValidationMessage(emailField), "Заполните это поле.", "Email без валидации!");
        Assert.assertEquals(getValidationMessage(passwordField), "Заполните это поле.", "Password без валидации!");
        return this;
    }

    // Получение валидационного сообщения браузера
    private String getValidationMessage(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", element);
    }
    // Успешная регистрация пользователя и переход на страницу регистрации
    public LoginPage verifySuccessRegistration(String text) {
        Assert.assertTrue(welcomeText.getText().contains(text));
        return this;
    }
}
