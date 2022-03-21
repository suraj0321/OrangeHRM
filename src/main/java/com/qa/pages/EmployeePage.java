package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class EmployeePage extends BasePage {

	/*
	 * @FindBy(xpath="//a[@id='menu_pim_viewPimModule']") private WebElement PIM;
	 * 
	 * @FindBy(xpath="//a[text()='Employee List']") private WebElement Employeelist;
	 */
		@FindBy(id="firstName")
		private WebElement firstname;
		
		@FindBy(xpath="//input[@id='middleName']")
		private WebElement middlename;
		
		@FindBy(xpath="//input[@id='lastName']")
		private WebElement lastname;
		
		@FindBy(xpath="//input[@id='btnSave']")
		private WebElement save;
		
		public EmployeePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
}
 
		public void addEmployee(String fname, String mname, String lname ) {
			firstname.sendKeys(fname);
			middlename.sendKeys(mname);
			lastname.sendKeys(lname);
			save.click();
		}
		
		
	}

