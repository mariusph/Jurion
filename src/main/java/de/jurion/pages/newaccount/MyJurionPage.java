package de.jurion.pages.newaccount;

import java.util.List;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;

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

}
