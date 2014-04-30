package de.jurion.pages.newaccount;

import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.seleniumhq.jetty7.util.log.Log;

import de.jurion.tools.AbstractPage;

public class StorePage extends AbstractPage{

	public StorePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "input[type='text']")
	private WebElement searchInput;
	
	@FindBy(id = "dosearch")
	private WebElement suchenButton;
	
	@FindBy(css = "li[data-subworld='Bücher']")
	private WebElement bucherButton;
	
	@FindBy(css = "div.overview-container")
	private WebElement resultsListContainer;
	
	@FindBy(css = "div.titleblock.layout")
	private WebElement titleContainer;

	public void fillSearchInput(String subject) {
		element(searchInput).waitUntilVisible();
		searchInput.clear();
		searchInput.sendKeys(subject);
	}

	public void clickOnSearchButton() {
		element(suchenButton).waitUntilVisible();
		suchenButton.click();
	}

	public void refineTheSearchAfterBook() {
		element(bucherButton).waitUntilVisible();
		bucherButton.click();
	}
	
public List<String> getResultsList(String subject) {
		
	List<String> results = new ArrayList<String>();
		try {
			element(resultsListContainer).waitUntilVisible();
			List<WebElement> list = resultsListContainer.findElements(By.cssSelector("div.product-info h3 a"));
			
			for(WebElement elem : list){
				if(elem.getText().contains(subject)){
					results.add(elem.getText());
					System.out.println(results.get(0));
				}
			}
			
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			//e.printStackTrace();
			System.out.println("In the book list's catch");
		}
		return results;
	}


	public void chooseFromResultsList(String subject) {
		try {
			element(resultsListContainer).waitUntilVisible();
			List<String> results = new ArrayList<String>();
			List<WebElement> list = resultsListContainer.findElements(By.cssSelector("div.product-info h3 a"));
			
			for(WebElement elem : list){
				if(elem.getText().contains(subject)){
					results.add(elem.getText());
					elem.click();
				}
			}
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			//e.printStackTrace();
			System.out.println("In the book list's catch");
		}
	}

	public void verifyTheChoosenTitle(List<String> list) {
		element(titleContainer).waitUntilVisible();
	}

}
