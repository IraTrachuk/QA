package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 23.04.2015.
 */
public class Dominos {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1200, 768));
        chromeDriver.get("http://www.dominos.ua");

        chromeDriver.findElement(By.xpath("//img[@alt='main_page_teser']")).click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        chromeDriver.findElement(By.cssSelector("ul.size_radio > li > a")).click();

        Actions action1 = new Actions(chromeDriver);
        WebElement chicken = chromeDriver.findElement(By.xpath("//li[@data-option = 'I14']"));
        action1.moveToElement(chicken).moveToElement(chromeDriver.findElement(By.xpath("//li[7]/div/a[3]"))).click().build().perform();


        WebElement pepperoni = chromeDriver.findElement(By.xpath("//li[@data-option = 'I4']"));
        action1.moveToElement(pepperoni).moveToElement(chromeDriver.findElement(By.xpath("//li[8]/div/a[3]"))).click().build().perform();


        chromeDriver.findElement(By.xpath("//a[3]/div/b")).click();
        WebElement pepper = chromeDriver.findElement(By.xpath("//li[@data-option = 'I15']"));
        action1.moveToElement(pepper).moveToElement(chromeDriver.findElement(By.xpath("//div[3]/ul/li[6]/div/a[3]"))).click().build().perform();

        chromeDriver.findElement(By.cssSelector("a.add_to_box.custom_pizza_add_to_box")).click();

        chromeDriver.findElement(By.xpath("//a[contains(@href, '/ru/box/')]")).click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        chromeDriver.findElement(By.id(""));
        //chromeDriver.findElement(By.id("s2id_autogen1_search")).sendKeys("a");
    }
}
