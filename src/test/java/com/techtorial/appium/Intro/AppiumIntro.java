package com.techtorial.appium.Intro;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumIntro {
    public static AndroidDriver<AndroidElement> driver;
    public static URL appiumServerUrl;
    public static DesiredCapabilities desiredCapabilities;


    @Before
    public void firstCall() throws MalformedURLException {

        File apkFile=new File("src/test/resources/ApiDemos-debug.apk");

        desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Baha");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2); //AutoMationName.ANDROID_UIAUTOMATOR
        desiredCapabilities.setCapability(MobileCapabilityType.APP,apkFile.getAbsolutePath());
        appiumServerUrl=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver(appiumServerUrl,desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }
    @Test
    public void Call(){
        AndroidElement preference=driver.findElementByAccessibilityId("Preference");
        preference.click();
        AndroidElement defaultValues=driver.findElementByAccessibilityId("4. Default values");
        defaultValues.click();

        AndroidElement checkBox= driver.findElementById("android:id/checkbox");
        checkBox.click();
        //AndroidElement defaultValues
    }
    @Test
    public void secondCal(){
        AndroidElement media=driver.findElement(By.xpath("//android.widget.TextView[@text='Media']"));
        media.click();

    }
}
