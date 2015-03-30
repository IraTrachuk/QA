package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by Admin on 30.03.15.
 */
public class Test1 {

           public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:\\QA Automation (Ira)\\chromedriver_win32\\chromedriver.exe");

            WebDriver Driver = new ChromeDriver();

               Driver.manage().window().maximize();
               Driver.get("http://www.google.com");
               //Thread.sleep(5000);
               //Driver.quit();
        }
    }

