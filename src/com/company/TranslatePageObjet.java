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

    @Test
    public void checkLanguages() throws InterruptedException {
        TestHelper.chromeDriver.findElement(By.id("gt-sl-gms")).click();
        WebElement a = TestHelper.chromeDriver.findElement(By.xpath("//div[@id=':k']/following::div[1]"));
        a.click();
        WebElement c = TestHelper.chromeDriver.findElement(By.xpath("//div[@id=':t']/following::div[2]"));
        c.click(); //not visible
        WebElement b = TestHelper.chromeDriver.findElement(By.xpath("//div[@id='gt-sl-sugg']/following::div[3]"));
        System.out.println(b.getText());
        //сравнить значения текстов этих элементов или просто с текстом "греческий" сравнить

    }

    */
    @Test
    public void hello(){
        Assert.assertEquals("nbnbb", TestHelper.chromeDriver.findElement(By.xpath("//span[@class='hps']")).getText());
    }

    /*
    @Test
    public void entoes() throws InterruptedException {
        TestHelper.chromeDriver.findElement(By.xpath("//*[@id = 'gt-tl-gms']")).click();
        TestHelper.chromeDriver.findElement(By.xpath("//div[text()='испанский']")).click();
        TestHelper.chromeDriver.findElement(By.xpath("//*[@id = 'gt-sl-gms']")).click();
        TestHelper.chromeDriver.findElement(By.xpath("//div[text()='английский']")).click();
        Thread.sleep(2000);
        TestHelper.chromeDriver.findElement(By.xpath("//*[@id='source']")).sendKeys("girl");
        Thread.sleep(7000);
        Assert.assertEquals("chica", TestHelper.chromeDriver.findElement(By.xpath("//span[@class='hps']")).getText());
    }

    @Test
    public void btnListen() throws InterruptedException {
        TestHelper.chromeDriver.findElement(By.xpath("//*[@id='source']")).sendKeys("hello");
        Thread.sleep(7000);
        Assert.assertTrue(TestHelper.chromeDriver.findElement(By.xpath("//div[@id='gt-res-listen']//span")).isDisplayed());
    }


    @Test
    public void eraseField() throws InterruptedException {
        TestHelper.chromeDriver.findElement(By.xpath("//*[@id='source']")).sendKeys("hello");
        TestHelper.chromeDriver.findElement(By.xpath("//div[@id='gt-clear']//span")).click();
        Assert.assertEquals("", TestHelper.chromeDriver.findElement(By.xpath("//*[@id='source']")).getText());
        Thread.sleep(5000);
        Assert.assertEquals("", TestHelper.chromeDriver.findElement(By.xpath("//span[@id='result_box']")).getText());
    }

    //у Димы setInput, setOutput
    //написать нормальные функции для задания языков
    //с английского на итальянский задать и проверить что именно эти языки выставились
    */
}
