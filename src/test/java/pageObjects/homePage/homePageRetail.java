package pageObjects.homePage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public interface homePageRetail{
    SelenideElement accountCircleLnk= $x("//*[@id='root']//*[name()='svg' and contains(@data-testid,'AccountCircle')]").as("AccCircleLnk"),
                    userNameTxt=$x("//ul[@role='menu']//p[contains(@class,'Mui') and contains(text(),'')]//self::p").as("User Name Txt"),
                    logoutLnk=$x("//p[normalize-space()='Logout']").as("Logout Button");

}
