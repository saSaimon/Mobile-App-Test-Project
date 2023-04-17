import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SecondTest {
    String appiumUrl = "http://127.0.0.1:4723/wd/hub";
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appPackage", "com.google.android.deskclock");
        capabilities.setCapability("appium:appActivity", "com.android.deskclock.DeskClock");
        capabilities.setCapability("noRest", true);
        URL url = new URL(appiumUrl);
        driver = new AndroidDriver(url,capabilities);
        wait = new WebDriverWait(driver, 15);


    }
    @Test
    public void test(){
        MobileElement el1 = (MobileElement) driver.findElement(By.id("com.google.android.deskclock:id/fab"));
        el1.click();
//        MobileElement el2 = (MobileElement) driver.findElement(new MobileBy.ByAccessibilityId("plus"));
//        el2.click();
        MobileElement el2 = (MobileElement) driver.findElement(By.id("com.google.android.deskclock:id/search_src_text"));
        el2.sendKeys("Brazil");

    }
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
