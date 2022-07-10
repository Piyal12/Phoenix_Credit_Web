package pageObjects.LoginPage;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public interface LoginRetail {
    SelenideElement svg = $x("//div[@id='root']//*[name()='svg'][contains(@class,'Svg')]").as("Login Image"),
            phoenixST = $x("//div[@id='root']//*[text()='Phoenix']").as("Login Phoenix text"),
            loginToYourAccST = $x("//div[@id='root']//*[contains(text(),'Login to your Account')]").as("Login To Your Account text"),
            phTF = $x("//input[@name='phoneNumber']").as("Login PhoneNo TextField"),
            loginBTN = $x("//*[@id='root']//button[normalize-space()='Login']").as("Login Button"),
            loginErrorMsgST = $x("//div[@id='root']//*[contains(text(),'Phone Number is required')]").as("Logins Error message"),
            unRegPhNoErrormsg = $x("//div[@id='root']//p[contains(text(),'You are not registered with us')]").as("invalidPhNoErrormsg"),
            invalidPhNoMsg = $x("//div[@id='root']//p[contains(text(),'Please provide a valid Phone')]");
    WebElement svg1= WebDriverRunner.getWebDriver().findElement(By.xpath("//div[@id='root']//*[name()='svg'][contains(@class,'Svg')]"));

}
