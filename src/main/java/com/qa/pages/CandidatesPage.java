package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class CandidatesPage extends BasePage {

	@FindBy(xpath = "//input[@id='btnAdd']")
	private WebElement addBtn;

	@FindBy(id = "addCandidate_firstName")
	private WebElement firstName;

	@FindBy(id = "addCandidate_middleName")
	private WebElement midName;

	@FindBy(id = "addCandidate_lastName")
	private WebElement lastName;

	@FindBy(id = "addCandidate_email")
	private WebElement email;

	@FindBy(className = "contactNo")
	private WebElement contact;

	@FindBy(id = "btnSave")
	private WebElement saveBTn;

	public CandidatesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addCandidate(String fName, String mName, String lName, String emailId, String cNo) {
		addBtn.click();
		firstName.sendKeys(fName);
		midName.sendKeys(mName);
		lastName.sendKeys(lName);
		email.sendKeys(emailId);
		contact.sendKeys(cNo);
		saveBTn.click();

	}
}
