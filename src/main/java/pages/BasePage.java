package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

    public WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clearAndType(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
        logger.debug("Entered text '{}' into field '{}'", text, field.getAttribute("id"));
    }

    public void click(WebElement element) {
        element.click();
        logger.debug("Clicked on element '{}'", element.toString());
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
            logger.debug("Typed text '{}' into element '{}'", text, element.toString());
        }
    }
}
