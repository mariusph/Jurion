package de.jurion.steps.newaccount;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import de.jurion.tools.AbstractSteps;

public class BestatigenSteps extends AbstractSteps{

	public BestatigenSteps(Pages pages) {
		super(pages);
		}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4511021179502109708L;
    
	@Step
	public List<String> verifyProfessionalList() {
		return bestatigenPage().verifyProfessionalList();
	}

}
