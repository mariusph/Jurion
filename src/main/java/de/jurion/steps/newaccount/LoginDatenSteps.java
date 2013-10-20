package de.jurion.steps.newaccount;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import de.jurion.tools.AbstractSteps;

public class LoginDatenSteps extends AbstractSteps {

    private static final long serialVersionUID = 672642333937306775L;

    public LoginDatenSteps(Pages pages) {
        super(pages);
    }

    @Step
    public String getTheUsername() {
        return loginDatenPage().getTheUsername();
    }
   
    @StepGroup
	public void fillPasswords(String password) {
    	fillTheFirstPassword(password);
    	confirmTheFirstPassword(password);
	}
    
    @Step
    public void fillTheFirstPassword(String password){
    	loginDatenPage().fillTheFirstPassword(password);
    }
    
    @Step
    public void confirmTheFirstPassword(String password){
    	loginDatenPage().confirmTheFirstPassword(password);
    }
    
    @Step
	public void expandDomainArrow() {
    	loginDatenPage().expandDomainArrow();
	}
    
    @StepGroup
	public void clickOnInsolventzRechtCheckbox() {
    	loginDatenPage().clickOnInsolventzRechtCheckbox();
    	verifyThatTheCheckBoxCounterIsIcremented();
	}
    @Step
    public int verifyThatTheCheckBoxCounterIsIcremented(){
    	return loginDatenPage().verifyThatTheCheckBoxCounterIsIcremented();
    }
    
    @Step
    public void clickOnWeiterButton() {
    	loginDatenPage().clickOnWeiterButton();
    }
    
    @Step
	public void closeDomainArrow() {
    	loginDatenPage().closeDomainArrow();
	}
    @Step
	public List<String> getProfessionalList() {
    	return loginDatenPage().getProfessionalList();
	}

}
