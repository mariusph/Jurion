package de.jurion.pages.newaccount;

import net.thucydides.core.annotations.findby.FindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import de.jurion.tools.AbstractPage;

public class StorePage extends AbstractPage{

	public StorePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "input[type='text']")
	private WebElement searchInput;
	
	@FindBy(id = "dosearch")
	private WebElement searchButton;

	public void fillSearchInput(String subject) {
		element(searchInput).waitUntilVisible();
		searchInput.clear();
		searchInput.sendKeys(subject);
	}

	public void clickOnSearchButton() {
		element(searchButton).waitUntilVisible();
		searchButton.click();
		waitABit(2000);
	}

}
