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

public class BestatigenPage extends AbstractPage{

	public BestatigenPage(WebDriver driver) {
		super(driver);
		}
	
    @FindBy(id = "form3-lastCheckStep2_10")
    private WebElement wirkungskreisCheckBoxesContainer;
    
    @FindBy(css = "div[id*='form3-lastCheckStep']")
    private WebElement labelsContainer;

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
	
		List<WebElement> list = labelsContainer.findElements(By.cssSelector("div[class*='title']"));
		for(WebElement elem:list){
			if(elem.getText().contains(label)){
				Assert.assertTrue("The property is not : "+label, labelsContainer.findElement(By.cssSelector("div[class*='content']")).getText().contains(value));
			}
		}
		
	}

}
