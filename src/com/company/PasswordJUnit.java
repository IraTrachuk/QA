package com.company;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Admin on 26.03.2015.
 */
@RunWith(JUnit4.class)
public class PasswordJUnit {

    public WebDriver chromeDriver;

    public static String PasswordGenerator(WebDriver chromeDriver, String name, String site) {

        chromeDriver.findElement(By.name("master")).clear();
        chromeDriver.findElement(By.name("master")).sendKeys(name);

        chromeDriver.findElement(By.name("site")).clear();
        chromeDriver.findElement(By.name("site")).sendKeys(site);
        chromeDriver.findElement(By.xpath("//td/input[@value]")).click();

        String pass = chromeDriver.findElement(By.name("password")).getAttribute("value");

        return pass;
    }

    /*
    public static void compare(String a, String b) {
        if (a.equals(b)) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed...");
        }
    }
    */

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1200, 768));
        chromeDriver.get("http://angel.net/~nic/passwd.sha1.1a.html");
    }

    @After
    public void tearDown(){
        chromeDriver.quit();
    }

    @Test
    public void Test1(){
        Assert.assertEquals("Not matched!", PasswordGenerator(chromeDriver, "12345678", "example.ua"), "2mIEFhSD1a");
    }


    @Test
    public void Blanks(){
        Assert.assertEquals("Not matched!", PasswordGenerator(chromeDriver, "", ""), "");
    }

    @Test
    public void Test2() {
        Assert.assertEquals("Not matched!", PasswordGenerator(chromeDriver, "12", "qwewewed"), "HC+otApT1a");
    }

    @Test
    public void Test3() {
        Assert.assertEquals("Not matched!", PasswordGenerator(chromeDriver, "12", "qwewewed"), "wewew");
    }

     @Test
     public void blankSite(){
        Assert.assertEquals("Password is not matched!",PasswordGenerator(chromeDriver, "12345678", ""), "9Ixm2r5Xnm41Q@1a");
     }

    @Test
    public void specialSymbols(){
        Assert.assertEquals("Password is not matched!", PasswordGenerator(chromeDriver, "%^*&#$^&^???", "%^*&#$^&^???"), "jSFRYvJbm17kb@1a");
    }

    @Test
    public void generateNameButton(){
        Assert.assertEquals("Name Button is not matched!", chromeDriver.findElement(By.xpath("//td/input[@value]")).getAttribute("value"), "Generate");
    }

    @Test
    public void titleCheck() {
        Assert.assertEquals("Title is not matched!", chromeDriver.getTitle(), "Password generator");
    }

}
