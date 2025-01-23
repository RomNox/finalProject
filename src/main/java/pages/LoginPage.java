package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = ".error-message") // Убедитесь, что селектор корректен
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        driver.get("https://pets-care-u2srs.ondigitalocean.app/#/login");
    }
    /**
     * Выполняет логин с указанными email и паролем.
     *
     * @param email    Email пользователя
     * @param password Пароль пользователя
     */
    public void login(String email, String password) {
        logger.info("Attempting to login with email: {}", email);

        clearAndType(emailField, email);
        clearAndType(passwordField, password);
        loginButton.click();

        logger.info("Login button clicked.");
    }

    /**
     * Проверяет, отображается ли сообщение об ошибке.
     *
     * @return true, если сообщение об ошибке отображается, иначе false
     */
    public boolean isErrorMessageDisplayed() {
        try {
            boolean isDisplayed = errorMessage.isDisplayed();
            logger.info("Error message displayed: {}", isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            logger.warn("Error message element not found.");
            return false;
        }
    }

    /**
     * Получает текст сообщения об ошибке.
     *
     * @return Текст сообщения об ошибке, если он есть, иначе пустая строка
     */
    public String getErrorMessageText() {
        try {
            String errorText = errorMessage.getText();
            logger.info("Error message text: {}", errorText);
            return errorText;
        } catch (Exception e) {
            logger.warn("Unable to retrieve error message text.");
            return "";
        }
    }

    /**
     * Возвращает веб-элемент сообщения об ошибке.
     *
     * @return WebElement сообщения об ошибке
     */
    public WebElement getErrorMessage() {
        return errorMessage;
    }

    /**
     * Утилитный метод для очистки поля и ввода текста.
     *
     * @param field Поле ввода
     * @param text  Текст для ввода
     */
    private void clearAndType(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
        logger.debug("Entered text '{}' into field '{}'", text, field.getAttribute("id"));
    }
}