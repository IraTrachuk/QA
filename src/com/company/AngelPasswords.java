package com.company;

import com.sun.javafx.scene.EnteredExitedHandler;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.PasswordAuthentication;

/**
 * Created by Admin on 06.04.15.
 */
public class AngelPasswords {

    public static String PasswordGenerator(WebDriver chromeDriver, String name, String site) {

        chromeDriver.findElement(By.name("master")).sendKeys(name);
        chromeDriver.findElement(By.name("site")).sendKeys(site);
        chromeDriver.findElement(By.xpath("//td/input[@value]")).click();

        String pass = chromeDriver.findElement(By.name("password")).getAttribute("value");

        return pass;
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\QA Automation (IRA)\\Chromedriver_win32\\chromedriver.exe");

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1200, 768));
        chromeDriver.get("http://angel.net/~nic/passwd.sha1.1a.html");
        
        System.out.println(PasswordGenerator(chromeDriver, "12345678", "example.ua"));

    }


}
