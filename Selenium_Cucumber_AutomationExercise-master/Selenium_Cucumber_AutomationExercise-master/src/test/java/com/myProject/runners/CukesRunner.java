package com.myProject.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/default-html-reports.html"
        },
        features = "src/test/resources/features/RestAPIDemo.feature",
        glue = {"com/myProject/stepDefinitions"},
        dryRun = false,
        tags = "@Regression,@Smoke"

)
public class CukesRunner {
}
