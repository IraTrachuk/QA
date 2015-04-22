package com.company;

import org.junit.After;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Admin on 22.04.15.
 */
public class TestHelper {

    public static WebDriver chromeDriver;

    public static void init(){
        System.setProperty("webdriver.chrome.driver", "C:\\QA Automation (IRA)\\Chromedriver_win32\\chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1200, 768));
     }

    public static void tearDown(){
        chromeDriver.quit();
    }
}
