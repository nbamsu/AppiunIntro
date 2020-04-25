package com.techtorial.appium.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.AfterClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.Platform.ANDROID;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

public class AndroidDriverUtils {
    public static final String APIDEMOS="ApiDemos-debug";
    public static final String DEVICENAME="Baha";

    public static DesiredCapabilities setupDesiredCapabilities(String appName) {
        // connect through server to device
        File apkFile = new File("src/test/resources/" + appName + ".apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        // device name to connect
        desiredCapabilities.setCapability(DEVICE_NAME, DEVICENAME);
        // platform to use
        desiredCapabilities.setCapability(PLATFORM_NAME, ANDROID);
        // automation name
        desiredCapabilities.setCapability(AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
        // Android application to test
        desiredCapabilities.setCapability(APP, apkFile.getAbsolutePath());
        return desiredCapabilities;
    }

    public static AndroidDriver getAndroidDriver(DesiredCapabilities caps) throws MalformedURLException {
        // setting the server URL to connect to          0.0.0.0    Where is server located
        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub");
        // instantiating driver
        AndroidDriver<AndroidElement> driver = new AndroidDriver(appiumServerUrl, caps);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    @AfterClass
    public static void afterClass() throws Exception {

    }
}
