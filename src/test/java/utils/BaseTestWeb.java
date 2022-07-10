package utils;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import enums.Browsers;
import enums.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepDefinitions.HooksWeb;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;


public class BaseTestWeb {

    public static Environment ENV = Environment.DEV;
    public static Browsers BR = Browsers.CHROME;
    private static final Logger LOG = LoggerFactory.getLogger(HooksWeb.class);
    private PropertyFileUtility propLib = new PropertyFileUtility();

    public void browserSetUp() throws IOException {
        switch (BR) {
            case CHROME:
                Configuration.browser = Browsers.CHROME.name();
                LOG.info(WebDriverRunner.isChrome() ? "Browser is Chrome" : "Browser is not Chrome");
                break;
            case IE:
                Configuration.browser = Browsers.IE.name();
                LOG.info(WebDriverRunner.isIE() ? "Browser is IE" : "Browser is not IE");
                break;
            case EDGE:
                Configuration.browser = Browsers.EDGE.name();
                LOG.info(WebDriverRunner.isEdge() ? "Browser is Edge" : "Browser is not Edge");
                break;
            case FIREFOX:
                Configuration.browser = Browsers.FIREFOX.name();
                LOG.info(WebDriverRunner.isFirefox() ? "Browser is Firefox" : "Browser is not firefox");
                break;
        }
        Configuration.browser = Browsers.CHROME.name();
        Configuration.holdBrowserOpen = Boolean.parseBoolean(propLib.getPropertyFileData("holdBrowserOpen"));
        Configuration.headless = Boolean.parseBoolean(propLib.getPropertyFileData("headless"));
//      Configuration.browserSize=propLib.getPropertyFileData("browserSize");
        Configuration.proxyEnabled = Boolean.parseBoolean(propLib.getPropertyFileData("proxyEnabled"));
//      Configuration.fileDownload= FileDownloadMode.PROXY;
        Configuration.screenshots= Boolean.parseBoolean(propLib.getPropertyFileData("screenshots"));
        Configuration.savePageSource=Boolean.parseBoolean(propLib.getPropertyFileData("savePageSource"));
        Configuration.reportsFolder=propLib.getPropertyFileData("reportsFolder");
//        Configuration.assertionMode= AssertionMode.SOFT;
    }
    public void envSetUp() throws IOException {
        LOG.info("Credit Web Launch");
        switch (ENV) {
            case DEV:
                Configuration.baseUrl = propLib.getPropertyFileData("devBaseUrl");
                break;
            case QA:
                Configuration.baseUrl = propLib.getPropertyFileData("qaBaseUrl");
                break;
            case STAGE:
                Configuration.baseUrl = propLib.getPropertyFileData("stageBaseUrl");
                break;
            case PROD:
                Configuration.baseUrl = propLib.getPropertyFileData("prodBaseUrl");
                break;
        }

        open(propLib.getPropertyFileData("serviceUrl"),
                propLib.getPropertyFileData("domain"),
                propLib.getPropertyFileData("username"),
                propLib.getPropertyFileData("password"));
        WebDriverRunner.clearBrowserCache();
    }
}
