package de.jurion.test;

import java.util.List;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.jurion.requirements.Application;
import de.jurion.steps.HomeSteps;
import de.jurion.steps.newaccount.BestatigenSteps;
import de.jurion.steps.newaccount.CartSteps;
import de.jurion.steps.newaccount.LoginDatenSteps;
import de.jurion.steps.newaccount.MyJurionSteps;
import de.jurion.steps.newaccount.RegisterSteps;
import de.jurion.steps.newaccount.RegistrierungStartenSteps;
import de.jurion.steps.newaccount.StoreSteps;
import de.jurion.tools.ConfigFileLibrary;
import de.jurion.tools.Constants;
import de.jurion.tools.CustomerLabels;

@Story(Application.Customer.BuyProducts.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.TESTDATA_FILES_PATH
        + ConfigFileLibrary.CUSTOMER_LOGIN_AND_BUY, separator = Constants.CSV_SEPARATOR)
public class CustomerAddAndRemoveFromCartTest extends BaseTest {

    private String subject;
    private String email;
    private String password;
    
    @Qualifier
	public String getQualifier(){
		return email;
	}

    public void setSuject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Steps
    public HomeSteps homeSteps;

    @Steps
    public RegistrierungStartenSteps registrierungStartenSteps;

    @Steps
    public RegisterSteps registerSteps;

    @Steps
    public LoginDatenSteps loginDatenSteps;

    @Steps
    public BestatigenSteps bestatigenSteps;
    
    @Steps
    public MyJurionSteps myJurionSteps;
    
    @Steps
    public StoreSteps storeSteps;
    
    @Steps
    public CartSteps cartSteps;

    @Test
    public void customerAddAndRemoveFromCart() {

        homeSteps.openHomePage();
      
        // click on 'Anmelden' button
        homeSteps.clickOnLoginButton();
        
        // login details
        homeSteps.fillLoginDetails(email, password);
        
        // click on Shop
        myJurionSteps.clickOnHeaderButton(CustomerLabels.SHOP_LABEL);
        
        // search for a subject
        storeSteps.searchBySubject(subject);
        
        // refine the search, using as first criteria : 'bucher'
        storeSteps.refineTheSearchAfterBook();
        
        // choose the first book from the list that has the title containing the subject
        List<String> list1 = storeSteps.getResultsList(subject);
        storeSteps.chooseFromResultsList(subject);
        
        // verify if the same title
        storeSteps.verifyTheChoosenTitle(list1);
        
        // add the book to chart
        String price1 = storeSteps.getThePrice();
        storeSteps.addToCart(list1);
        
        // go in the Store
        myJurionSteps.clickOnHeaderButton(CustomerLabels.SHOP_LABEL);
        
        // search for a subject
        storeSteps.searchBySubject(subject);
        
        // refine the search, using as first criteria : 'zeitschriften'
        storeSteps.refineTheSearchAfterMagazine();
        
        // sort after 'Titles descending'
        storeSteps.refineResultsAfterTitleDescending();
        
     // choose the first magazine from the list that has the title containing the subject
        List<String> list2 = storeSteps.getResultsList(subject);
        
        storeSteps.chooseFromResultsList(subject);
        
       // verify if the same title
        storeSteps.verifyTheChoosenTitle(list2);
        
        // add the magazine to chart
        String price2 = storeSteps.getThePrice();
        storeSteps.addToCart(list2);
        
        // click on Shopping Cart
        myJurionSteps.clickOnShoppingCart();
        
        // verify in the cart the book and the magazine
        cartSteps.verifyBookTitleAndPrice(list1, price1);
        cartSteps.verifyMagazineTitleAndPrice(list2, price2);
        
        //remove the book from the cart
        cartSteps.removeBookFromCart(list1);
        // verify if the book was removed
        cartSteps.verifyThatBookIsRemoved(list1);
       
        //logout user and re-login
        myJurionSteps.clickOnHeaderUserNameButton(CustomerLabels.USERNAME_LABEL);
        myJurionSteps.clickOnHeaderButton(CustomerLabels.LOGOUT);
        
        // click on 'Anmelden' button
        homeSteps.clickOnLoginButton();
        
        // login details
        homeSteps.fillLoginDetails(email, password);
        
     // click on Shopping Cart, check that the magazine is there
        myJurionSteps.clickOnShoppingCart();
        cartSteps.verifyMagazineTitleAndPrice(list2, price2);
        // verify if the book is still removed
        cartSteps.verifyThatBookIsRemoved(list1);
        
       //remove the magazine from the cart
        cartSteps.removeMagazineFromCart(list2);
        // verify that the cart is empty
        myJurionSteps.verifyTheShoppingCartIsEmpty();
        
    }

}
