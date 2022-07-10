package pageObjects.OTPPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface OTPRetail {
    SelenideElement otpTF=$("input[aria-label='Please enter verification code. Digit 1']").as("OTP Text Field");
    SelenideElement otpMsg=$(By.xpath("//*[@id='root']//p[contains(text(),'An OTP')]")).as("OTP Msg");
}
