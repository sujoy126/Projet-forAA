package com.crossbrowsing;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowseTest {
	WebDriver driver;
//	ChromeOptions ch = new ChromeOptions();
//	EdgeOptions ed = new EdgeOptions();
//	FirefoxOptions fx = new FirefoxOptions();
	
	@Parameters("browser")
	@BeforeTest
	public void crossBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			System.out.println("chrome browser launched");
		}
		
		 
		
		 else if(browser.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  driver= new FirefoxDriver();
		  System.out.println("firefox browser launched");
		  }
		
		 else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
				System.out.println("edge browser launched");
			}
		 
	}
	
	@Test
	public void browserest() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		String actualData = driver.getTitle();
		String expectedData = "Google";
		Assert.assertEquals(actualData.contains("Google"), expectedData.contains("Google"));
		System.out.println(" validation sucessfuI");
	}
	
	@AfterTest
	public void closeTest() {
		driver.close();
		
	}
	

	//@AfterTest
	public void d()
	{
		System.out.println(" validation sucess");

		
	}
}
