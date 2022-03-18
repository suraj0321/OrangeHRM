package com.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.DashBoardPage;
import com.qa.pages.LoginPage;

public class DashBoardTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public DashBoardPage dashBoard;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		dashBoard=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority = 1)
	public void verifyDashboardTitleTest() {
		String title = dashBoard.dashBoardTitle();
		System.out.println(title);
		Assert.assertEquals(title,"OrangeHRM");
	}
	@Test(priority = 2)
	public void verifyLogoTest() {
		Assert.assertTrue(dashBoard.verifyLogo());
	}
	@AfterTest
	public void  tearDown() {
		driver.quit();
	}
}
