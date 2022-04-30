package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    By loginField = By.cssSelector("#email");
    By passField = By.cssSelector("#password");
    By enterButton = By.cssSelector("#login-submit");


    public LoginPage typeLogin(String login){
        getElement(loginField).sendKeys(login);
    return this;
    }

    public LoginPage typePassword(String pass){
        getElement(passField).sendKeys(pass);
        return this;
    }

    public LoginPage clickEnterButton (){
        getElement(enterButton).click();
        return this;
    }


}
