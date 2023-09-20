package org.procto.testcases;

import org.procto.Base.TestBase;
import org.procto.Pages.HomePage;
import org.procto.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPage_Test extends TestBase {
    LoginPage login;
    HomePage home;
    public LoginPage_Test(){
        super(); // to read properties file first from base class
    }
    @BeforeClass
    public void Setup(){
        initialize();
        login = new LoginPage();
    }
    @Test(priority = 1)
    public void login_button(){
        login.setLogin_button();
    }
    @Test(priority = 2)
    public void verifyLink(){
        Assert.assertTrue(login.checkloginlink());
    }
    @Test(priority = 3)
    public void checktitle(){
        Assert.assertEquals(login.validatetitle(),"Practo Accounts");
    }
    @Test(priority = 4)
    public void login_test(){
        home = login.Login(properties.getProperty("username"),properties.getProperty("password"));
    }
    @AfterClass
    public void close(){
        driver.quit();
    }

}
