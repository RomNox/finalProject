package tests;

import data.DataProviders;
import models.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageTests extends TestBase {

    @Test(dataProvider = "validLoginData", dataProviderClass = DataProviders.class)
    public void testLoginWithValidData(UserData user) {
        // Использование app из TestBase
        LoginPage loginPage = new LoginPage(app.getDriver());

        loginPage.navigateToLoginPage();
        loginPage.login(user.getEmail(), user.getPassword());

        WebDriverWait wait = new WebDriverWait(app.getDriver(), Duration.ofSeconds(20));
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("/user")),
                "URL не изменился на страницу пользователя.");
    }

    @Test(dataProvider = "invalidLoginDataWithoutEmptyFields", dataProviderClass = DataProviders.class)
    public void testLoginWithInvalidData(UserData user) {
        LoginPage loginPage = new LoginPage(app.getDriver());

        loginPage.navigateToLoginPage();
        loginPage.login(user.getEmail(), user.getPassword());

        WebDriverWait wait = new WebDriverWait(app.getDriver(), Duration.ofSeconds(20));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'text-red-500') and contains(text(), 'Произошла ошибка. Попробуйте позже.')]")
        ));
        Assert.assertNotNull(errorMessage, "Сообщение об ошибке не найдено.");
    }

    @Test(dataProvider = "emptyFieldsData", dataProviderClass = DataProviders.class)
    public void testEmptyFieldsValidation(String email, String password) {
        LoginPage loginPage = new LoginPage(app.getDriver());

        loginPage.navigateToLoginPage();

        WebElement emailField = app.getDriver().findElement(By.id("email"));
        WebElement passwordField = app.getDriver().findElement(By.id("password"));
        emailField.clear();
        passwordField.clear();

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        app.getDriver().findElement(By.cssSelector("form")).submit();

        JavascriptExecutor js = (JavascriptExecutor) app.getDriver();
        String emailValidationMessage = (String) js.executeScript("return arguments[0].validationMessage;", emailField);
        String passwordValidationMessage = (String) js.executeScript("return arguments[0].validationMessage;", passwordField);

        if (email.isEmpty()) {
            Assert.assertEquals(emailValidationMessage, "Заполните это поле.", "Валидация для поля Email не работает.");
        }
        if (password.isEmpty()) {
            Assert.assertEquals(passwordValidationMessage, "Заполните это поле.", "Валидация для поля Password не работает.");
        }
    }
}
