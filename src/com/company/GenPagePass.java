package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Admin on 22.04.15.
 */
//Page Object

public class GenPagePass {

    public static void setField(String field, String value){
        TestHelper.chromeDriver.findElement(By.xpath("//td[text()='" + field + "']/following::input[1]")).sendKeys(value);
    }

    public static String getField(String field){
        return TestHelper.chromeDriver.findElement(By.xpath("//td[text()='"+ field + "']/following::input[1]")).getAttribute("value");
    }

    public static void generate(){
        TestHelper.chromeDriver.findElement(By.xpath("//td[text()='Generated password']/preceding::input[1]")).click();
    }

    public static void openPass(){
        TestHelper.chromeDriver.get("http://angel.net/~nic/passwd.sha1.1a.html");
    }

    public static void openTranslate(){
        TestHelper.chromeDriver.get("https://translate.google.com");
        //TestHelper.chromeDriver.get("https://translate.google.com/#en/ru/hello");
    }
}
