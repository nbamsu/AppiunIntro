package com.techtorial.appium.Intro;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LocatorTypes {
    public static DesiredCapabilities desiredCapabilities;
    public static URL appiumServerUrl;
    public static AndroidDriver<AndroidElement> driver;

    @Before
    public void firstCall() throws MalformedURLException {

        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");

        desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Baha");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); //AutoMationName.ANDROID_UIAUTOMATOR
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());

        appiumServerUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(appiumServerUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void locators(){
        AndroidElement accessibility=driver.findElementByAccessibilityId("Accessibility");
        accessibility.click();
        //className{@attribute='value']
       AndroidElement customView= driver.findElement(By.xpath("//android.widget.TextView[@text='Custom View']"));
       customView.click();
    }
    @Test
    public void lacator2(){
        //resource-id == id in selenium
        AndroidElement view=driver.findElement(By.xpath("android.widget.TextView[@text='Views']"));
        view.click();

        //"attribute("value")"
        AndroidElement customView=driver.findElementByAndroidUIAutomator("text(\"Chronometer\")");
        customView.click();
    }
}