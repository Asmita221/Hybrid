package org.procto.testcases;

import org.procto.Base.TestBase;
import org.procto.Pages.HomePage;
import org.procto.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePage_Test extends TestBase {
    HomePage home;
    LoginPage login;
    public HomePage_Test(){
        super();
    }
    @BeforeClass
    public void Setup(){
        initialize();
        login = new LoginPage();
        login.setLogin_button();
        home = login.Login(properties.getProperty("username"), properties.getProperty("password"));
    }
    @Test(priority = 1)
    public void verifyTitle(){
        Assert.assertEquals(driver.getTitle(),home.validatetitle());
    }
    @Test(priority = 2)
    public void verifySymbol(){
        Assert.assertTrue(home.verify_symbol());
    }
    @Test(priority = 3)
    public void AuthenticateUser(){
        Assert.assertEquals(home.identifyuser(),"Asmita Raut");
    }
    @Test(priority = 4)
    public void list_feature(){
        System.out.println("List of features contains on home page...");
        home.featuresAva();
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
