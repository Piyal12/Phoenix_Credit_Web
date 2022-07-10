package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/Login.feature"},
        glue = {"stepDefinitions"},
        dryRun = false,
//        tags = "not @skip",
//        tags = "Regression",
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "rerun:target/surefire-reports/failedrerun.txt"}
)
public class TestNGBatchRunner extends AbstractTestNGCucumberTests {
}
