package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertiesReader;
import utils.WebDriverSingleton;

import static utils.WebDriverSingleton.getDriver;

public abstract class BaseTest {
    @BeforeMethod
    public void setUp() {
        getDriver().get(PropertiesReader.getUrl());
    }

    @AfterMethod(enabled = true, alwaysRun = true)
    public void tearDown() {
        WebDriverSingleton.close();
    }
}
