package de.jurion.pages.newaccount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import de.jurion.tools.AbstractPage;
import java.io.*;

public class BestatigenPage extends AbstractPage{

	public BestatigenPage(WebDriver driver) {
		super(driver);
		}
	
    @FindBy(id = "form3-lastCheckStep2_10")
    private WebElement wirkungskreisCheckBoxesContainer;

	public List<String> verifyProfessionalList() {
		List<String> list = new ArrayList<String>();
		
		WebElement myString =  wirkungskreisCheckBoxesContainer.findElement(By.cssSelector("div.lastcheck-content"));
		String[] items = (myString.getText()).split("\n");
		list = Arrays.asList(items);
		for(String elem:list){
			System.out.println("DDD "+elem);
		}
		System.out.println("The last list length "+list.size());
		return list;
	}

}
