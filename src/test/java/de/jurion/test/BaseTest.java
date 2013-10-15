package de.jurion.test;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;

import org.junit.After;
import org.openqa.selenium.WebDriver;

import de.jurion.tools.Constants;

public class BaseTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.BASE_URL)
    public Pages pages;

    @After
    public void closeSelenium() {
        webdriver.close();
        webdriver.quit();
    }
}
