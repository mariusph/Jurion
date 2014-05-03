package de.jurion.pages.newaccount;

import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import de.jurion.tools.AbstractPage;

public class CartPage extends AbstractPage{

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="checkout-productlist-container")
	private WebElement productsListConatiner;

	public void verifyTitleAndPrice(List<String> list, String price) {
		element(productsListConatiner).waitUntilPresent();
		waitForTextToAppear(price);
		
		List<WebElement> titles = productsListConatiner.findElements(By
				.cssSelector("div[class*='title row-item']"));
		List<WebElement> totalPrices = productsListConatiner.findElements(By
				.cssSelector("div[class='price-amount row-item']"));
		for(WebElement totalPrice : totalPrices){
			if(totalPrice.getText().equals(price))
			System.out.println("The prices " + totalPrice.getText());
//		Assert.assertTrue(
//				"The title is not the expected one : " + title.getText(),
//				list.contains(title.getText()));
		Assert.assertTrue(
				"The price is not the expected one : " + totalPrice.getText(),
				totalPrice.getText().contains(price));
		}
	}

	public void verifyThePrice(String price) {
		element(productsListConatiner).waitUntilPresent();
		waitForTextToAppear(price);
		
		List<WebElement> totalPrices = productsListConatiner.findElements(By
				.cssSelector("div[class='price-amount row-item']"));
		for(WebElement totalPrice : totalPrices){
			if(totalPrice.getText().contains(price)){
			System.out.println("The prices " + totalPrice.getText());
//		Assert.assertTrue(
//				"The title is not the expected one : " + title.getText(),
//				list.contains(title.getText()));
		Assert.assertTrue(
				"The price is not the expected one : " + totalPrice.getText(),
				totalPrice.getText().contains(price));
			}
		}
	}

	public void verifyTheTitle(List<String> list) {
		element(productsListConatiner).waitUntilPresent();
		String title = list.toString();
//		waitForTextToAppear(list1);
		if(title.contains(",")){
			title= title.replace(",", "\n");
			System.out.println("The new title : "+title);
			List<WebElement> titles = productsListConatiner.findElements(By
					.cssSelector("div[class*='title row-item']"));
			for(WebElement tit : titles){
				if(tit.getText().contains(title)){
				System.out.println("The prices " + tit.getText());
			Assert.assertTrue(
					"The title is not the expected one : " + tit.getText(),
					tit.getText().contains(title));

				}
			}
		}
		else{
			List<WebElement> titles = productsListConatiner.findElements(By
					.cssSelector("div[class*='title row-item']"));
			for(WebElement tit : titles){
				if(tit.getText().contains(title)){
				System.out.println("The prices " + tit.getText());
			Assert.assertTrue(
					"The title is not the expected one : " + tit.getText(),
					tit.getText().contains(title));
				}
			}
		}
	}

	public void removeTitleFromCart(List<String> list) {
		element(productsListConatiner).waitUntilPresent();
		List<WebElement> bins= productsListConatiner.findElements(By.cssSelector("div[class='delete-button row-item']"));
		for(WebElement bin : bins){
				bin.click();
		}
	}

}
