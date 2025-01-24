package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseHelper {
    protected WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(BaseHelper.class);

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void clearAndType(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
        logger.debug("Entered text '{}' into field '{}'", text, field.getAttribute("id"));
    }
}
