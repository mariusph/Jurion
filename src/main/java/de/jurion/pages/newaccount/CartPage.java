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
	
	@FindBy(css="li[data-productid='08250794']")
	private WebElement bookRowConatiner;
	
	@FindBy(css="li[data-productid='08250197']")
	private WebElement magazineRowConatiner;
	

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

	public void verifyBookTitleAndPrice(List<String> list, String price) {

		waitForTextToAppear(price);
		element(productsListConatiner).waitUntilPresent();
		String title = list.toString();
		
		title = title.substring(title.indexOf(',') + 1, title.length());
		
		WebElement tit = bookRowConatiner.findElement(By
				.cssSelector("div[class*='title']"));
		String ntit = tit.getText().substring(tit.getText().indexOf("\n") + 1,
				tit.getText().indexOf("4") - 1);
		WebElement pr = bookRowConatiner.findElement(By
				.cssSelector("span[class='price-amount-value']"));
		Assert.assertTrue("The title is not the expected one : " + ntit,
				title.contains(ntit));
		Assert.assertTrue(
				"The price is not the expected one : " + pr.getText(),
				(pr.getText()).contains(price));
	
	}

	public void verifyMagazineTitleAndPrice(List<String> list, String price) {

			waitForTextToAppear(price);
			element(productsListConatiner).waitUntilPresent();
			String title = list.toString();
			title= title.substring(0,title.indexOf('\n')+1);
			WebElement tit = magazineRowConatiner.findElement(By
					.cssSelector("div[class*='title']"));
			WebElement pr = magazineRowConatiner.findElement(By
					.cssSelector("span[class='price-amount-value']"));
			Assert.assertTrue("The title is not the expected one : " + tit.getText(),
					tit.getText().contains(title));
			Assert.assertTrue("The price is not the expected one : " + pr.getText(),
					(pr.getText()).contains(price));

	}

	public void removeBookFromCart(List<String> list) {
		element(productsListConatiner).waitUntilPresent();
		String title = list.toString();
		title= title.substring(0,title.indexOf('\n')+1);
		WebElement tit = bookRowConatiner.findElement(By
				.cssSelector("div[class*='title']"));
		WebElement bin = bookRowConatiner.findElement(By
				.cssSelector(" div[class*='delete']"));
		if(tit.getText().contains(title)){
			bin.click();
		}
	}

	public void verifyThatBookIsRemoved(List<String> list) {
		element(productsListConatiner).waitUntilPresent();
		String title = list.toString();
		title= title.substring(0,title.indexOf('\n')+1);
		List<WebElement> items = productsListConatiner.findElements(By
				.cssSelector("div[class*='title']"));
		for(WebElement tit:items){
		Assert.assertFalse("The title can be found : " + tit.getText(),
				! tit.getText().contains(title));
		break;
		}
	}

	public void removeMagazineFromCart(List<String> list) {
		element(productsListConatiner).waitUntilPresent();
		String title = list.toString();
		title= title.substring(0,title.indexOf('\n')+1);
		WebElement tit = magazineRowConatiner.findElement(By
				.cssSelector("div[class*='title']"));
		WebElement bin = magazineRowConatiner.findElement(By
				.cssSelector(" div[class*='delete']"));
		if(tit.getText().contains(title)){
			bin.click();
		}
	}

}
