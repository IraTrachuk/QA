package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//* - любой тег
//.. - подняться на уровень выше
//count - к-во аттрибутов (//book[count(name)=2])
//following - следующий за тегом (//following::shelf[1])

/**
 * Created by Admin on 26.03.2015.
 */
@RunWith(JUnit4.class)
public class XPathTest {

    public WebDriver chromeDriver;

    public static String PasswordGenerator(WebDriver chromeDriver, String name, String site) {

        chromeDriver.findElement(By.xpath("//td[text()='Your master password']/following::input[1]")).clear();
        chromeDriver.findElement(By.xpath("//td[text()='Your master password']/following::input[1]")).sendKeys(name);

        chromeDriver.findElement(By.xpath("//td[text()='Site name']/following::input[1]")).clear();
        chromeDriver.findElement(By.xpath("//td[text()='Site name']/following::input[1]")).sendKeys(site);
        chromeDriver.findElement(By.xpath("//td[text()='Generated password']/preceding::input[1]")).click();

        String pass = chromeDriver.findElement(By.xpath("//td[text()='Generated password']/following::input[1]")).getAttribute("value");

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
        System.setProperty("webdriver.chrome.driver", "C:\\QA Automation (IRA)\\Chromedriver_win32\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1200, 768));
        //chromeDriver.get("http://angel.net/~nic/passwd.sha1.1a.html");
        chromeDriver.get("http://oxogamestudio.com/passwd.current2.htm");
    }

    @Test
    public void titleIsCorrect(){
        //написать отдельные функции
        setField("Your master password", "12345678");
        setField("Site name", "example.ua");
        generate();
        String pwd = getField("Generated password");
        Assert.assertequals("2mIEFhSD1a", pwd);
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
