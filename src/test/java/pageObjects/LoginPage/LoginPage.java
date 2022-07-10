package pageObjects.LoginPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SetValueOptions;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import utils.GenericUtilsWeb;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class LoginPage extends GenericUtilsWeb implements LoginRetail {
    public LoginPage SVGfontsizeshouldHave(String val) {
        svg.shouldHave(Condition.cssValue("font-size", val + "px"));
        String cssValue = svg1.getCssValue("font-size");
        System.out.println(cssValue);
        return this;
    }

    public LoginPage LoginBtnshouldHave(String val) {
        loginBTN.shouldHave(Condition.cssValue("font-size", val + "px"), Condition.interactable);
        return this;
    }

    public LoginPage clickOnLoginBtnIfEnable() {
        if (loginBTN.isEnabled()) {
            loginBTN.click();
        }
        return this;
    }

    public LoginPage enterPhNoInLoginBtn(String phNo) {
        if (loginBTN.isEnabled()) {
//            phTF.setValue(SetValueOptions.withText(phNo).withDisplayedText("79******13")).shouldBe(Condition.visible);
            phTF.setValue(SetValueOptions.withText(phNo)).shouldBe(Condition.visible);
        }
        return this;
    }

    public LoginPage verifyPhoenixTxt(String msg) {
        phoenixST.shouldBe(Condition.visible, Condition.exactText(msg));
        return this;
    }

    public LoginPage verifyLoginTxt(String msg) {
        loginToYourAccST.shouldBe(Condition.visible, Condition.exactText(msg));
        return this;
    }

    public LoginPage verifyLoginPageUrl() {
        WebDriver wrappedDriver = loginToYourAccST.getWrappedDriver();
        assertNotNull(wrappedDriver);
        String currentUrl = wrappedDriver.getCurrentUrl();
        assertTrue(currentUrl.contentEquals("https://admin:1nfr4.m4rk3t@web.inframarket.cloud/login"), "Current URL is " + currentUrl);
        return this;
    }

    public LoginPage verifyPhNoNotRegisteredErrorMsg(String msg) {
        unRegPhNoErrormsg.shouldBe(Condition.visible, Condition.exactText(msg), Condition.cssValue("font-size", "12px"));
        return this;
    }

    public LoginPage verifyInvalidPhNoMsg(String invalidtext) {
        invalidPhNoMsg.shouldBe(Condition.visible, Condition.exactText(invalidtext), Condition.cssValue("font-size", "12px"));
        return this;
    }
}





