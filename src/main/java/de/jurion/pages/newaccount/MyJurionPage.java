package de.jurion.pages.newaccount;

import java.util.List;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import de.jurion.tools.AbstractPage;
import de.jurion.tools.CustomerLabels;

public class MyJurionPage extends AbstractPage{

	public MyJurionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id ="main-header")
	private WebElement mainHeaderContainer;
	
	@FindBy(css ="div.last")
	private WebElement headerContainer;
	
	@FindBy(id ="shopping-cart")
	private WebElement shoppingCartButton;

	public void clickOnHeaderButton(String label) {
		try {
			element(headerContainer).waitUntilVisible();
			List<WebElement> list = headerContainer.findElements(By
					.cssSelector("a[href*='/de/']"));
			for (WebElement elem : list) {
				if (elem.getText().contains(label)) {
					elem.click();
				}
			}
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			System.out.println("In the catch");
		}

	}

	public void clickOnShoppingCart() {

		element(shoppingCartButton).waitUntilVisible();
		shoppingCartButton.click();
	}

	public void clickOnHeaderUserNameButton(String usernameLabel) {
		element(headerContainer).waitUntilVisible();
		List<WebElement> list = headerContainer.findElements(By
				.cssSelector("li a"));
		for (WebElement elem : list) {
			if (elem.getText().contains(usernameLabel)) {
				elem.click();
			}
		}
	}

	public void verifyThaShoppingCartIsEmpty() {
		element(headerContainer).waitUntilVisible();
		WebElement cart = headerContainer.findElement(By
				.cssSelector("li#shopping-cart"));
		Assert.assertTrue("The cart is not empty"+cart.getText(),cart.getText().isEmpty());
	}

}
