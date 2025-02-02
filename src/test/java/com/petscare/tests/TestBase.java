package com.petscare.tests;

import com.petscare.appmanager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;


public class TestBase   {

    protected ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));
    WebDriver driver;

    @BeforeMethod
    public void setUp(Method method){
        driver = app.startTest();
    }

        @AfterMethod
        public void tearDown() {
            app.stopTest();
        }

}



