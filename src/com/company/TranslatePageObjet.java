package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Created by Admin on 29.04.15.
 */
@RunWith(JUnit4.class)
public class TranslatePageObjet {

    /*
    public static void main(String[] args) {
        checklangs();
    }

    public static void checklangs(){
        List <WebElement> langs = TestHelper.chromeDriver.findElements(By.className("goog-menuitem goog-option"));
        System.out.println(langs);
    }
    */

    @Before
    public void init(){
        TestHelper.init();
        GenPagePass.openTranslate();
    }

    @After
    public void tearDown(){
        TestHelper.tearDown();
    }

    /*
    @Test
    public void buttonTranslate(){
        TestHelper.chromeDriver.findElement(By.id("gt-submit")).click();
    }

    @Test
    public void checkTitle(){
        Assert.assertEquals("Google Translate", TestHelper.chromeDriver.getTitle());
    }

    @Test
    public void elementsDisplayed(){
        Assert.assertTrue(TestHelper.chromeDriver.findElement(By.className("jfk-button-img")).isDisplayed());
        Assert.assertTrue(TestHelper.chromeDriver.findElement(By.id("gt-submit")).isDisplayed());
        Assert.assertTrue(TestHelper.chromeDriver.findElement(By.xpath("//div[@id='itamenu']/following::span[2]")).isDisplayed());
    }


    @Test
    public void nothingResultBox(){
        Assert.assertEquals("span", TestHelper.chromeDriver.findElement(By.id("result_box")).getTagName());        ;
    }

    */

    @Test
    public void checkLanguages(){
        TestHelper.chromeDriver.findElement(By.id("gt-sl-gms")).click();
        WebElement a = TestHelper.chromeDriver.findElement(By.xpath("//div[@id=':k']/following::div[1]"));
        a.click();
        a.getText();
        WebElement b = TestHelper.chromeDriver.findElement(By.xpath("//div[@id='gt-sl-sugg']/following::div[3]"));
        b.getText();
        //сравнить значения текстов этих элементов или просто с текстом "греческий" сравнить

    }


}
