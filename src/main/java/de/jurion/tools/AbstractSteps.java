package de.jurion.tools;

import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import de.jurion.pages.HomePage;
import de.jurion.pages.newaccount.BestatigenPage;
import de.jurion.pages.newaccount.CartPage;
import de.jurion.pages.newaccount.LoginDatenPage;
import de.jurion.pages.newaccount.MyJurionPage;
import de.jurion.pages.newaccount.PersonlicheDatenPage;
import de.jurion.pages.newaccount.RegisterPage;
import de.jurion.pages.newaccount.RegistrierungStartenPage;
import de.jurion.pages.newaccount.StorePage;

public class AbstractSteps extends ScenarioSteps {

    private static final long serialVersionUID = -8488441363169948528L;

    public AbstractSteps(Pages pages) {
        super(pages);
    }

    public HomePage homePage() {
        return getPages().currentPageAt(HomePage.class);
    }

    public RegistrierungStartenPage registrierungStartenPage() {
        return getPages().currentPageAt(RegistrierungStartenPage.class);
    }

    public PersonlicheDatenPage personlicheDatenPage() {
        return getPages().currentPageAt(PersonlicheDatenPage.class);
    }

    public LoginDatenPage loginDatenPage() {
        return getPages().currentPageAt(LoginDatenPage.class);
    }
    
    public BestatigenPage bestatigenPage(){
    	return getPages().currentPageAt(BestatigenPage.class);
    }
    
    public RegisterPage registerPage(){
    	return getPages().currentPageAt(RegisterPage.class);
    }
    
    public MyJurionPage myJurionPage(){
    	return getPages().currentPageAt(MyJurionPage.class);
    }
    
    public StorePage storePage(){
    	return getPages().currentPageAt(StorePage.class);
    }
    
    public CartPage cartPage(){
    	return getPages().currentPageAt(CartPage.class);
    }

}
