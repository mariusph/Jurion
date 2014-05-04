package de.jurion.pages.newaccount;

import net.thucydides.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
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
	
	@FindBy(id = "error-firstname")
	private WebElement firstnameErrorContainer;
	
	@FindBy(id = "error-lastname")
	private WebElement lastnameErrorContainer;
	
	@FindBy(id = "error-email")
	private WebElement emailErrorContainer;
	
	@FindBy(id = "error-password")
	private WebElement passwordErrorContainer;

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
	        vornameInput.clear();
	        vornameInput.sendKeys(firstname);
	    }

	    public void fillNachName(String lastname) {
	        element(nachnameInput).waitUntilVisible();
	        nachnameInput.clear();
	        nachnameInput.sendKeys(lastname);
	    }
	    
	    public void fillUsernameInput(String email) {
			element(nutznameInput).waitUntilVisible();
			nutznameInput.clear();
			nutznameInput.sendKeys(email);
		}

		public void fillPasswordInput(String password) {
			element(passwortInput).waitUntilVisible();
			passwortInput.clear();
			passwortInput.sendKeys(password);
		}

		public void tickAcceptTermsCheckbox() {
			element(firstCheckbox).waitUntilVisible();
			if(firstCheckbox.getText().contains("c")){
				firstCheckbox.click();
			}
			else{
				System.out.println("Accept Terms heckbox has been already ticked");
			}
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

	public void verifyFirstNameErrorMessage(String firstnameErrorMessage) {
		element(firstnameErrorContainer).waitUntilVisible();
		Assert.assertTrue("! The firstname error message is different "
				+ firstnameErrorContainer.getText(), firstnameErrorContainer
				.getText().equals(firstnameErrorMessage));
	}

	public void verifyLastNameErrorMessage(String lastnameErrorMessage) {
		element(lastnameErrorContainer).waitUntilVisible();
		Assert.assertTrue("! The lastname error message is different "
				+ lastnameErrorContainer.getText(), lastnameErrorContainer
				.getText().equals(lastnameErrorMessage));
	}

	public void verifyEmailErrorMessage(String emailErrorMessage) {
		element(emailErrorContainer).waitUntilVisible();
		Assert.assertTrue("! The email error message is different "
				+ emailErrorContainer.getText(), emailErrorContainer
				.getText().equals(emailErrorMessage));
	}
	
	public void getComputedStyle(){
		String js= "return window.document.defaultView.getComputedStyle(" +
                    "window.document.getElementById('error-email'))";
		String jsHeight = js+".getPropertyValue('height')";
        String jswidth = js+".getPropertyValue('width')";
        
        JavascriptExecutor jsexecuter = (JavascriptExecutor) getDriver();
        String height = (String) jsexecuter.executeScript(jsHeight);
        String width = (String) jsexecuter.executeScript(jswidth);
        System.out.println("This is the elem position : " + width+" X "+height);
	}

	public void verifyPasswordErrorMessage(String passwordErrorMessage) {
		element(passwordErrorContainer).waitUntilVisible();
		Assert.assertTrue("! The password error message is different "
				+ passwordErrorContainer.getText(), passwordErrorContainer
				.getText().equals(passwordErrorMessage));
	}



}
