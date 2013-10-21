package de.jurion.pages.newaccount;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    
    @FindBy(css = "div[id*='Taxonomy6']")
    private WebElement wirtschaftsrechtArrow;
    
    @FindBy(css = "div[id*='Taxonomy6'] div[class*='Expanded']")
    private WebElement wirtschaftsrechtArrowExpanded;
    
    @FindBy(css = "div[id*='taxonomy6_3-elem']")
    private WebElement insolvenzrechtCheckboxContainer;
    
    @FindBy(css = "div[id*='taxonomy6_3-elem']")
    private WebElement wirtschaftrechtCheckboxContainer;
    
    @FindBy(css = "fieldset#fieldset-form2 dd#buttonnavigation-element")
    private WebElement weiterButtonContainer;
    
    @FindBy(id = "fieldset-spheres")
    private WebElement wirkungskreisCheckBoxesContainer;

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
		element(wirtschaftrechtCheckboxContainer).waitUntilVisible();
		
		if(wirtschaftrechtCheckboxContainer.getText().contains(CustomerLabels.INTERNATIONAL_RIGHT_SUBDOMAIN)){
			elementjQueryClick("dd#taxonomies6-element input#taxonomy6_3");
			
		}
	}
	
	public int verifyThatTheCheckBoxCounterIsIcremented(){
		int value = 0;
		WebElement counter= wirtschaftsrechtArrow.findElement(By.cssSelector("div.taxonomycounter-min-currentcount"));
		element(counter).waitUntilVisible();
		value++;
		Assert.assertTrue("The counter value is : "+counter.getText(), counter.getText().equals(String.valueOf(value)));
		return value;
	}
	
	 public void clickOnWeiterButton() {
	        element(weiterButtonContainer).waitUntilVisible();
	        WebElement button = weiterButtonContainer.findElement(By.id("next"));
	        button.click();
	    }

	public void closeDomainArrow() {
		element(wirtschaftsrechtArrowExpanded).waitUntilVisible();
		wirtschaftsrechtArrowExpanded.click();
	}

	public List<String> getProfessionalList() {
		List<String> list = new ArrayList<String>();
//		element(wirkungskreisCheckBoxesContainer).waitUntilVisible();
		List<WebElement> listElements =  wirkungskreisCheckBoxesContainer.findElements(By.cssSelector("label[class='grouped bold']"));
		
		System.out.println("The list length is "+listElements.size());
		for(WebElement elem:listElements){
		
			list.add(elem.getText());
			System.out.println("XXX "+elem.getText());
		}
		
		return list;
		
	}

}
