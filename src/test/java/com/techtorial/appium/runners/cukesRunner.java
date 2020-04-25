package com.techtorial.appium.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target\\cucumber-html-report","json:target\\cucumber.json","junit:target\\cucumber.xml"},
        features = "src\\test\\resources\\features\\Jordan.feature",
        glue ="com\\techtorial\\appium\\StepDefs",
        tags = "",
        dryRun = false

)



public class cukesRunner {
}
