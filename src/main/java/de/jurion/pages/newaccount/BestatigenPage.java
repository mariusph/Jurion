package de.jurion.pages.newaccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import de.jurion.tools.AbstractPage;
import de.jurion.tools.CustomerLabels;

public class BestatigenPage extends AbstractPage{

	public BestatigenPage(WebDriver driver) {
		super(driver);
		}
	
    @FindBy(id = "form3-lastCheckStep2_10")
    private WebElement wirkungskreisCheckBoxesContainer;
       
    @FindBy(css = "fieldset#fieldset-form3")
    private WebElement labelsContainer;
    
    @FindBy(css = "fieldset#fieldset-form3 dd#buttonnavigation-element")
    private WebElement absendenButtonContainer;
    
    @FindBy(css = "div#form3-confirm_terms-elem")
    private WebElement agreeTermsCheckboxContainer;
    
    @FindBy(id = "confirm-container")
    private WebElement confirmationMessageContainer;

	public List<String> verifyProfessionalList() {
		List<String> list = new ArrayList<String>();
		
		WebElement myString =  wirkungskreisCheckBoxesContainer.findElement(By.cssSelector("div.lastcheck-content"));
		String[] items = (myString.getText()).split("\n");
		list = Arrays.asList(items);
		for(String elem:list){
			System.out.println("DDD "+elem);
		}
		System.out.println("The last list length "+list.size());
		return list;
	}

	public void verifyCustomersLabelAndValue(String label, String value) {
		element(labelsContainer).waitUntilVisible();
	
		List<WebElement> list = labelsContainer.findElements(By.cssSelector("div[id*='form3-lastCheckStep']"));
		for(WebElement elem:list){
			if(elem.getText().contains(label)){
				Assert.assertTrue(
						"The value is different : "
								+ elem.findElement(By.cssSelector("div[class*='content']")).getText(),
						elem.findElement(By.cssSelector("div[class*='content']")).getText().contains(value));
			}
		}
		
	}

	public void verifyCustomerLabelAndMultipleValues(String addressTitleLabel,
			String value) {
		element(labelsContainer).waitUntilVisible();
		List<WebElement> list = labelsContainer.findElements(By
				.cssSelector("div[id*='form3-lastCheckStep']"));

		List<String> valuesList = new ArrayList<String>();

		WebElement myString = labelsContainer.findElement(By
				.cssSelector("div.lastcheck-content"));
		String[] items = (myString.getText()).split("\n");
		valuesList = Arrays.asList(items);

		for (WebElement elem : list) {
			if (elem.getText().equals(addressTitleLabel)) {
				for (String item : valuesList) {
					Assert.assertTrue("The value is different : " + item,
							item.contains(value));
				}
			}
		}
	}
	
	 public void clickOnAbsendenButton() {
	        element(absendenButtonContainer).waitUntilVisible();
	        WebElement button = absendenButtonContainer.findElement(By.id("next"));
	        button.click();
	    }

	public void clickOnAgreeTermsCheckbox() {
		element(agreeTermsCheckboxContainer).waitUntilVisible();
//        WebElement checkbox = agreeTermsCheckboxContainer.findElement(By.cssSelector("input#confirm_terms"));
//        checkbox.sendKeys("");
//        checkbox.click();
        elementjQueryClick("input#confirm_terms");
	}

	public void checkTheRegistrationMessage() {
		element(confirmationMessageContainer).waitUntilVisible();
		Assert.assertTrue(
				"The message is different : "
						+ confirmationMessageContainer.findElement(By.cssSelector("div[class*='titlebar']")).getText(),
						confirmationMessageContainer.findElement(By.cssSelector("div[class*='titlebar']")).getText().contains(CustomerLabels.CONFIRMATION_FOR_REGISTRION));
	}

}
