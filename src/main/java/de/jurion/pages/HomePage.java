package de.jurion.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import de.jurion.tools.AbstractPage;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "account-handling")
    private WebElement registrierenContainer;

    @FindBy(css = "div#up-register-button a")
    private WebElement anmeldenButton;
    
    @FindBy(css = "div[class*='register'] a[href*='register']")
    private WebElement registrierenButton;
    

    @FindBy(id = "login_username")
    private WebElement nutznameImput;
    
    @FindBy(id = "login_password")
    private WebElement passwortImput;
    

    public void clickOnRegistrierenButton() {
//        element(registrierenContainer).waitUntilPresent();
        element(registrierenButton).waitUntilVisible();
        registrierenButton.click();
        }

	public void fillUserNameInput(String email) {
		 element(nutznameImput).waitUntilVisible();
		 nutznameImput.clear();
		 nutznameImput.sendKeys(email);
	     
	}

	public void fillPasswordInput(String password) {
		element(passwortImput).waitUntilVisible();
		passwortImput.clear();
		passwortImput.sendKeys(password);
	}

	public void clickOnLoginButton() {
		System.out.println("Inn Innn");
		element(anmeldenButton).waitUntilVisible();
		System.out.println("FFFF FFF " + anmeldenButton.getText());
		anmeldenButton.click();
	}

}
