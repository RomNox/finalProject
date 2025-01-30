package tests;

import data.DataProviders;
import models.UserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTests extends TestBase {

    // Переход на страницу логина перед каждым тестом
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectLogIn();
    }

    // Успешный вход с валидными данными
    @Test(dataProvider = "validLoginData", dataProviderClass = DataProviders.class)
    public void testLoginWithValidData(UserData user) {
        new LoginPage(driver)
                .login(user.getEmail(), user.getPassword())
                .verifySuccessLogin("/user");
    }

    // Ошибка при входе с неверными данными
    @Test(dataProvider = "invalidLoginDataWithoutEmptyFields", dataProviderClass = DataProviders.class)
    public void testLoginWithInvalidData(UserData user) {
        new LoginPage(driver)
                .login(user.getEmail(), user.getPassword())
                .verifyErrorMessage("Произошла ошибка. Попробуйте позже.");
    }

    // Проверка валидации пустых полей
    @Test(dataProvider = "emptyFieldsData", dataProviderClass = DataProviders.class)
    public void testEmptyFieldsValidation(String email, String password) {
        new LoginPage(driver)
                .login(email, password)
                .verifyEmptyFieldsValidation(email, password); // Теперь передаем параметры
    }
}