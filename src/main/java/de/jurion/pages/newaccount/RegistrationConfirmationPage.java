package de.jurion.pages.newaccount;

import net.thucydides.core.annotations.findby.FindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import de.jurion.tools.AbstractPage;
import de.jurion.tools.CustomerLabels;

public class RegistrationConfirmationPage extends AbstractPage{

	public RegistrationConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="register-title")
	private WebElement regustrationTitleContainer;

	public void verifyRegistrationConfirmation() {
		element(regustrationTitleContainer).waitUntilVisible();
		waitForAnyTextToAppear(CustomerLabels.REGISTRATION_MESSAGE);
	}

	

}
