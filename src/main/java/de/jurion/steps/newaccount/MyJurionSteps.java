package de.jurion.steps.newaccount;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import de.jurion.tools.AbstractSteps;

public class MyJurionSteps extends AbstractSteps{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1430552910982980920L;

	public MyJurionSteps(Pages pages) {
		super(pages);
		// TODO Auto-generated constructor stub
	}
    
	@Step
	public void clickOnHeaderButton(String label) {
		myJurionPage().clickOnHeaderButton(label);
	}
    
	@Step
	public void clickOnShoppingCart() {
		myJurionPage().clickOnShoppingCart();
	}
    
	@Step
	public void clickOnHeaderUserNameButton(String usernameLabel) {
		myJurionPage().clickOnHeaderUserNameButton(usernameLabel);
	}
    
	@Step
	public void verifyTheShoppingCartIsEmpty() {
		myJurionPage().verifyTheShoppingCartIsEmpty();
	}

}
