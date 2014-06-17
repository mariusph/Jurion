package de.jurion.pages.newaccount;

import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import de.jurion.tools.AbstractPage;
import de.jurion.tools.CustomerLabels;

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
	
	@FindBy(css = "li[data-subworld='Zeitschriften']")
	private WebElement zeitschriftenButton;
	
	@FindBy(css = "div.overview-container")
	private WebElement resultsListContainer;
	
	@FindBy(css = "div.titleblock.layout")
	private WebElement titleContainer;
	
	@FindBy(className = "product-sort")
	private WebElement sortProductsContainer;
	
	@FindBy(css = "div.medium-buy-button.handlerAddToCart.mainProduct")
	private WebElement buyButton;

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
			List<WebElement> list = resultsListContainer.findElements(By.cssSelector("div.product-info h3:first-child"));
			
			for(WebElement elem : list){
//				if(elem.getText().contains(subject)){
					results.add(elem.getText());
					System.out.println( " The title is : " + elem.getText());
//				}
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
			List<WebElement> list = resultsListContainer.findElements(By.cssSelector("div.product-info h3:first-child"));
			
			for(WebElement elem : list){
//				if(elem.getText().contains(subject)){
					results.add(elem.getText());
					System.out.println("The choosen title is : " + results.get(0));
					elem.click();
//				}
			}
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			//e.printStackTrace();
			System.out.println("In the book list's catch");
		}
	}

	public void verifyTheChoosenTitle(List<String> list) {
		element(titleContainer).waitUntilVisible();
		Assert.assertTrue(
				"The titles are not the same : " + titleContainer.getText(),
				list.contains(titleContainer.getText()));
	}

	public void addtoCart(List<String> list) {
		element(buyButton).waitUntilVisible();
		if(list.contains(titleContainer.getText()))
		buyButton.click();
	}

	public String getThePrice() {
		element(buyButton).waitUntilVisible();
		return buyButton.findElement(By.tagName("span")).getText();
	}

	public void refineTheSearchAfterMagazine() {
		element(zeitschriftenButton).waitUntilVisible();
		zeitschriftenButton.click();
	}

	public void refineResultsAfterTitleDescending() {
		element(sortProductsContainer).waitUntilVisible();
		element(sortProductsContainer).selectByVisibleText(CustomerLabels.TITLES_DESCENDEING_DROPDOWN);
	}

}
