package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServicesCategoriesPage extends BasePage {
    public ServicesCategoriesPage(WebDriver driver) {
        super(driver);
    }
    // WebElement
    @FindBy(xpath = "//button[contains(text(),'Admin Section')]")
    WebElement adminSectionButton;
    @FindBy (xpath = "//a[@href='#/admin/services_categories']")
    WebElement servicesCategoriesLink;
    @FindBy  (xpath = "input[placeholder='New category title']")
    WebElement newCategoryInput;
    @FindBy  (xpath = "//button[contains(text(),'Add Category')]")
    WebElement addCategoryButton;



    // Переход в раздел Services Categories
    public ServicesCategoriesPage goToServicesCategories() {
        click(adminSectionButton);
        click(servicesCategoriesLink);
        return this;
    }

    // Добавление новой категории
    public ServicesCategoriesPage addCategory(String categoryName) {

        type(newCategoryInput, categoryName);
        click(addCategoryButton);
        return this;
    }

    // Удаление категории
    public ServicesCategoriesPage deleteCategory(String categoryName) {
        WebElement deleteButton = driver.findElement(By.xpath("//td[text()='" + categoryName + "']/following-sibling::td//button[contains(text(),'Delete')]"));
        click(deleteButton);
        driver.switchTo().alert().accept(); // Подтверждаем удаление через алерт
        return this;
    }
}