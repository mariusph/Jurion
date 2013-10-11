package de.jurion.tools;

import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import de.jurion.pages.HomePage;

public class AbstractSteps extends ScenarioSteps {

	private static final long serialVersionUID = -8488441363169948528L;

	public AbstractSteps(Pages pages) {
		super(pages);
	}

	public HomePage homePage() {
		return getPages().currentPageAt(HomePage.class);
	}

}
