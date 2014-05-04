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

@Story(Application.User.CreateUser.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.TESTDATA_FILES_PATH
        + ConfigFileLibrary.CREATE_INITIAL_ACCOUNT, separator = Constants.CSV_SEPARATOR)
public class CreateInitialAccountTest extends BaseTest {

    private String institution;
    private String firstname;
    private String lastname;
    private String address;
    private String plz;
    private String city;
    private String email;
    private String phone;
    private String password;
    
    @Qualifier
	public String getQualifier(){
		return lastname +" "+ firstname;
	}

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getInstitution() {
        return institution;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getPlz() {
        return plz;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Steps
    public HomeSteps homeSteps;

    @Steps
    public RegisterSteps registerSteps;
    
    @Steps
    public RegistrationConfirmationSteps registrationConfirmationSteps;


    @Test
    public void createInitialAccount() {

        homeSteps.openHomePage();
      
        // click on 'Registrien' button
        homeSteps.clickOnRegistrierenButton();
      
        // fill the data
        email = RandomStringUtils.randomAlphanumeric(5) + email;
        password = RandomStringUtils.randomAlphabetic(5) +"_"+ firstname;
        registerSteps.fillRegisterDataForm(CustomerLabels.GENDER_MALE,
                CustomerLabels.ACADEMIC_PROF_DR, firstname, lastname,
                email, password);
        
        // check the registration confirmation
        registrationConfirmationSteps.verifyRegistrationConfirmation();
        
        
       
    }

}
