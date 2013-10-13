package de.jurion.test;

import java.util.Random;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.util.StringUtils;

import de.jurion.model.CustomerModel;
import de.jurion.requirements.Application;
import de.jurion.steps.HomeSteps;
import de.jurion.steps.newaccount.PersonlicheDatenSteps;
import de.jurion.steps.newaccount.RegistrierungStartenSteps;
import de.jurion.tools.ConfigFileLibrary;
import de.jurion.tools.Constants;
import de.jurion.tools.CustomerLabels;

@Story(Application.User.CreateUser.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.TESTDATA_FILES_PATH + ConfigFileLibrary.CREATE_CUSTOMER,
separator = Constants.CSV_SEPARATOR)

public class CreateAccountTest extends BaseTest {
	
//	private CustomerModel customerModel;
	
	private String institution;
	private String firstname;
	private String lastname;
	private String address;
	private String plz;
	private String city;
	private String email;
	private String phone;
	
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

	public void setCity(String city) {
		this.city = city;
	}


	@Steps
	public HomeSteps homeSteps;
	
	@Steps
	public RegistrierungStartenSteps registrierungStartenSteps;
	
	@Steps
	public PersonlicheDatenSteps personlicheDatenSteps;

	@Test
	public void createNewAccount() {
		
		homeSteps.openHomePage();
		
		// click on 'Registrien' button
		homeSteps.clickOnRegistrierenButton();
		
		// click on 'Weiter' button to start filling the register form
		registrierungStartenSteps.clickOnWeiterButton();
		
		// fill the data
//		personlicheDatenSteps.fillTheDataForm(customerModel.getInstitution());
		email= RandomStringUtils.randomAlphanumeric(5)+ email;
		personlicheDatenSteps.fillTheDataForm(institution,
				CustomerLabels.GENDER_MALE, CustomerLabels.ACADEMIC_PROF_DR,
				firstname, lastname, address, plz, city, CustomerLabels.COUNTRY,
				email, phone, CustomerLabels.PROFESSION);

	}

}