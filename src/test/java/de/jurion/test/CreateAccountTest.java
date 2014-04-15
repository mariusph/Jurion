package de.jurion.test;

import java.util.List;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.jurion.requirements.Application;
import de.jurion.steps.HomeSteps;
import de.jurion.steps.newaccount.BestatigenSteps;
import de.jurion.steps.newaccount.LoginDatenSteps;
import de.jurion.steps.newaccount.PersonlicheDatenSteps;
import de.jurion.steps.newaccount.RegistrierungStartenSteps;
import de.jurion.tools.ConfigFileLibrary;
import de.jurion.tools.Constants;
import de.jurion.tools.CustomerLabels;

@Story(Application.User.CreateUser.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.TESTDATA_FILES_PATH
        + ConfigFileLibrary.CREATE_CUSTOMER, separator = Constants.CSV_SEPARATOR)
public class CreateAccountTest extends BaseTest {

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
    public RegistrierungStartenSteps registrierungStartenSteps;

    @Steps
    public PersonlicheDatenSteps personlicheDatenSteps;

    @Steps
    public LoginDatenSteps loginDatenSteps;

    @Steps
    public BestatigenSteps bestatigenSteps;

    @Test
    public void createNewAccount() {

        homeSteps.openHomePage();
      
        // click on 'Registrien' button
        homeSteps.clickOnRegistrierenButton();

        // click on 'Weiter' button to start filling the register form
//        registrierungStartenSteps.clickOnWeiterButton();

        // fill the data
        email = RandomStringUtils.randomAlphanumeric(5) + email;
        firstname = RandomStringUtils.randomAlphabetic(5) + firstname;
        personlicheDatenSteps
                .fillTheDataForm(institution, CustomerLabels.GENDER_MALE,
                        CustomerLabels.ACADEMIC_PROF_DR, firstname, lastname,
                        address, plz, city, CustomerLabels.COUNTRY, email,
                        phone, CustomerLabels.PROFESSION);

        // login credentials
        loginDatenSteps.getTheUsername();
        String username = loginDatenSteps.getTheUsername();

        loginDatenSteps.fillPasswords(password);

        loginDatenSteps.expandDomainArrow();
        loginDatenSteps.clickOnInsolventzRecht();
        loginDatenSteps.closeDomainArrow();

        loginDatenSteps.getProfessionalList();
        List<String> list1 = loginDatenSteps.getProfessionalList();
        loginDatenSteps.clickOnWeiterButton();

        // verify customer's info's
        // check email
        bestatigenSteps.verifyCustomersLabelAndValue(CustomerLabels.EMAIL_ADDRESS_LABEL, email);
        // verify the telephone
        bestatigenSteps.verifyCustomersLabelAndValue(CustomerLabels.PHONE_LABEL, phone);
        // verify the profession
        bestatigenSteps.verifyCustomersLabelAndValue(CustomerLabels.PROFESSION_TITLE_LABEL, CustomerLabels.PROFESSION);
        // verify the address details
		bestatigenSteps.verifyCustomerLabelAndMultipleValues(
						CustomerLabels.ADDRESS_TITLE_LABEL, institution,
						CustomerLabels.GENDER_MALE,
						CustomerLabels.ACADEMIC_PROF_DR, lastname, firstname,
						address, plz, city, CustomerLabels.COUNTRY);
       // verify the username
		bestatigenSteps.verifyCustomersLabelAndValue(CustomerLabels.USERNAME_TITLE_LABEL, username);
		// verify the field of interest
		bestatigenSteps.verifyCustomersLabelAndValue(CustomerLabels.INTERNATIONAL_LAW_TITLE_LABEL, CustomerLabels.INTERNATIONAL_LAW_SUBDOMAIN);
		// verify the geographic area of interest
		bestatigenSteps.verifyProfessionalList();
        List<String> list2 = bestatigenSteps.verifyProfessionalList();
        // chack that the lists are the same
        bestatigenSteps.compareTheProfessionalLists(list1,list2);
        
        // click on agree terms checkbox
        bestatigenSteps.clickOnAgreeTermsCheckbox();
        
        // click on submitt button
        bestatigenSteps.clickOnAbsendenButton();
        
        // check the confirmation message for registration
        bestatigenSteps.checkTheRegistrationMessage();
        
        
        
    }

}
