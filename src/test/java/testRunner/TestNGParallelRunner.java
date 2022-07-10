package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"features/Login.feature"},
        glue = {"stepDefinitions"}
)
public class TestNGParallelRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object [] [] scenarios(){
        return super.scenarios();
    }
}
