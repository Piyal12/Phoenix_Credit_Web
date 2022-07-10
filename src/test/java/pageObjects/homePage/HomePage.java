package pageObjects.homePage;

import com.codeborne.selenide.Condition;
import utils.GenericUtilsWeb;

public class HomePage extends GenericUtilsWeb implements homePageRetail {
    public HomePage clickOnAccCircleLnk(){
        accountCircleLnk.shouldHave(Condition.visible,Condition.interactable,Condition.cssValue("font-size","24px")).click();
        return this;
    }
    public HomePage validateUserName(String name){
        userNameTxt.shouldHave(Condition.exactText(name),Condition.visible,Condition.cssValue("font-size","15px"));
        return this;
    }
    public HomePage clickOnLogoutButton(){
        logoutLnk.shouldHave(Condition.visible,Condition.interactable,Condition.cssValue("font-size","15px")).click();
        return this;
    }
}
