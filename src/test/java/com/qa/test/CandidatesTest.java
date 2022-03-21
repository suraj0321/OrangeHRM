package com.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.CandidatesPage;
import com.qa.pages.DashBoardPage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class CandidatesTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public DashBoardPage dashBoard;
	public CandidatesPage candidatesPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		dashBoard=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		candidatesPage=dashBoard.gotoCandidatesPage();
	}
	@DataProvider(name="getCandidatesData")
	public Object[][] getCandidatesTestData(){
		Object candidatesData[][]=TestUtil.getTestData("candidates");
		return candidatesData;
		
	}
	@Test(dataProvider = "getCandidatesData")
	public void createCandidatesTest(String firstName,String middleName,String lastName,String emailId,String contactNo) {
		candidatesPage.addCandidate(firstName, middleName, lastName, emailId, contactNo);
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
