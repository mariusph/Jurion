package de.jurion.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import de.jurion.tools.AbstractPage;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div.button.register-handler a")
	private WebElement registerButton;

	@FindBy(id = "next")
	private WebElement weiterButton;

	public void clickOnRegisterButton() {
		element(registerButton).waitUntilVisible();
		registerButton.click();
	}

	public void clickForRegistering() {
		element(weiterButton).waitUntilVisible();
		weiterButton.click();
	}
}
