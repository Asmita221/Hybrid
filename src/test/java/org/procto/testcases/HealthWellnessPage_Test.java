package org.procto.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.procto.Base.TestBase;
import org.procto.Pages.Health_WellnessPage;
import org.procto.Pages.LoginPage;
import org.procto.Pages.SignupPage;
import org.procto.Utilities.TestUtiles;
import org.testng.Assert;
import org.testng.annotations.*;


public class HealthWellnessPage_Test extends TestBase {
    LoginPage login;
    Health_WellnessPage health;
    String sheetName = "HealthAndWellness";
    public HealthWellnessPage_Test(){
        super();
    }
    @BeforeClass
    public void Setup(){
        initialize();
        health = new Health_WellnessPage();
    }
    @Test(priority = 1)
    public void health_plan(){
        health.corporate();
    }
    @Test(priority = 2)
    public void healthwellness(){
        health.HealthAndWellness();
        Assert.assertEquals(driver.getTitle(),health.validatetitle());
    }
    @DataProvider
    public Object[][] getscriptData(){
        Object data [][] = TestUtiles.getTestData(sheetName);
        return data;

    }
    @Test(priority = 3,dataProvider = "getscriptData")
    public void FillInfo(String name,String org,String No,String mail,String size,String Intr) throws InterruptedException {
        health.EnterData(name, org, No, mail, size, Intr);
        driver.navigate().refresh();
    }
    @AfterClass
    public void close(){
        driver.quit();
    }

}
