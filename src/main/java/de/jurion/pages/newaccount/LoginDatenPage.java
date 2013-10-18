package de.jurion.pages.newaccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import de.jurion.model.CustomerModel;
import de.jurion.tools.AbstractPage;
import de.jurion.tools.CustomerLabels;

public class LoginDatenPage extends AbstractPage {

    public LoginDatenPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input#username")
    private WebElement nutzname;
    
    @FindBy(css = "input#password")
    private WebElement passswortInput;
    
    @FindBy(css = "input#password_confirm")
    private WebElement passswortWeiderholenInput;
    
    @FindBy(css = "div[id*='Taxonomy6'] div[class*='Collapsed']")
    private WebElement wirtschaftsrechtArrowCollapsed;
    
    @FindBy(css = "div[id*='taxonomy6_3-elem']")
    private WebElement insolvenzrechtCheckboxContainer;

    public String getTheUsername() {
        element(nutzname).waitUntilVisible();
        return nutzname.getAttribute("value");
    }

	public void fillTheFirstPassword(String password) {
		element(passswortInput).waitUntilVisible();
		passswortInput.sendKeys(password);
	}

	public void confirmTheFirstPassword(String password) {
		element(passswortWeiderholenInput).waitUntilVisible();
		passswortWeiderholenInput.sendKeys(password);
	}

	public void expandDomainArrow() {
		element(wirtschaftsrechtArrowCollapsed).waitUntilVisible();
		wirtschaftsrechtArrowCollapsed.click();
	}

	public void clickOnInsolventzRechtCheckbox() {
		element(insolvenzrechtCheckboxContainer).waitUntilVisible();
		
		if(insolvenzrechtCheckboxContainer.getText().contains(CustomerLabels.INTERNATIONAL_RIGHT_SUBDOMAIN)){
			WebElement elem = insolvenzrechtCheckboxContainer.findElement(By.tagName("input"));
			System.out.println("XXX "+insolvenzrechtCheckboxContainer.getText());
			elem.click();
		}
	}

}
