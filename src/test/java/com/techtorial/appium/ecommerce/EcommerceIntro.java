package com.techtorial.appium.ecommerce;

import com.techtorial.appium.utils.AndroidDriverUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

public class EcommerceIntro {
    AndroidDriver<AndroidElement> driver;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = AndroidDriverUtils.setupDesiredCapabilities("ecommerceApp");
        driver = AndroidDriverUtils.getAndroidDriver(desiredCapabilities);
    }

    @Test
    public void test1Positive() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.country.click();
        logInPage.bolivia.click();

        logInPage.username.click();
        logInPage.username.sendKeys("Victory");
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }
        logInPage.genderM.click();
        logInPage.logInButton.click();


    }

    @Test
    public void testNegative() {
        LogInPage page = new LogInPage(driver);
        page.logInButton.click();

        AndroidElement toastMessage = driver.findElementByXPath("//android.widget.Toast");
        //driver.findElement(By.xpath("//android.widget.Toast"));
        String message = toastMessage.getAttribute("name");

        Assert.assertEquals("Please enter your name", message);
    }

    @Test
    public void AirJordanShoes() {
        SearchShoePage page = new SearchShoePage(driver);

        page.country.click();
        page.bolivia.click();

        page.username.click();
        page.username.sendKeys("Victory");
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }
        page.genderM.click();
        page.logInButton.click();
        page.jordanShoe.click();
        page.addToCard.click();
        page.carts.click();

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions()
                .withDuration(Duration.ofSeconds(2))
                .withElement(ElementOption.element(page.termsAndCondition))).perform();
        Assert.assertTrue(page.headerTermsOfCon.isDisplayed());
        page.closeButton.click();
        page.completePurchase.click();
        Set<String> contextHandles = driver.getContextHandles();
        System.out.println(contextHandles);

        String contextName="WEBVIEW_com.androidsample.generalstore";
        driver.context(contextName);
        for (String window:contextHandles){
            if (window.startsWith("WEBVIEW")){
                driver.context(window);
            }
        }
        WebElement erma=driver.findElement(By.xpath("//input[@name='q']"));
        erma.sendKeys("Erma");





    }


}
