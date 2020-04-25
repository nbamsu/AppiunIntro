package com.techtorial.appium.Intro;

import com.techtorial.appium.utils.AndroidDriverUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class ExtraInfo {
    @Test
    public void getInfo() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities= AndroidDriverUtils.setupDesiredCapabilities("ApiDemos-debug");
        AndroidDriver<AndroidElement> driver=AndroidDriverUtils.getAndroidDriver(desiredCapabilities);

        System.out.println(driver.getContext());
        System.out.println(driver.getBatteryInfo().getState());
        System.out.println(driver.getOrientation());

        System.out.println(driver.isDeviceLocked());
        System.out.println(driver.isKeyboardShown());
        System.out.println(driver.isBrowser());
    }
}
