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

	@FindBy(css = "div.button.register-handler a")
	private WebElement registrierenButton;


	public void clickOnRegistrierenButton() {
		element(registrierenContainer).waitUntilPresent();
		System.out.println("XXX "+registrierenContainer.getTagName());
		element(registrierenButton).waitUntilVisible();
		registrierenButton.click();
	}
	

}
