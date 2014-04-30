package de.jurion.steps.newaccount;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import de.jurion.tools.AbstractSteps;

public class StoreSteps extends AbstractSteps{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8025578911633652268L;

	public StoreSteps(Pages pages) {
		super(pages);
		// TODO Auto-generated constructor stub
	}
    
	@StepGroup
	public void searchBySubject(String subject) {
		fillSearchInput(subject);
		clickOnSearchButton();
		
	}
	
	@Step
	public void fillSearchInput(String subject){
		storePage().fillSearchInput(subject);
	}
	
	@Step
	public void clickOnSearchButton(){
		storePage().clickOnSearchButton();
	}
    
	@Step
	public void refineTheSearchAfterBook() {
		storePage().refineTheSearchAfterBook();
	}
	
	@Step
	public List<String> getResultsList(String subject){
		return storePage().getResultsList(subject);
	}
    
	@Step
	public void chooseFromResultsList(String subject) {
		storePage().chooseFromResultsList(subject);
	}
	
	@Step
	public void verifyTheChoosenTitle(List<String> list) {
		storePage().verifyTheChoosenTitle(list);
	}

}
