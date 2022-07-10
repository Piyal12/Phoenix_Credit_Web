package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"@target/surefire-reports/failedrerun.txt"},
        glue = {"stepDefinitions"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/surefire-reports/failedrerun.txt"}
)
public class FailedRunner extends AbstractTestNGCucumberTests {
}
