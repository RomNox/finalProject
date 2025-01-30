package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ServicesCategoriesPage;

public class ServicesCategoriesTests extends TestBase {

    // Авторизация перед каждым тестом
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectLogIn();
        new LoginPage(driver).login("dana345@gm.com", "Dana345$");
    }

    // Тест на добавление категории
    @Test
    public void testAddCategory() {
        new ServicesCategoriesPage(driver)
                .goToServicesCategories()
                .addCategory("TestCategory")
                .verifyCategoryExists("TestCategory");
    }

    // Тест на удаление категории (предполагается, что категория уже существует)
    @Test
    public void testDeleteCategory() {
        new ServicesCategoriesPage(driver)
                .goToServicesCategories()
                .deleteCategory("TestCategory")
                .verifyCategoryDeleted("TestCategory");
    }
}
