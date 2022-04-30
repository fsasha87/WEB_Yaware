package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.PropertiesReader;


import static utils.WebDriverSingleton.getDriver;

public abstract class BasePage {

    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor jse;

    {
        wait = new WebDriverWait(getDriver(), PropertiesReader.getExplicityWaitValue());
        actions = new Actions(getDriver());
        jse = (JavascriptExecutor) getDriver();
    }

    public WebElement getElement(By locator) {
        return getDriver().findElement(locator);
    }

    public BasePage checkTitle (String title){
        String titleFromPage = getDriver().getTitle();
        Assert.assertEquals(titleFromPage, title);
        return this;
    }

    public void scrollToElement(By locator) {
        actions.moveToElement(getDriver().findElement(locator));
    }

    public void waitElementIsClicable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickWithJavaScript(By locator) {
        jse.executeScript("arguments[0].click()", getDriver().findElement(locator));
    }

}
