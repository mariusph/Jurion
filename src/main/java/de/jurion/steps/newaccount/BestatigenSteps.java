package de.jurion.steps.newaccount;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import org.junit.Assert;

import de.jurion.tools.AbstractSteps;

public class BestatigenSteps extends AbstractSteps {

    public BestatigenSteps(Pages pages) {
        super(pages);
    }

  private static final long serialVersionUID = -4511021179502109708L;

    @Step
    public List<String> verifyProfessionalList() {
        return bestatigenPage().verifyProfessionalList();
    }
    
    @Step
	public void compareTheProfessionalLists(List<String> list1,List<String> list2) {
		Assert.assertTrue(
				"The first list is : " + list1
						+ " is not the same with : "
						+ list2, list1.equals(list2));
	}
    
    @Step
    public void verifyCustomersLabelAndValue(String label, String value){
    	bestatigenPage().verifyCustomersLabelAndValue(label, value);
    }
   
    @StepGroup
	public void verifyCustomerLabelAndMultipleValues(String addressTitleLabel,
			String ...addressValues) {
		for(String value:addressValues){
    	verifyCustomerLabelAndMultipleValues(addressTitleLabel,value);	
		}
	}
    
    @Step
    public void verifyCustomerLabelAndMultipleValues(String addressTitleLabel,String value){
    	bestatigenPage().verifyCustomerLabelAndMultipleValues(addressTitleLabel,value);
    	
    }
    
    @Step
    public void clickOnAbsendenButton() {
    	bestatigenPage().clickOnAbsendenButton();
    	
    }
    
    @Step
	public void clickOnAgreeTermsCheckbox() {
    	bestatigenPage().clickOnAgreeTermsCheckbox();
	}
    
    @Step
	public void checkTheRegistrationMessage() {
		bestatigenPage().checkTheRegistrationMessage();
	}
    

}
