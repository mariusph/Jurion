package de.jurion.tools;

import java.util.Set;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AbstractPage extends PageObject {

	public AbstractPage(WebDriver driver) {
		super(driver);
	}

	public void switchToIframe(WebElement... iframes) {
		getDriver().switchTo().defaultContent();
		for (WebElement iframe : iframes) {
			getDriver().switchTo().frame(iframe);
		}
	}

	public void handleMultipleWindows(String windowTitle) {
		Set<String> windows = getDriver().getWindowHandles();

		for (String window : windows) {
			getDriver().switchTo().window(window);
			if (getDriver().getTitle().contains(windowTitle)) {
				return;
			}
		}
	}

	public void doubleClick(WebElement element) {
		Actions action = new Actions(getDriver());
		action.doubleClick(element).perform();
	}

}
