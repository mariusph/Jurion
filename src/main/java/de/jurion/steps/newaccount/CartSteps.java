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
	public void verifyBookTitleAndPrice(List<String> list, String price) {
		cartPage().verifyBookTitleAndPrice(list, price);
	}
	
	@Step
	public void verifyMagazineTitleAndPrice(List<String> list, String price) {
		cartPage().verifyMagazineTitleAndPrice(list, price);
	}
    
	@Step
	public void removeBookFromCart(List<String> list) {
		cartPage().removeBookFromCart(list);
	}
    
	@Step
	public void verifyThatBookIsRemoved(List<String> list) {
		cartPage().verifyThatBookIsRemoved(list);
	}
	
	@Step
	public void removeMagazineFromCart(List<String> list) {
		cartPage().removeMagazineFromCart(list);
	}
	
}
