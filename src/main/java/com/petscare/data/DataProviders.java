package com.petscare.data;

import com.petscare.models.UserData;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() {
        return new Object[][]{
                {new UserData("admin@admin.com", "admin", "admin")},  // Администратор
//                {new UserData("Romaykin@admin.com", "0682620798Ro@", "user")}  // Обычный пользователь
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

    @DataProvider
    public Iterator<Object[]> registrationOfNewUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Alex", "Pereira", "pereira70010@gmail.com", "Pereira123!"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationOfExistedUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Alex", "Pereira", "pereira@gmail.com", "Pereira123!"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationWithInvalidPassword(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Alex", "Pereira", "pereira@gmail.com", "11111111111"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationWithInvalidEmail(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Alex", "Pereira", "pereiragmail.com", "Admin123!"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationWithoutCheckboxes(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Alex", "Pereira", "pereira@gmail.com", "Admin123!"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationWithoutFirstName(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"", "Pereira", "pereira@gmail.com", "Admin123!"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationWithoutLastName(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Alex", "", "pereira@gmail.com", "Admin123!"});
        return list.iterator();
    }
}
