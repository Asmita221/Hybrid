package org.procto.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.procto.Utilities.TestUtiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties properties;
    public TestBase(){
        properties = new Properties();
        try {
            FileInputStream in = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/org/procto/Config/Config.properties");
            properties.load(in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void initialize(){
        String Browser=properties.getProperty("browser");
        if (Browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }
        else if (Browser.equalsIgnoreCase("egde")){
            WebDriverManager.edgedriver().setup();
            driver= new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TestUtiles.Implicit_wait, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));

    }
    public void Capture_Screenshot(String Testname) throws IOException, InterruptedException {
        String timeStamp = new SimpleDateFormat("YYYY.mm.dd.hh.mm.ss").format(new Date());
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destfilepath = System.getProperty("user.dir")+"\\Screenshots\\"+timeStamp+Testname+".png";
        FileUtils.copyFile(src,new File(destfilepath));
    }
}

