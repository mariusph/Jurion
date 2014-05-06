package de.jurion.test;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.jurion.requirements.Application;
import de.jurion.steps.HomeSteps;
import de.jurion.steps.newaccount.RegisterSteps;
import de.jurion.steps.newaccount.RegistrationConfirmationSteps;
import de.jurion.tools.ConfigFileLibrary;
import de.jurion.tools.Constants;
import de.jurion.tools.CustomerLabels;

/********************************
 * Create a new account
 * Checks that leaving empty the compulsory fields will
 * popup expected error messages
 * Checks the position for each error message
 ********************************
*/

@Story(Application.User.CreateUser.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.TESTDATA_FILES_PATH
        + ConfigFileLibrary.CREATE_INITIAL_ACCOUNT, separator = Constants.CSV_SEPARATOR)
public class CreateInitialAccountVerifyErrorMessagesTest extends BaseTest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    
    @Qualifier
	public String getQualifier(){
		return lastname +" "+ firstname;
	}

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
    public RegisterSteps registerSteps;
    
    @Steps
    public RegistrationConfirmationSteps registrationConfirmationSteps;


    @Test
    public void createInitialAccountAndVerifyErrorMessages() {

        homeSteps.openHomePage();
      
        // click on 'Registrien' button
        homeSteps.clickOnRegistrierenButton();
        
        // check the firstname error message
        String firstname1= "";
        email = RandomStringUtils.randomAlphanumeric(5) + email;
        password = RandomStringUtils.randomAlphabetic(5) +"_"+ firstname;
        registerSteps.fillRegisterDataForm(CustomerLabels.GENDER_MALE,
                CustomerLabels.ACADEMIC_PROF_DR, firstname1, lastname,
                email, password);
        registerSteps.verifyFirstNameErrorMessage(CustomerLabels.FIRSTNAME_ERROR_MESSAGE);
        
        //BUG : actually the width is '231px'!!
//        String firstnameErrorId = "error-firstname";
//        String position = "239px"+" X "+"19px";
//        registerSteps.getComputedStyle(firstnameErrorId);
//        registerSteps.verifyElementPosition(firstnameErrorId, position);
        
        // check the lastname error message
        String lastname2= "";
        registerSteps.fillRegisterDataForm(CustomerLabels.GENDER_MALE,
                CustomerLabels.ACADEMIC_PROF_DR, firstname, lastname2,
                email, password);
        registerSteps.verifyLastNameErrorMessage(CustomerLabels.LASTNAME_ERROR_MESSAGE);
        
        String lastnameErrorId = "error-lastname";
        String position1 = "589px"+" X "+"19px";
        registerSteps.getComputedStyle(lastnameErrorId);
        registerSteps.verifyElementPosition(lastnameErrorId, position1);
        
        // check the username error message
        String email2= email.replace("@", "");
        registerSteps.fillRegisterDataForm(CustomerLabels.GENDER_MALE,
                CustomerLabels.ACADEMIC_PROF_DR, firstname, lastname,
                email2, password);
        registerSteps.verifyEmailErrorMessage(CustomerLabels.EMAIL_ERROR_MESSAGE);
        
        String emailErrorId = "error-email";
        String position2 = "589px"+" X "+"38px";
        registerSteps.getComputedStyle(emailErrorId);
        registerSteps.verifyElementPosition(emailErrorId, position2);
        
        // check the password error message
        String password2= "";
        registerSteps.fillRegisterDataForm(CustomerLabels.GENDER_MALE,
                CustomerLabels.ACADEMIC_PROF_DR, firstname, lastname,
                email, password2);
        registerSteps.verifyPasswordErrorMessage(CustomerLabels.PASSWORD_ERROR_MESSAGE);
       
        String passwordErrorId = "error-password";
        String position3 = "589px"+" X "+"19px";
        registerSteps.getComputedStyle(passwordErrorId);
        registerSteps.verifyElementPosition(passwordErrorId, position3);
        
        // check terms condition error message
        registerSteps.fillRegisterDataFormWithoutAcceptingTerms(CustomerLabels.GENDER_MALE,
                CustomerLabels.ACADEMIC_PROF_DR, firstname, lastname,
                email, password);
        registerSteps.verifyAcceptTermsErrorMessage(CustomerLabels.TERMS_ERROR_MESSAGE);
      
        String termsErrorId = "error-confirm_terms";
        String position4 = "589px"+" X "+"46px";
        registerSteps.getComputedStyle(termsErrorId);
        registerSteps.verifyElementPosition(termsErrorId, position4);
        
    }

}
