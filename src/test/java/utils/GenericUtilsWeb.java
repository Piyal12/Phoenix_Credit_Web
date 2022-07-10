package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WindowType;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.switchTo;

public class GenericUtilsWeb {

    public GenericUtilsWeb acceptAlert(){
        switchTo().alert().accept();
        return this;
    }
    public GenericUtilsWeb fetchAlert(){
        switchTo().alert().getText();
        return this;
    }
    public GenericUtilsWeb dismissAlert(){
        switchTo().alert().dismiss();
        return this;
    }
    public GenericUtilsWeb sendAlertMSg(String msg){
        switchTo().alert().sendKeys(msg);
        return this;
    }
    public GenericUtilsWeb swicthToFrameById(int num){
        switchTo().frame(num);
        return this;
    }
    public GenericUtilsWeb switchToFrameByName(String name){
        switchTo().frame(name);
        return this;
    }
    public GenericUtilsWeb switchToFrameByEle(SelenideElement ele){
        switchTo().frame(ele);
        return this;
    }
    public GenericUtilsWeb switchToInnerFrame(String firstframe,String otherframe){
        switchTo().innerFrame(firstframe,otherframe);
        return this;
    }
    public GenericUtilsWeb swithToParentFrame(){
        switchTo().parentFrame();
        return this;
    }
    public GenericUtilsWeb switchToDefaultFrame(){
        switchTo().defaultContent();
        return this;
    }

    public GenericUtilsWeb switchToWindowById(int num){
        switchTo().window(num);
        return this;
    }
    public GenericUtilsWeb switchToWindowByname(String name){
        switchTo().window(name);
        return this;
    }
    public GenericUtilsWeb switchToWindowByTitle(String title){
        switchTo().window(Selenide.title());
        return this;
    }
    public GenericUtilsWeb switchToNewWindow(){
        switchTo().newWindow(WindowType.WINDOW);
        return this;
    }
    public GenericUtilsWeb switchToNewTab(){
        switchTo().newWindow(WindowType.TAB);
        return this;
    }
    public GenericUtilsWeb moveToElement(SelenideElement ele){
        actions().moveToElement(ele).build().perform();
        return this;
    }
    public GenericUtilsWeb dragAndDrop(SelenideElement srcele,SelenideElement targetele){
        actions().dragAndDrop(srcele,targetele).build().perform();
        return this;
    }
    public GenericUtilsWeb rightClick(SelenideElement ele){
        actions().contextClick(ele).build().perform();
        return this;
    }
    public GenericUtilsWeb dragAndDropBy(SelenideElement ele,int val1,int val2){
        actions().dragAndDropBy(ele,val1,val2).build().perform();
        return this;
    }
    public GenericUtilsWeb clickAndHold(){
        actions().clickAndHold().build().perform();
        return this;
    }
    public GenericUtilsWeb doubleClick(SelenideElement ele){
        actions().doubleClick(ele).build().perform();
        return this;
    }
    public GenericUtilsWeb dropDownByID(SelenideElement ele,int index){
        ele.selectOption(index);
        return this;
    }
    public GenericUtilsWeb dropDownByString(SelenideElement ele,String text){
        ele.selectOption(text);
        return this;
    }
    public GenericUtilsWeb dropDownByStringValue(SelenideElement ele,String val){
        ele.selectOptionByValue(val);
        return this;
    }
    public GenericUtilsWeb selectRadio(SelenideElement ele,String val){
        ele.selectRadio(val);
        return this;
    }
    public GenericUtilsWeb getSelectedOptions(SelenideElement ele){
        ele.getSelectedOptions();
        return this;
    }
    public GenericUtilsWeb getSelectedOption(SelenideElement ele){
        ele.getSelectedOption();
        return this;
    }
    public GenericUtilsWeb getAttribute(SelenideElement ele,String attribute){
        ele.getAttribute(attribute);
        return this;
    }
}
