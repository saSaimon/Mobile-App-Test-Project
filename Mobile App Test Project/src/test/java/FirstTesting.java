import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.bytebuddy.build.ToStringPlugin;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class FirstTesting {

    String appiumUrl = "http://127.0.0.1:4723/wd/hub";
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("noRest", true);
        URL url = new URL(appiumUrl);
        driver = new AndroidDriver(url,capabilities);
        wait = new WebDriverWait(driver, 30);


    }
    @Test
    public void test(){
        MobileElement el1 = (MobileElement) driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElement(new MobileBy.ByAccessibilityId("plus"));
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElement(By.id("com.android.calculator2:id/digit_4"));
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElement(new MobileBy.ByAccessibilityId("equals"));
        el4.click();
        MobileElement result = driver.findElement(By.id("com.android.calculator2:id/result"));
        Assert.assertEquals(result.getText(), "6");

    }
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
