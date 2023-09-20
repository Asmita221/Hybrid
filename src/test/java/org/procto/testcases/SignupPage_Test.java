package org.procto.testcases;

import org.procto.Base.TestBase;
import org.procto.Pages.LoginPage;
import org.procto.Pages.SignupPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class SignupPage_Test extends TestBase {
    LoginPage login;
    SignupPage signup;
    public SignupPage_Test(){
        super();
    }
    @BeforeClass
    public void Setup(){
        initialize();
        login = new LoginPage();
        login.setLogin_button();
        signup = new SignupPage();
    }
    @Test(priority = 1)
    public void Register_button(){
        signup.Register();
        Assert.assertTrue(signup.register.isEnabled());
    }
    @Test(priority = 2)
    public void check_dr_reg(){
        Assert.assertTrue(signup.Dr_reg());
    }
    @Test(priority = 3)
    public void AddDetails(){
        signup.Add_details(properties.getProperty("fullname"), properties.getProperty("username"), properties.getProperty("password") );
        Assert.assertTrue(signup.submit.isEnabled());
    }

    @AfterClass
    public void close(){
        driver.quit();
    }

}
