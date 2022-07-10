package stepDefinitions;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SimpleReport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;
import utils.BaseTestWeb;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;


public class HooksWeb extends BaseTestWeb {
    private final SimpleReport report = new SimpleReport();
    private static final Logger LOG = LoggerFactory.getLogger(HooksWeb.class);

    @Before(order = 1)
    public void setUp() throws IOException {
        browserSetUp();
    }

    @Before(order = 3)
    public void urlSetup() throws IOException {
        envSetUp();
    }

    @Before(order = 2)
    public void beforeTest(Scenario scenario) {
        scenario.log("Starting " + scenario.getName());
        report.start();
    }

    @After(order = 2)
    public void afterTest(Scenario scenario) {
        scenario.log("Finished " + scenario.getName());
        report.finish(scenario.getName());
        if (scenario.isFailed()) {
            LOG.info(scenario.getName() + " is Failed");
            byte[] screenshot = screenshot(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }

    @After(order = 1)
    public void tearDown_Logout() {
        LOG.info("Logout from Application");
    }

    @After(order = 3)
    public void tearDown_Close() {
        LOG.info("close the Browser");
    }

    public static void takeElementScreenshot(WebElement ele, String fileName){
        TakesScreenshot srcShot = ele;
        File srcFile=srcShot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile,new File("./target/screenshots/"+fileName+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

