package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.PropertiesReader;

public class WorkerPage extends BasePage {
    By inactiveWorkersButton = By.xpath("//a[@href='#inactive-users']");
    By importWorkersButton = By.cssSelector("#button-1096");
    By openFileInModalButton = By.cssSelector("#modal #file");
    By importButton = By.cssSelector("#yaware-modal-button-0");
    By repeatImportButton = By.xpath("//button[@data-name-button]");
    By workersQuantityButton = By.xpath("//a[contains(@href, '#active-users')]/span");
    int workersBeforeImport = 0;
    By modalTitleLabel = By.cssSelector("#myModalLabel");
    String modalTitle = "Импорт сотрудников";


    public WorkerPage clickInactiveWorkersButton() {
        waitElementIsClicable(inactiveWorkersButton);
        getElement(inactiveWorkersButton).click();
        workersBeforeImport = Integer.parseInt(getElement(workersQuantityButton).getText());
        return this;
    }

    public WorkerPage clickImportWorkersButton() {
        scrollToElement(importWorkersButton);
        clickWithJavaScript(importWorkersButton);
        return this;
    }

    public WorkerPage sendFile() {
        getElement(openFileInModalButton).sendKeys(PropertiesReader.getFilePath());
        return this;
    }


    public WorkerPage importButtonClick() {
        clickWithJavaScript(importButton);
        return this;
    }

    public WorkerPage repeatImportButtonClick() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitElementIsClicable(repeatImportButton);
        clickWithJavaScript(repeatImportButton);
        return this;
    }


    public WorkerPage verifyWorkersQuantityBeforeAfterImport() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitElementIsClicable(workersQuantityButton);
        int workersAfterImport = Integer.parseInt(getElement(workersQuantityButton).getText());
        Assert.assertTrue((workersBeforeImport < workersAfterImport), "Workers were not imported");
        return this;
    }

    public WorkerPage verifyModalTitle() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getElement(modalTitleLabel).getText(), modalTitle);
        softAssert.assertAll();
        return this;
    }

}
