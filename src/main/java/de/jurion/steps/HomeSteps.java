package de.jurion.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import de.jurion.tools.AbstractSteps;

public class HomeSteps extends AbstractSteps {

    private static final long serialVersionUID = -8860868710345974760L;

    public HomeSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void clickOnRegistrierenButton() {
        homePage().clickOnRegistrierenButton();
    }

    @Step
    public void openHomePage() {
        homePage().openHomePage();
    }
    
    @StepGroup
	public void fillLoginDetails(String email, String password) {
    	fillUserNameInput(email);
    	fillPasswordInput(password);
    	// click on login button
    	clickOnSubmitLoginButton();
	}
    
    @Step
    public void fillUserNameInput(String email){
    	homePage().fillUserNameInput(email);
    }
    
    @Step
    public void fillPasswordInput(String password){
    	homePage().fillPasswordInput(password);
    }
    
    @Step
    public void clickOnLoginButton(){
    	homePage().clickOnLoginButton();
    }
    
    @Step
    public void clickOnSubmitLoginButton(){
    	homePage().clickOnSubmitLoginButton();
    }
    
   

}