package data;

import models.UserData;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() {
        return new Object[][]{
                {new UserData("admin@admin.com", "admin", "admin")},  // Администратор
                {new UserData("Romaykin@admin.com", "0682620798Ro@", "user")}  // Обычный пользователь
        };
    }

    @DataProvider(name = "invalidLoginDataWithoutEmptyFields")
    public Object[][] invalidLoginDataWithoutEmptyFields() {
        return new Object[][]{
                {new UserData("invalid_email@example.com", "wrongpassword", "user")}, // Неверный email и пароль
                {new UserData("admin@admin.com", "wrongpassword", "admin")},         // Неверный пароль для администратора
                {new UserData("user@user.com", "wrongpassword", "user")}             // Неверный пароль для пользователя
        };
    }

    @DataProvider(name = "emptyFieldsData")
    public Object[][] emptyFieldsData() {
        return new Object[][]{
                {"", ""},               // Оба поля пустые
                {"validemail@example.com", ""}, // Только пароль пустой
                {"", "validpassword"}   // Только email пустой
        };
    }
}
