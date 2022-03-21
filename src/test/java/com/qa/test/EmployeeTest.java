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
import com.qa.pages.EmployeePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class EmployeeTest {
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public DashBoardPage dashBoard;
	public EmployeePage employeePage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		dashBoard=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		employeePage=dashBoard.gotoEmployeePage();
		
		
	}
	@DataProvider(name="getEmployeedata")
	public Object[][] getCandidatesTestData(){
		Object employeedata[][]=TestUtil.getTestData("Employee");
		return employeedata;
	}
	@Test(dataProvider="getEmployeedata")
	
	public void createEmployeeTest(String FirstName,String MiddleName,String LastName) {
		employeePage.addEmployee(FirstName, MiddleName, LastName);
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	
		
	}
	
}
