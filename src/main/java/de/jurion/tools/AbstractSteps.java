package de.jurion.tools;

import net.thucydides.core.pages.Pages;

import net.thucydides.core.steps.ScenarioSteps;
import de.jurion.pages.HomePage;
import de.jurion.pages.LoginDatenPage;
import de.jurion.pages.PersonlicheDatenPage;
import de.jurion.pages.RegistrierungStartenPage;

public class AbstractSteps extends ScenarioSteps {

	private static final long serialVersionUID = -8488441363169948528L;

	public AbstractSteps(Pages pages) {
		super(pages);
	}
	

	public HomePage homePage() {
		return getPages().currentPageAt(HomePage.class);
	}
	
	public RegistrierungStartenPage registrierungStartenPage(){
		return getPages().currentPageAt(RegistrierungStartenPage.class);
	}
	
	public PersonlicheDatenPage personlicheDatenPage() {
		return getPages().currentPageAt(PersonlicheDatenPage.class);
		}
	public LoginDatenPage loginDatenPage(){
		return getPages().currentPageAt(LoginDatenPage.class);
	}

}
