package pages;

import org.openqa.selenium.By;

public class InnerPage extends BasePage{
    String innerPageTitle = "Yaware.TimeTracker - Автоматический учет времени и продуктивности";
    By workerButton = By.xpath("//a[@title='Сотрудники']");


    public InnerPage clickWorkerButton(){
        getElement(workerButton).click();
        return this;
    }

    public InnerPage verifyTitle(){
        checkTitle(innerPageTitle);
        return this;
    }

}
