package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;
import com.qa.util.TestUtil;

public class DashBoardPage extends BasePage {

	@FindBy(xpath = "//img[@alt='OrangeHRM']")
	private WebElement logo;

	@FindBy(xpath = "//b[.='Recruitment']")
	private WebElement recruitmentTab;

	@FindBy(xpath = "//a[.='Candidates']")
	private WebElement candidatesTab;

	@FindBy(xpath = "//b[.='PIM']")
	private WebElement pimTab;

	@FindBy(xpath = "//a[.='Add Employee']")
	private WebElement addemployeeTab;

	@FindBy(xpath = "//a[.='Vacancies']")
	private WebElement vacancyTab;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String dashBoardTitle() {
		return driver.getTitle();
	}

	public boolean verifyLogo() {
		return logo.isDisplayed();
	}

	public CandidatesPage gotoCandidatesPage() {
		TestUtil.mouseHover(driver, recruitmentTab);
		candidatesTab.click();
		return new CandidatesPage(driver);
	}

	public EmployeePage gotoEmployeePage() {
		TestUtil.mouseHover(driver, pimTab);
		addemployeeTab.click();
		return new EmployeePage(driver);
	}

	public VacancyPage gotoVacancyPage() {
		TestUtil.mouseHover(driver, recruitmentTab);
		vacancyTab.click();
		return new VacancyPage(driver);

	}

}
