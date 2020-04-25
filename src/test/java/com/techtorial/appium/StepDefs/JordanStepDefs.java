package com.techtorial.appium.StepDefs;

import com.techtorial.appium.Pages.JordanPage;
import com.techtorial.appium.utils.AndroidDriverUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

public class JordanStepDefs {
    AndroidDriver<AndroidElement> driver;


    @Before
    public void setUpAndroidStudio() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = AndroidDriverUtils.setupDesiredCapabilities("ecommerceApp");
        driver = AndroidDriverUtils.getAndroidDriver(desiredCapabilities);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,30);
    }


    @Given("user create an account")
    public void user_create_an_account() {
        JordanPage page=new JordanPage(driver);
        page.country.click();
        page.bolivia.click();
        page.username.click();
        page.username.sendKeys("Robo");
        if (driver.isKeyboardShown()){
            driver.hideKeyboard();
        }
        page.genderM.click();
        page.logInButton.click();


    }

    @Then("validate created account")
    public void validate_created_account() {

    }

    @When("user makes a purchase")
    public void user_makes_a_purchase() {
        JordanPage page=new JordanPage(driver);
        page.jordanShoe.click();
        page.addToCard.click();
        page.carts.click();

    }

    @Then("validate a item is bought")
    public void validate_a_item_is_bought() {
        JordanPage page=new JordanPage(driver);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions()
                .withDuration(Duration.ofSeconds(2))
                .withElement(ElementOption.element(page.termsAndCondition))).perform();
        Assert.assertTrue(page.headerTermsOfCon.isDisplayed());
        page.closeButton.click();
        page.completePurchase.click();
        Set<String> contextHandles = driver.getContextHandles();
        System.out.println(contextHandles);

        for (String window:contextHandles){
            if (window.startsWith("WEBVIEW")){
                driver.context(window);
            }
        }
            page.searchBarGoogle.sendKeys("Buy earPods"+Keys.ENTER);

    }
}
