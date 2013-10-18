package de.jurion.steps.newaccount;

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
    
    @Step
	public void clickOnInsolventzRechtCheckbox() {
    	loginDatenPage().clickOnInsolventzRechtCheckbox();
	}

}
