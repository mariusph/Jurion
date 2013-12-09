package de.jurion.test;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.jurion.tools.Constants;

public class BaseTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.BASE_URL)
    public Pages pages;

    @Before
    public void first() {

        
        if(webdriver instanceof ChromeDriver) {
            System.out.println("chrome DRIVER");
        }else if(webdriver instanceof FirefoxDriver) {
            System.out.println("FF DRIVER");
        }
       
    }
    @After
    public void closeSelenium() {
        webdriver.close();
        webdriver.quit();
    }
}
