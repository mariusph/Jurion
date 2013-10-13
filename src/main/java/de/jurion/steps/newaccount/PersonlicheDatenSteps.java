package de.jurion.steps.newaccount;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import de.jurion.tools.AbstractSteps;

public class PersonlicheDatenSteps extends AbstractSteps{

	public PersonlicheDatenSteps(Pages pages) {
		super(pages);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7662442081710796690L;
   
	@StepGroup
	public void fillTheDataForm(String institution, String gender, String academicTitle,
			String firstname, String lastname, String address, String plz, String city, 
			String country, String email, String phone, String profession) {
		fillInstitutionName(institution);
		selectFromAnredeDropdown(gender);
		selectAcademicTitleDropdown(academicTitle);
		fillVorname(firstname);
		fillNachName(lastname);
		fillAddress(address);
		fillPlz(plz);
		fillOrt(city);
		selectLandDropdown(country);
		fillEmailAdresse(email);
		fillTelefon(phone);
		selectBerufDropdown(profession);
		clickOnWeiterButton();
	}
	
	@Step
	public void fillInstitutionName(String institution){
		personlicheDatenPage().fillInstitutionName(institution);
	}
	
	@Step
	public void selectFromAnredeDropdown(String gender){
		personlicheDatenPage().selectFromAnredeDropdown(gender);
	}
	
	@Step
	public void selectAcademicTitleDropdown(String academicTitle){
		personlicheDatenPage().selectAcademicTitleDropdown(academicTitle);
	}
	
	@Step
	public void fillVorname(String firstname){
		personlicheDatenPage().fillVorname(firstname);
	}
	
	@Step
	public void fillNachName(String lastname){
		personlicheDatenPage().fillNachName(lastname);
	}
	
	@Step
	public void fillAddress(String address){
		personlicheDatenPage().fillAddress(address);
	}
	
	@Step
	public void fillPlz(String plz){
		personlicheDatenPage().fillPlz(plz);
	}
	
	@Step
	public void fillOrt(String city){
		personlicheDatenPage().fillOrt(city);
	}
	
	@Step
	public void selectLandDropdown(String country){
		personlicheDatenPage().selectLandDropdown(country);
	}
	
	@Step
	public void fillEmailAdresse(String email){
		personlicheDatenPage().fillEmailAdresse(email);
	}
	
	@Step
	public void fillTelefon(String phone) {
		personlicheDatenPage().fillTelefon(phone);
	}
	
	@Step
	public void selectBerufDropdown(String profession) {
		personlicheDatenPage().selectBerufDropdown(profession);
	}
	
	@Step
	public void clickOnWeiterButton(){
		personlicheDatenPage().clickOnWeiterButton();
	}
   
}
