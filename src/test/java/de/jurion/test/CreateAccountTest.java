package de.jurion.test;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.jurion.requirements.Application;
import de.jurion.steps.HomeSteps;

@Story(Application.User.CreateUser.class)
@RunWith(ThucydidesRunner.class)
public class CreateAccountTest extends BaseTest {

	@Steps
	public HomeSteps endUser;

	@Test
	public void createNewAccount() {
		endUser.clickOnRegisterButton();
		endUser.clickForRegistering();

	}

}