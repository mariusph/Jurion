package de.jurion.pages.newaccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import de.jurion.tools.AbstractPage;

public class RegistrierungStartenPage extends AbstractPage {

    public RegistrierungStartenPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "next")
    private WebElement weiterButton;

    public void clickOnWeiterButton() {
        element(weiterButton).waitUntilVisible();
        weiterButton.click();
    }

}
