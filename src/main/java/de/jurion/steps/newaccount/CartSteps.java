package de.jurion.steps.newaccount;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import de.jurion.tools.AbstractSteps;

public class CartSteps extends AbstractSteps{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8640982309962099037L;

	public CartSteps(Pages pages) {
		super(pages);
		// TODO Auto-generated constructor stub
	}
    
	@Step
	public void verifyTitleAndPrice(List<String> list, String price) {
		cartPage().verifyTitleAndPrice(list, price);
	}
    
	@StepGroup
	public void verifyThePrices(String... prices) {
		for(String price : prices){
			verifyThePrice(price);
		}
	}
	
	@Step
	public void verifyThePrice(String price){
		cartPage().verifyThePrice(price);
	}
	
	@StepGroup
	public void verifyTheTitles(List<String>...lists) {
		for(List<String> list :lists){
			verifyTheTitle(list);
		}
	}
	
	@Step
	public void verifyTheTitle(List<String> list){
		cartPage().verifyTheTitle(list);
	}
    
	@Step
	public void removeTitleFromCart(List<String> list) {
		cartPage().removeTitleFromCart(list);
	}
    
	@Step
	public void verifyBookTitleAndPrice(List<String> list, String price) {
		cartPage().verifyBookTitleAndPrice(list, price);
	}
	
	@Step
	public void verifyMagazineTitleAndPrice(List<String> list, String price) {
		cartPage().verifyMagazineTitleAndPrice(list, price);
	}
	
}
