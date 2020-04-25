package com.techtorial.appium.Intro;

import com.techtorial.appium.utils.AndroidDriverUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.List;

public class SwipeAction {
    AndroidDriver<AndroidElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = AndroidDriverUtils.setupDesiredCapabilities("ApiDemos-debug");
        driver = AndroidDriverUtils.getAndroidDriver(caps);
    }

    @Test
    public void swipe() {
        TouchAction touchAction = new TouchAction(driver);
        AndroidElement views = driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Views\"]");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();

        AndroidElement dateWidgets = driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(dateWidgets))).perform();
        AndroidElement inlineText = driver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(inlineText))).perform();

//        AndroidElement num15=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TimePicker/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[3]"));
//        AndroidElement num40=driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='40']"));
        AndroidElement num15=driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='15']"));
        AndroidElement num40=driver.findElement(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='40']"));
        touchAction.longPress(ElementOption.element(num15)).moveTo(ElementOption.element(num40)).perform().release();

        List<AndroidElement>time=driver.findElementsByXPath("//android.widget.TextView");
        AndroidElement actualTime=driver.findElementById("android:id/time_header");
        AndroidElement hours=driver.findElementById("android:id/hours");
        AndroidElement minutes=driver.findElementById("android:id/minutes");
        AndroidElement column=driver.findElementById("android:id/separator");

        Assert.assertEquals("5:40",hours.getText()+column.getText()+minutes.getText());

        String finalTime="";
        for (AndroidElement element:time){
            finalTime+=element.getText();
        }
        Assert.assertTrue(finalTime.contains("5:40"));

    }
}





