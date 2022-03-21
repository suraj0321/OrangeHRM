package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;
import com.qa.util.TestUtil;

public class VacancyPage extends BasePage{
	@FindBy(id="btnAdd")
	private WebElement addBtn;
	
	@FindBy(xpath="//select[@id='addJobVacancy_jobTitle']")
	private WebElement jobTitle;
	
	@FindBy(xpath="//input[@id='addJobVacancy_name']")
	private WebElement vaccancyName;
	
	@FindBy(xpath="//input[@autocomplete='off']")
	private WebElement hiringmgr;
	
	public VacancyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void addVacancy(String job,String vacancy,String manager) {
		addBtn.click();
		TestUtil.listBoxSelect(jobTitle, job);
		jobTitle.sendKeys(job);
		vaccancyName.sendKeys(vacancy);
		hiringmgr.sendKeys(manager);
	}
	

}
