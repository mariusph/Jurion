package de.jurion.pages.newaccount;

import net.thucydides.core.annotations.findby.FindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import de.jurion.tools.AbstractPage;

public class RegisterPage extends AbstractPage{

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "div#gender-elem")
	private WebElement genderCheckboxContainer;

	@FindBy(id = "gender-1")
	private WebElement anrredeHerrCheckbox;

	@FindBy(css = "input#gender-2")
	private WebElement anrredeFrauCheckbox;

	@FindBy(id = "title")
	private WebElement akademischerTitelDropdown;

	@FindBy(css = "input#firstname")
	private WebElement vornameInput;

	@FindBy(css = "input#lastname")
	private WebElement nachnameInput;

	@FindBy(css = "input#email")
	private WebElement nutznameInput;

	@FindBy(css = "input#password")
	private WebElement passwortInput;

	@FindBy(css = "#confirm_terms-elem span.checkbox")
	private WebElement firstCheckbox;

	@FindBy(css = "#accept_newsletter-elem span.checkbox")
	private WebElement secondCheckbox;

	@FindBy(css = "#accept_marketing-elem span.checkbox")
	private WebElement thirdCheckbox;

	@FindBy(css = "input#submit")
	private WebElement registerButton;

	     // needs refactoringgg
	    public void selectFromAnredeCheckbox(String gender) {
	        element(genderCheckboxContainer).waitUntilVisible();
//	        if(gender==CustomerLabels.GENDER_MALE)
	        System.out.println("XXX : "+genderCheckboxContainer.getText());
	        elementFocus("div#gender-elem input#gender-1");
	        System.out.println("Is focused indeeed !!!");
	        elementjQueryClick("div#gender-elem input#gender-1");
//	        	List<WebElement> elems = genderCheckboxContainer.findElements(By.cssSelector("span.radio"));
//	        	for(WebElement elem:elems){
//	        	if(elem.getText().contains(gender)){
//	        		elem.click();
//	        	}	
//	        	}
//	        else if(gender==CustomerLabels.GENDER_MALE)
//	        	genderCheckboxContainer.findElement(By.cssSelector("input#gender-2")).click();
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
	    
	    public void fillUsernameInput(String email) {
			element(nutznameInput).waitUntilVisible();
			nutznameInput.sendKeys(email);
		}

		public void fillPasswordInput(String password) {
			element(passwortInput).waitUntilVisible();
			passwortInput.sendKeys(password);
		}

		public void tickAcceptTermsCheckbox() {
			element(firstCheckbox).waitUntilVisible();
			firstCheckbox.click();
		}

		public void tickAcceptNewsletterCheckbox() {
			element(secondCheckbox).waitUntilVisible();
			secondCheckbox.click();
		}

		public void tickDataProtectionCheckbox() {
			element(thirdCheckbox).waitUntilVisible();
			thirdCheckbox.click();
		}

		public void clickOnRegisterButton() {
			element(registerButton).waitUntilVisible();
			registerButton.click();
		}



}
