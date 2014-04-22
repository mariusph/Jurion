package de.jurion.steps.newaccount;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import de.jurion.tools.AbstractSteps;

public class RegisterSteps extends AbstractSteps{

	public RegisterSteps(Pages pages) {
		super(pages);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6505619819300294355L;
   
	 @StepGroup
	    public void fillRegisterDataForm(String gender,
	            String academicTitle, String firstname, String lastname,
	            String email, String password) {
//	        fillInstitutionName(institution);
	        selectFromAnredeCheckbox(gender);
	        selectAcademicTitleDropdown(academicTitle);
	        fillVorname(firstname);
	        fillNachName(lastname);
	        fillUsernameInput(email);
	        fillPasswordInput(password);
	        tickAcceptTermsCheckbox();
	        tickAcceptNewsletterCheckbox();
	        tickDataProtectionCheckbox();
	        clickOnRegisterButton();

	    }
	 
	@Step
	public void selectFromAnredeCheckbox(String gender) {
		registerPage().selectFromAnredeCheckbox(gender);
	}

	@Step
	public void selectAcademicTitleDropdown(String academicTitle) {
		registerPage().selectAcademicTitleDropdown(academicTitle);
	}

	@Step
	public void fillVorname(String firstname) {
		registerPage().fillVorname(firstname);
	}

	@Step
	public void fillNachName(String lastname) {
		registerPage().fillNachName(lastname);
	}

	@Step
	public void fillUsernameInput(String email) {
		registerPage().fillUsernameInput(email);
	}

	@Step
	public void fillPasswordInput(String password) {
		registerPage().fillPasswordInput(password);
	}

	@Step
	public void tickAcceptTermsCheckbox() {
		registerPage().tickAcceptTermsCheckbox();
	}

	@Step
	public void tickAcceptNewsletterCheckbox() {
		registerPage().tickAcceptNewsletterCheckbox();
	}

	@Step
	public void tickDataProtectionCheckbox() {
		registerPage().tickDataProtectionCheckbox();
	}

	@Step
	public void clickOnRegisterButton() {
		registerPage().clickOnRegisterButton();
	}

}
