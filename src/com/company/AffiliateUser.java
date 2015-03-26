package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Admin on 26.03.2015.
 */
public class AffiliateUser {

    public static WebDriver chromeDriver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1200, 768));
        chromeDriver.get("http://citrio.com/af/login");

        login();
        changePassword();
    }

    public static void login(){
        chromeDriver.findElement(By.id("login")).sendKeys("i.trachuk@itmgmedia.net");
        chromeDriver.findElement(By.id("password")).sendKeys("itmgmedia");
        chromeDriver.findElement(By.className("btn-blue")).click();
    }

    public static void changePassword(){
        chromeDriver.findElement(By.xpath("//a[@class='user-info-link clearfix popup-trigger']")).click();
        chromeDriver.findElement(By.xpath("//div[@id='user-details-popup']/ul/li[1]/a")).click();
        chromeDriver.findElement(By.id("btn-edit")).click();
        chromeDriver.findElement(By.id("newPassword")).sendKeys("1234567");
        chromeDriver.findElement(By.id("passwordConfirm")).sendKeys("1234567");
        chromeDriver.findElement(By.id("btn-save-changes")).click();
    }
}
