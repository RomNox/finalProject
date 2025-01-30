package tests;

import org.openqa.selenium.By;
import appmanager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

//import static pages.LoginPage.logger;

public class TestBase   {

    protected ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));
    WebDriver driver;

    @BeforeMethod
    public void setUp(Method method){
        driver = app.startTest();
       // logger.info("Start test: " + method.getName());
    }

//    @BeforeMethod
//    public void setUp() {
//        app = new ApplicationManager();
//        app.init();
//    }

    @AfterMethod(enabled = false)
    public void tearDown(ITestResult result){
        if (result.isSuccess()){
            logger.info("Test result: PASSED " + result.getMethod().getMethodName());
        } else {
            logger.error("Test result: FAILED " + result.getMethod().getMethodName());
        }
        logger.info("***************************************************************");
        app.stopTest();
    }




}
