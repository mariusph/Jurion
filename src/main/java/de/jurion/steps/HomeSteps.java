package de.jurion.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import de.jurion.tools.AbstractSteps;

public class HomeSteps extends AbstractSteps {

    private static final long serialVersionUID = -8860868710345974760L;

    public HomeSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void clickOnRegistrierenButton() {
        homePage().clickOnRegistrierenButton();
    }

    @Step
    public void openHomePage() {
        homePage().openHomePage();
//        ProfilesIni profile = new ProfilesIni();
//        FirefoxProfile myprofile = profile.getProfile("myFirefoxProfile");
//        WebDriver driver = new FirefoxDriver(myprofile);
//        driver.get("http://staging.jurion.de");
    }

}