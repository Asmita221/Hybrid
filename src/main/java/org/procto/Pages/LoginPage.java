package org.procto.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.procto.Base.TestBase;

public class LoginPage extends TestBase {
    @FindBy(linkText = "Login / Signup")
    WebElement login_button;
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement Login;

    @FindBy(id="loginLink")
    WebElement loginlink;
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    public void setLogin_button(){
        login_button.click();
    }
    public boolean checkloginlink(){
        return loginlink.isEnabled();
    }

    public String validatetitle(){
        return driver.getTitle();
    }

    public HomePage Login(String un,String pass){
        username.sendKeys(un);
        password.sendKeys(pass);
        Login.click();
        return new HomePage();
    }


}
