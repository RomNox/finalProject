package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ServicesCategoriesPage;

import java.time.Duration;

public class ServicesCategoriesTests extends TestBase {

    @Test
    public void testAddAndDeleteCategory() {
        LoginPage loginPage = new LoginPage(driver);
        ServicesCategoriesPage servicesCategoriesPage = new ServicesCategoriesPage(driver);

        // Переход на страницу авторизации и логин
        loginPage.navigateToLoginPage();
        loginPage.login("admin@admin.com", "admin");

        // Убедиться, что мы на странице пользователя
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("/user")),
                "URL не изменился на страницу пользователя.");

        // Переход в раздел Services Categories
        servicesCategoriesPage.goToServicesCategories();

        // Добавление категории
        String testCategory = "TestCategory";
        servicesCategoriesPage.addCategory(testCategory);

        // Проверка, что категория добавлена
        Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.xpath("//td[text()='" + testCategory + "']"), testCategory)),
                "Новая категория не добавлена!");

        // Удаление категории
        servicesCategoriesPage.deleteCategory(testCategory);

        // Проверка, что категория удалена
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(
                        By.xpath("//td[text()='" + testCategory + "']"))),
                "Категория не была удалена!");
    }
}
