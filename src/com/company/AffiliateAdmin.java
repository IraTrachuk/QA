package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by Admin on 26.03.2015.
 */
public class AffiliateAdmin {

    public static WebDriver chromeDriver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1200, 768));
        chromeDriver.get("http://citrio.com/af/login");

        login();

        chromeDriver.findElement(By.xpath("//div[@class='content-wrapper clearfix']/ul/li[1]/a")).click();

        List <WebElement> mails =  chromeDriver.findElements(By.tagName("td"));

        for (WebElement str:mails) {
            System.out.println(str.getText());
        }

    }

    public static void login(){
        chromeDriver.findElement(By.id("login")).sendKeys("af_admin@citrio.com");
        chromeDriver.findElement(By.id("password")).sendKeys("wbsTr694eyQu");
        chromeDriver.findElement(By.className("btn-blue")).click();
    }

}
