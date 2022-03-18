package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;

	public WebDriver init_driver(String browserName) {
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	public Properties init_properties() {
		prop=new Properties();
		
		try {
			FileInputStream ip=new FileInputStream("D:\\work\\OrangeHRM\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
		public String getScreenshot() {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
			File destination=new File(path);
			try {
			FileUtils.copyFile(src, destination);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return path;
		}
	}

