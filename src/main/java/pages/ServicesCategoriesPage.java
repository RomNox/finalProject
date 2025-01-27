package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ServicesCategoriesPage extends BasePage {

    // Локаторы
    private final By adminSectionButton = By.xpath("//button[contains(text(),'Admin Section')]");
    private final By servicesCategoriesLink = By.xpath("//a[@href='#/admin/services_categories']");
    private final By newCategoryInput = By.cssSelector("input[placeholder='New category title']");
    private final By addCategoryButton = By.xpath("//button[contains(text(),'Add Category')]");

    public ServicesCategoriesPage(WebDriver driver) {
        super(driver);
    }

    // Переход в раздел Services Categories
    public void goToServicesCategories() {
        click(driver.findElement(adminSectionButton));
        click(driver.findElement(servicesCategoriesLink));
    }

    // Добавление новой категории
    public void addCategory(String categoryName) {
        clearAndType(driver.findElement(newCategoryInput), categoryName);
        click(driver.findElement(addCategoryButton));
    }

    // Удаление категории
    public void deleteCategory(String categoryName) {
        WebElement deleteButton = driver.findElement(By.xpath("//td[text()='" + categoryName + "']/following-sibling::td//button[contains(text(),'Delete')]"));
        click(deleteButton);
        driver.switchTo().alert().accept(); // Подтверждаем удаление через алерт
    }
}
