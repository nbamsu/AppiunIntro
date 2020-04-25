package com.techtorial.appium.Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;

public class apiDemosMainPage {
    public apiDemosMainPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }
    //PageFactory.initElements(new AppiumFieldDecorator(driver),ApiDemosMainPage.class)

    @AndroidFindBy(id = "Accessibility")
    AndroidElement accessibility;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Animation']")
    AndroidElement animation;
    @AndroidFindBy(id = "App")
    AndroidElement app;
    @AndroidFindBy(id = "text(\"Content\")")
    AndroidElement content;


}
