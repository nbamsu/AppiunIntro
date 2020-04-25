package com.techtorial.appium.ecommerce;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SearchShoePage {
    public SearchShoePage(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "android:id/text1")
    AndroidElement country;
    @AndroidFindBy(uiAutomator = "text(\"Enter name here\")")
    AndroidElement username;
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioMale']")
    AndroidElement genderM;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    AndroidElement logInButton;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bolivia\"));")
    AndroidElement bolivia;
//    @AndroidFindBy(xpath = "")
//    AndroidElement toastMessage;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"));")
    AndroidElement jordanShoe;
    @AndroidFindBy(uiAutomator = "text(\"ADD TO CART\")")
    AndroidElement addToCard;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.androidsample.generalstore:id/appbar_btn_cart']")
    AndroidElement carts;
    @AndroidFindBy(uiAutomator = "text(\"Please read our terms of conditions\")")
    public AndroidElement termsAndCondition;
    @AndroidFindBy(uiAutomator = "text(\"Terms Of Conditions\")")
    public AndroidElement headerTermsOfCon;
    @AndroidFindBy(uiAutomator = "text(\"CLOSE\")")
    public AndroidElement closeButton;
    @AndroidFindBy(uiAutomator = "text(\"Visit to the website to complete purchase\")")
    public AndroidElement completePurchase;
}
