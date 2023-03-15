package com.selenium.test;

import com.selenium.test.configuration.TestsConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

//1. Create a public repo
//
//        2. Preferably use dotnet (any version) or any programming language of your choice, Selenium with local chrome driver, write a scenario that:
//        a. navigates to The Internet (the-internet.herokuapp.com)
//        b. adds n number of elements
//        c. asserts that n number of elements exist on the page

public class InvoiceCloudTest {
    public WebDriver driver;

    @Test
    public void AddNumberOfElements_ChromeTest() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path+"\\src\\\\drivers\\\\chrome_110\\\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        int numberAdded = 15;

        for (int i = 0; i < numberAdded; i++) {
            driver.findElement(By.xpath("//div[@class='example']//button")).click();
        }

        List<WebElement> numberOfAddedElements = new ArrayList<>();
        numberOfAddedElements = driver.findElements(By.xpath("//div[@id='elements']//button[@class='added-manually']"));

        Assert.assertEquals(numberOfAddedElements.size(), numberAdded);
    }
}
