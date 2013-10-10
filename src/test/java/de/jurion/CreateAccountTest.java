package de.jurion;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import de.jurion.requirements.Application;
import de.jurion.steps.EndUserSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class CreateAccountTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://www.jurion.de")
    public Pages pages;

    @Steps
    public EndUserSteps endUser;

    @Test
    public void createNewAccount() {

        endUser.navigateToHomePage();
        endUser.clickOnRegisterButton();
        endUser.clickForRegistering();

    }

   
} 