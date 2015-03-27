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

/**
 * Created by Admin on 26.03.2015.
 */
@RunWith(JUnit4.class)
public class PasswordFunctions {

    public static WebDriver chromeDriver;

    public static void master(String name){
        chromeDriver.findElement(By.xpath("//td[text()='Your master password']/following::input[1]")).clear();
        chromeDriver.findElement(By.xpath("//td[text()='Your master password']/following::input[1]")).sendKeys(name);
    }

    public static void site(String site){
        chromeDriver.findElement(By.xpath("//td[text()='Site name']/following::input[1]")).clear();
        chromeDriver.findElement(By.xpath("//td[text()='Site name']/following::input[1]")).sendKeys(site);
    }

    public static void generate(){
        chromeDriver.findElement(By.xpath("//td[text()='Generated password']/preceding::input[1]")).click();
    }

    public static String password(){
        return chromeDriver.findElement(By.xpath("//td[text()='Generated password']/following::input[1]")).getAttribute("value");
    }

    public static String master(){
        return chromeDriver.findElement(By.xpath("//td[text()='Your master password']/following::input[1]")).getAttribute("value");
    }

    public static String site(){
        return chromeDriver.findElement(By.xpath("//td[text()='Site name']/following::input[1]")).getAttribute("value");
    }

    public static String title(){
        return chromeDriver.getTitle();
    }

    public static String button(){
        return chromeDriver.findElement(By.xpath("//td[text()='Generated password']/preceding::input[1]")).getAttribute("value");
    }

    public static String masterText(){
        return chromeDriver.findElement(By.xpath("//tr[1]/td[1]")).getText();
    }

    public static String siteText(){
        return chromeDriver.findElement(By.xpath("//tr[2]/td[1]")).getText();
    }

    public static String passText() {
        return chromeDriver.findElement(By.xpath("//tr[4]/td[1]")).getText();
    }

    public static boolean masterIsEnabled(){
        return chromeDriver.findElement(By.xpath("//td[text()='Your master password']/following::input[1]")).isEnabled();
    }

    public static boolean siteIsEnabled(){
        return chromeDriver.findElement(By.xpath("//td[text()='Site name']/following::input[1]")).isEnabled();
    }

    public static boolean passIsEnabled(){
        return chromeDriver.findElement(By.xpath("//td[text()='Generated password']/following::input[1]")).isEnabled();
    }

    public static void setField(String field, String value){
        chromeDriver.findElement(By.xpath("//td[text()='" + field + "']/following::input[1]")).sendKeys(value);
    }

    public static String getField(String field){
        return chromeDriver.findElement(By.xpath("//td[text()='"+ field + "']/following::input[1]")).getAttribute("value");
    }

    /*public static String PasswordGenerator(WebDriver chromeDriver, String name, String site) {

        chromeDriver.findElement(By.name("master")).clear();
        chromeDriver.findElement(By.name("master")).sendKeys(name);

        chromeDriver.findElement(By.name("site")).clear();
        chromeDriver.findElement(By.name("site")).sendKeys(site);
        chromeDriver.findElement(By.xpath("//td/input[@value]")).click();

        String pass = chromeDriver.findElement(By.name("password")).getAttribute("value");

        return pass;
    }*/

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
    public void passIsCorrect(){
        //написать отдельные функции
        setField("Your master password", "12345678");
        setField("Site name", "example.ua");
        generate();
        String pwd = getField("Generated password");
        Assert.assertEquals("2mIEFhSD1a", pwd);
    }

    /*
    @Test
    public void Blanks(){
        master("");
        site("");
        generate();
        String expected = "";
        Assert.assertEquals(expected, password());
    }

    @Test
    public void Test2() {
        master("12");
        site("qwewewed");
        generate();
        String expected = "HC+otApT1a";
        Assert.assertEquals(expected, password());
    }

    @Test
    public void Test3() {
        master("12");
        site("qwewewed");
        generate();
        String expected = "wewew";
        Assert.assertEquals(expected, password());
    }

     @Test
     public void blankSite(){
        master("12345678");
        site("");
        generate();
        String expected = "9Ixm2r5Xnm41Q@1a";
        Assert.assertEquals(expected, password());
     }

    @Test
    public void specialSymbols(){
        master("%^*&#$^&^???");
        site("^*&#$^&^???");
        generate();
        String expected = "jSFRYvJbm17kb@1a";
        Assert.assertEquals(expected, password());
    }

    @Test
    public void generateNameButton(){
       Assert.assertEquals("Generate", button());
    }

    @Test
    public void titleCheck() {
        Assert.assertEquals("Password generator", title());
    }

    /*@Test
    public void PasswordNotCreated() { // от обратного, проверили что пароль действительно сгенерировался
        chromeDriver.findElement(By.xpath("//td/input[@value]")).click();
        Assert.assertEquals("Password is created!", chromeDriver.findElement(By.name("password")).getAttribute("value"), "");

    }*/

}
