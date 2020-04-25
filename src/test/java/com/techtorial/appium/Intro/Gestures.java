package com.techtorial.appium.Intro;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Gestures {
    public static DesiredCapabilities desiredCapabilities;
    public static URL appiumServerUrl;
    public static AndroidDriver<AndroidElement> driver;

    @Before
    public void firstCall() throws MalformedURLException {

    }

    @Test
    public void tapGestures() {
        AndroidElement media = driver.findElementByAndroidUIAutomator("text(\"Media\")");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(media))).perform();
    }

    @Test
    public void customAdapter() {
        AndroidElement media = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(media))).perform();

        AndroidElement expandableList = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandableList))).perform();

        AndroidElement customAdapter = driver.findElementByAccessibilityId("1. Custom Adapter");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdapter))).perform();

        AndroidElement catNames = driver.findElementByXPath("//android.widget.TextView[@text='Cat Names']");
        Assert.assertEquals("Cat Names", catNames.getText());


    }

    @Test
    public void longPress() {
        AndroidElement media = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(media))).perform();

        AndroidElement expandableList = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandableList))).perform();

        AndroidElement customAdapter = driver.findElementByAccessibilityId("1. Custom Adapter");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdapter))).perform();

        AndroidElement peopleNames = driver.findElementByAndroidUIAutomator("text(\"People Names\")");
        touchAction.longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(2))
                .withElement(ElementOption.element(peopleNames))).perform();
        AndroidElement sampleMenu = driver.findElementByAndroidUIAutomator("text(\"Sample menu\")");
        Assert.assertEquals("Failed to verify Sample Menu is not displayed", "Sample menu", sampleMenu.getText());
        Assert.assertTrue("Failed to verify Sample Menu is not displayed", sampleMenu.isDisplayed());

    }

    @Test
    public void findElements() {
        AndroidElement media = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(media))).perform();

        AndroidElement expandableList = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandableList))).perform();

        AndroidElement customAdapter = driver.findElementByAccessibilityId("1. Custom Adapter");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdapter))).perform();

        AndroidElement fishName = driver.findElementByAndroidUIAutomator("text(\"Fish Names\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(fishName))).perform();


        List<AndroidElement> elements = driver.findElementsById("e18cfedd-6de4-435b-83a0-4a4bf211bf26");
        //findElements(("*[@text='Goldy']"),("*[@text='Goldy']"));
        for (AndroidElement elements2 : elements) {
            Assert.assertTrue(elements2.isDisplayed());
            System.out.println(elements2.isDisplayed());
        }
        System.out.println();
        System.out.println("How are you?");
//        Assert.assertTrue(elements.get(0).isDisplayed());
//        Assert.assertTrue(elements.get(1).isDisplayed());

//        AndroidElement goldy=driver.findElementByAndroidUIAutomator(("text(\"Goldy\")"));
//        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(goldy))).perform();
//
//        AndroidElement bubbles=driver.findElementByAndroidUIAutomator(("text(\"Bubbles\")"));
//        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(bubbles))).perform();
//        touchAction.longPress(LongPressOptions.longPressOptions()
//                .withElement(Duration.ofSeconds(2)).withElement(ElementOption.element(fishName)))

    }


}
