package de.jurion.steps.newaccount;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import de.jurion.tools.AbstractSteps;

public class RegistrationConfirmationSteps extends AbstractSteps{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6633345549063658812L;

	public RegistrationConfirmationSteps(Pages pages) {
		super(pages);
		// TODO Auto-generated constructor stub
	}
    
	@Step
	public void verifyRegistrationConfirmation() {
		registrationConfirmationPage().verifyRegistrationConfirmation();
	}

}
