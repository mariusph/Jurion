package de.jurion.steps.newaccount;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import de.jurion.model.CustomerModel;
import de.jurion.tools.AbstractSteps;
import de.jurion.tools.CustomerLabels;

public class PersonlicheDatenSteps extends AbstractSteps {

    private static final long serialVersionUID = -7662442081710796690L;

    public PersonlicheDatenSteps(Pages pages) {
        super(pages);
    }

    @StepGroup
    public void fillTheDataForm(String institution, String gender,
            String academicTitle, String firstname, String lastname,
            String address, String plz, String city, String country,
            String email, String phone, String profession) {
//        fillInstitutionName(institution);
        selectFromAnredeCheckbox(gender);
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

    // using model
    @StepGroup
    public void fillTheDataForm(CustomerModel customer) {
//        fillInstitutionName(customer.getInstitution());
        selectFromAnredeCheckbox(CustomerLabels.GENDER_MALE);
        selectAcademicTitleDropdown(CustomerLabels.ACADEMIC_PROF_DR);
        fillVorname(customer.getFirstname());
        fillNachName(customer.getLastname());
        fillAddress(customer.getAddress());
        fillPlz(customer.getPlz());
        fillOrt(customer.getCity());
        selectLandDropdown(CustomerLabels.COUNTRY);
        fillEmailAdresse(customer.getEmail());
        fillTelefon(customer.getPhone());
        selectBerufDropdown(CustomerLabels.PROFESSION);
        clickOnWeiterButton();
    }

    @Step
    public void fillInstitutionName(String institution) {
        personlicheDatenPage().fillInstitutionName(institution);
    }

    @Step
    public void selectFromAnredeCheckbox(String gender) {
        personlicheDatenPage().selectFromAnredeCheckbox(gender);
    }

    @Step
    public void selectAcademicTitleDropdown(String academicTitle) {
        personlicheDatenPage().selectAcademicTitleDropdown(academicTitle);
    }

    @Step
    public void fillVorname(String firstname) {
        personlicheDatenPage().fillVorname(firstname);
    }

    @Step
    public void fillNachName(String lastname) {
        personlicheDatenPage().fillNachName(lastname);
    }

    @Step
    public void fillAddress(String address) {
        personlicheDatenPage().fillAddress(address);
    }

    @Step
    public void fillPlz(String plz) {
        personlicheDatenPage().fillPlz(plz);
    }

    @Step
    public void fillOrt(String city) {
        personlicheDatenPage().fillOrt(city);
    }

    @Step
    public void selectLandDropdown(String country) {
        personlicheDatenPage().selectLandDropdown(country);
    }

    @Step
    public void fillEmailAdresse(String email) {
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
    public void clickOnWeiterButton() {
        personlicheDatenPage().clickOnWeiterButton();
    }

}
