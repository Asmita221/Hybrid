package org.procto.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.procto.Base.TestBase;

import java.util.Objects;

public class SignupPage extends TestBase {
    public SignupPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "registerLink")
    public WebElement register;
    @FindBy(linkText = "Register Here")
    WebElement Dr_register;

    @FindBy(id = "name")
    WebElement FullName;

    @FindBy(id = "country")
    WebElement countrycode;

    @FindBy(id = "mobile")
    WebElement mobileNo;

    @FindBy(id = "password")
    WebElement Password;
    @FindBy(id = "EmailRegister")
    public WebElement submit;

    public void Register(){
        register.click();


    }
    public boolean Dr_reg(){
        return Dr_register.isDisplayed();
    }
    public void Add_details(String name,String mobile_no,String Create_pass){
        FullName.sendKeys(name);
        Select sc= new Select(countrycode);
        sc.selectByVisibleText("+91(IND)");
        mobileNo.sendKeys(mobile_no);
        Password.sendKeys(Create_pass);
        submit.click();
    }
}
