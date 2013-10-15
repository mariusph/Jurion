package de.jurion.steps.newaccount;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import de.jurion.tools.AbstractSteps;

public class RegistrierungStartenSteps extends AbstractSteps {

    private static final long serialVersionUID = 520584834076833569L;

    public RegistrierungStartenSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void clickOnWeiterButton() {
        registrierungStartenPage().clickOnWeiterButton();
    }

}
