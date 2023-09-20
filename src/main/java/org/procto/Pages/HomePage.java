package org.procto.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.procto.Base.TestBase;

import java.util.List;

public class HomePage extends TestBase {
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[2]/div/div[1]/span/a/i")
    WebElement symbol;
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[1]/div[2]/div/div[3]/div[4]/span/span[1]")
    WebElement Authenticate_user;

    @FindBy(xpath = "//div[@class='product-tab']")
    WebElement features;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String validatetitle(){
        return driver.getTitle();
    }
    public boolean verify_symbol(){
        return symbol.isDisplayed();
    }
    public String identifyuser(){
        return Authenticate_user.getText();
    }
    public void featuresAva(){
        List<WebElement> featureList = features.findElements(By.xpath("//div[@class='product-tab__title']"));
        for (WebElement a:featureList){
            System.out.println(a.getText());
        }
    }
}
