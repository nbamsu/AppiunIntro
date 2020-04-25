package com.techtorial.appium.Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JordanPage {
    public JordanPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "android:id/text1")
    public AndroidElement country;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bolivia\"));")
    public AndroidElement bolivia;
    @AndroidFindBy(uiAutomator = "text(\"Enter name here\")")
    public AndroidElement username;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioMale']")
    public AndroidElement genderM;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public AndroidElement logInButton;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"));")
    public AndroidElement jordanShoe;
    @AndroidFindBy(uiAutomator = "text(\"ADD TO CART\")")
    public AndroidElement addToCard;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']")
    public AndroidElement carts;
    @AndroidFindBy(uiAutomator = "text(\"Please read our terms of conditions\")")
    public AndroidElement termsAndCondition;
    @AndroidFindBy(uiAutomator = "text(\"Terms Of Conditions\")")
    public AndroidElement headerTermsOfCon;
    @AndroidFindBy(uiAutomator = "text(\"CLOSE\")")
    public AndroidElement closeButton;
    @AndroidFindBy(uiAutomator = "text(\"Visit to the website to complete purchase\")")
    public AndroidElement completePurchase;
    @FindBy(xpath = "//input[@name='q']")
    public WebElement searchBarGoogle;

}
