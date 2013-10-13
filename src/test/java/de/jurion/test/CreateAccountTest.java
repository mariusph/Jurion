package de.jurion.test;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.jurion.requirements.Application;
import de.jurion.steps.HomeSteps;
import de.jurion.steps.RegistrierungStartenSteps;

@Story(Application.User.CreateUser.class)
@RunWith(ThucydidesRunner.class)
public class CreateAccountTest extends BaseTest {

	@Steps
	public HomeSteps homeSteps;
	
	@Steps
	public RegistrierungStartenSteps registrierungStartenSteps;

	@Test
	public void createNewAccount() {
		
		homeSteps.openHomePage();
		
		// click on 'Registrien' button
		homeSteps.clickOnRegistrierenButton();
		
		// click on 'Weiter' button to start filling the register form
		registrierungStartenSteps.clickOnWeiterButton();
		
		
	}

}