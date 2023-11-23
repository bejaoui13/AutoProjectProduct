package com.tutorial.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

	public SearchPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='caption']/h4") 	WebElement nameproduct;
	@FindBy(xpath = "//*[@id='content']/h2") 	WebElement invalideproduct;

	public String valideProduct() {
		String nameprodutVal = nameproduct.getText();
		return nameprodutVal;
	}

	public String invalideProduct() {
		String nameprodutInv = invalideproduct.getText();
		return nameprodutInv;
	}
}
