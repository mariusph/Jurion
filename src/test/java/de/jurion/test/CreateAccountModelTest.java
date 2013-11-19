package de.jurion.test;

import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.jurion.model.CustomerModel;
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
public class CreateAccountModelTest extends BaseTest {

    private CustomerModel customer = new CustomerModel();
    private List<String> list1 = new ArrayList<String>();
    private List<String> list2 = new ArrayList<String>();

    @Qualifier
    public String getQualifier() {
        return customer.getLastname() + " " + customer.getFirstname();
    }

    public void setInstitution(String institution) {
        customer.setInstitution(institution);
    }

    public void setFirstname(String firstname) {
        customer.setFirstname(firstname
                + RandomStringUtils.randomAlphanumeric(5));
    }

    public void setLastname(String lastname) {
        customer.setLastname(lastname);
    }

    public void setAddress(String address) {
        customer.setAddress(address);
    }

    public void setPlz(String plz) {
        customer.setPlz(plz);
    }

    public void setEmail(String email) {
        customer.setEmail(email + RandomStringUtils.randomAlphanumeric(5));
    }

    public void setPhone(String phone) {
        customer.setPhone(phone);
    }

    public void setPassword(String password) {
        customer.setPassword(password);
    }

    public void setCity(String city) {
        customer.setCity(city);
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
        registrierungStartenSteps.clickOnWeiterButton();

        personlicheDatenSteps.fillTheDataForm(customer);

        // login credentials
        loginDatenSteps.getTheUsername();
        customer.setUsername(loginDatenSteps.getTheUsername());

        loginDatenSteps.fillPasswords(customer.getPassword());

        loginDatenSteps.expandDomainArrow();
        loginDatenSteps.clickOnInsolventzRechtCheckbox();
        loginDatenSteps.closeDomainArrow();

        loginDatenSteps.getProfessionalList();
        list1 = loginDatenSteps.getProfessionalList();
        loginDatenSteps.clickOnWeiterButton();

        // verify customer's info's
        // check email
        bestatigenSteps.verifyCustomersLabelAndValue(
                CustomerLabels.EMAIL_ADDRESS_LABEL, customer.getEmail());
        // verify the telephone
        bestatigenSteps.verifyCustomersLabelAndValue(
                CustomerLabels.PHONE_LABEL, customer.getPhone());
        // verify the profession
        bestatigenSteps.verifyCustomersLabelAndValue(
                CustomerLabels.PROFESSION_TITLE_LABEL,
                CustomerLabels.PROFESSION);
        // verify the address details
        bestatigenSteps.verifyCustomerLabelAndMultipleValues(
                CustomerLabels.ADDRESS_TITLE_LABEL, customer.getInstitution(),
                CustomerLabels.GENDER_MALE, CustomerLabels.ACADEMIC_PROF_DR,
                customer.getLastname(), customer.getFirstname(),
                customer.getAddress(), customer.getPlz(), customer.getCity(),
                CustomerLabels.COUNTRY);
        // verify the username
        bestatigenSteps.verifyCustomersLabelAndValue(
                CustomerLabels.USERNAME_TITLE_LABEL, customer.getUsername());
        // verify the field of interest
        bestatigenSteps.verifyCustomersLabelAndValue(
                CustomerLabels.INTERNATIONAL_LAW_TITLE_LABEL,
                CustomerLabels.INTERNATIONAL_LAW_SUBDOMAIN);
        // verify the geographic area of interest
        bestatigenSteps.verifyProfessionalList();
        list2 = bestatigenSteps.verifyProfessionalList();
        // chack that the lists are the same
        bestatigenSteps.compareTheProfessionalLists(list1, list2);

        // click on agree terms checkbox
        bestatigenSteps.clickOnAgreeTermsCheckbox();

        // click on submitt button
        bestatigenSteps.clickOnAbsendenButton();

        // check the confirmation message for registration
        bestatigenSteps.checkTheRegistrationMessage();

    }

}