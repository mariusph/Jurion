package de.jurion.steps.newaccount;

import net.thucydides.core.annotations.Step;
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

}
