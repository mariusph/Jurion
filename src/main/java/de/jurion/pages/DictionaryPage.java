package de.jurion.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary:Main_Page")
public class DictionaryPage extends PageObject {

    @FindBy(name="search")
	private WebElement searchTerms;
	
	@FindBy(name="go")
	private WebElement lookupButton;
	
	@FindBy(css="div[class*='button register']")
	private WebElement registerButton;
	
	@FindBy(css="div#form0-buttonnavigation-next-elem input")
	private WebElement weiterButton;
	
	public DictionaryPage(WebDriver driver) {
		super(driver);
	}

	public void enter_keywords(String keyword) {
        element(searchTerms).type(keyword);
	}

    public void lookup_terms() {
        element(lookupButton).click();
    }

    public List<String> getDefinitions() {
        WebElement definitionList = getDriver().findElement(By.tagName("ol"));
        List<WebElement> results = definitionList.findElements(By.tagName("li"));
        return convert(results, toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }

	public void navigateToHomePage() {
		getDriver().get("https://www.jurion.de");
	
	}

	public void clickOnRegisterButton() {
		element(registerButton).waitUntilVisible();
		waitABit(2000);
		registerButton.sendKeys("");
		registerButton.click();
		waitABit(2000);
	}

	public void clickForRegistering() {
		waitABit(2000);
		element(registerButton).waitUntilVisible();
		System.out.println("XXX XXX");
		registerButton.click();
	}
}


