package de.jurion.pages;

import net.thucydides.core.annotations.findby.FindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import de.jurion.tools.AbstractPage;
import de.jurion.tools.Constants;

public class PersonlicheDatenPage  extends AbstractPage{

	public PersonlicheDatenPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "input#institution")
	private WebElement institutionInput;
	
	@FindBy(id = "gender")
	private WebElement anredeDropdown;
	
	@FindBy(id = "title")
	private WebElement akademischerTitelDropdown;
	
	@FindBy(css = "input#firstname")
	private WebElement vornameInput;
	
	@FindBy(css = "input#lastname")
	private WebElement nachnameInput;
	
	@FindBy(css = "input#street")
	private WebElement addressInput;
	
	@FindBy(css = "input#zipcode")
	private WebElement plzInput;
	
	@FindBy(css = "input#city")
	private WebElement cityInput;
	
	@FindBy(id = "country")
	private WebElement landDropdown;
	
	@FindBy(css = "input#email")
	private WebElement emailInput;
	
	@FindBy(id = "profession")
	private WebElement berufDropdown;
	
	@FindBy(css = "input#phone")
	private WebElement phoneInput;
	
	@FindBy(css = "div#form0-buttonnavigation-next-elem input")
	private WebElement weiterButton;

	public void fillInstitutionName(String institution) {
		element(institutionInput).waitUntilVisible();
		institutionInput.sendKeys(institution);
	}

	public void selectFromAnredeDropdown(String gender) {
		element(anredeDropdown).waitUntilVisible();
		element(anredeDropdown).selectByVisibleText(gender);
	}
	
	public void selectAcademicTitleDropdown(String academicTitle) {
		element(akademischerTitelDropdown).waitUntilVisible();
		element(akademischerTitelDropdown).selectByVisibleText(academicTitle);
	}

	public void fillVorname(String firstname) {
		element(vornameInput).waitUntilVisible();
		vornameInput.sendKeys(firstname);
	}
	
	public void fillNachName(String lastname) {
		element(nachnameInput).waitUntilVisible();
		nachnameInput.sendKeys(lastname);
	}
	
	public void fillAddress(String address) {
		element(addressInput).waitUntilVisible();
		addressInput.sendKeys(address);
	}
	
	public void fillPlz(String plz) {
		element(plzInput).waitUntilVisible();
		plzInput.sendKeys(plz);
	}

	public void fillOrt(String city) {
		element(cityInput).waitUntilVisible();
		cityInput.sendKeys(city);
	}

	public void selectLandDropdown(String country) {
		element(landDropdown).waitUntilVisible();
		element(landDropdown).selectByVisibleText(country);
	}

	public void fillEmailAdresse(String email) {
		element(emailInput).waitUntilVisible();
		emailInput.sendKeys(email);
	}
	
	public void fillTelefon(String phone) {
		element(phoneInput).waitUntilVisible();
		phoneInput.sendKeys(phone);
	}
	
	public void selectBerufDropdown(String profession) {
		element(berufDropdown).waitUntilVisible();
		element(berufDropdown).selectByVisibleText(profession);
	}

	public void clickOnWeiterButton() {
		element(emailInput).waitUntilVisible();
		emailInput.click();
	}

}

