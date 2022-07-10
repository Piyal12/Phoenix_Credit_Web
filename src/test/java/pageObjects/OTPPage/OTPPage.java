package pageObjects.OTPPage;

import com.codeborne.selenide.SetValueOptions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class OTPPage implements OTPRetail {
    public OTPPage enterOTP(String val){
        otpTF.setValue(SetValueOptions.withText(val).sensitive()).shouldBe(visible);
        return this;
    }
    public OTPPage verifyOTPPageTitle(String title){
        $("title").shouldHave(attribute("text", title));
        return this;
    }
    public OTPPage verifyOTPMsg(String msg){
        otpMsg.shouldHave(text(msg));
        return this;
    }

}
