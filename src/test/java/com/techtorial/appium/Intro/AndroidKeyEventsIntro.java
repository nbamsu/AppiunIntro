package com.techtorial.appium.Intro;

import com.techtorial.appium.utils.AndroidDriverUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class AndroidKeyEventsIntro {
    AndroidDriver<AndroidElement> driver;
    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=AndroidDriverUtils.setupDesiredCapabilities("ApiDemos-debug");
        driver=AndroidDriverUtils.getAndroidDriver(desiredCapabilities);
    }
    @Test
    public void keys(){
        TouchAction touchAction = new TouchAction(driver);
        AndroidElement views = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();

        AndroidElement dateWidgets = driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(dateWidgets))).perform();
        AndroidElement inlineText = driver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(inlineText))).perform();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

    }

}
