package org.procto.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.procto.Base.TestBase;

public class Health_WellnessPage extends TestBase {
    public Health_WellnessPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[@class='nav-interact']")
    WebElement corporate;
    @FindBy(linkText = "Health & Wellness Plans")
    WebElement HealthWellness;
    @FindBy(id = "name")
    WebElement Name;
    @FindBy(id = "organizationName")
    WebElement OrName;
    @FindBy(id = "contactNumber")
    WebElement ContactNo;
    @FindBy(id = "officialEmailId")
    WebElement email;
    @FindBy(id = "organizationSize")
    WebElement OrSize;
    @FindBy(id = "interestedIn")
    WebElement interestin;

    @FindBy(xpath = "//header[@id='header']//button[@type='submit'][normalize-space()='Schedule a demo']")
    WebElement submit;
    public void corporate(){
        corporate.click();
    }
    public void HealthAndWellness(){
        HealthWellness.click();
    }
    public String validatetitle(){
        return driver.getTitle();
    }
    public void EnterData(String name,String Org,String Contact,String mail,String size,String interest){
        Name.sendKeys(name);
        OrName.sendKeys(Org);
        ContactNo.sendKeys(Contact);
        email.sendKeys(mail);
        Select sc = new Select(OrSize);
        sc.selectByVisibleText(size);
        Select sc1 = new Select(interestin);
        sc1.selectByVisibleText(interest);
        submit.click();
    }
}
