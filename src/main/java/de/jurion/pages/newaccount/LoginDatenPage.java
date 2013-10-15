package de.jurion.pages.newaccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import de.jurion.tools.AbstractPage;

public class LoginDatenPage extends AbstractPage {

    public LoginDatenPage(WebDriver driver) {
        super(driver);
    }

	@FindBy(css = "input#username")
	private WebElement nutzname;

	public String getTheUsername() {
		element(nutzname).waitUntilVisible();
		return nutzname.getAttribute("value");
	}

}
