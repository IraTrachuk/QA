package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Admin on 26.03.2015.
 */
public class Affiliate {

    public WebDriver chromeDriver;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1200, 768));
        chromeDriver.get("http://citrio.com/af/login");

        login();
    }

    @After
    public void tearDown(){
        chromeDriver.quit();
    }


    public void login(){
        chromeDriver.findElement(By.id("login")).sendKeys("af_admin@citrio.com");
        chromeDriver.findElement(By.id("password")).sendKeys("wbsTr694eyQu");
        chromeDriver.findElement(By.className("btn-blue")).click();
    }


    @Test
    public void Title(){
        Assert.assertEquals(chromeDriver.getTitle(), "Citrio Affiliate :: Overview", "Fail");
    }


}
