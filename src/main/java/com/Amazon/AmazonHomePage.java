package com.Amazon;

import java.time.Duration;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonHomePage {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		WebElement e = driver.findElement(By.id("twotabsearchtextbox"));
		e.sendKeys("electronis");
		List<WebElement> we = driver.findElements(By.xpath("//div[@class='left-pane-results-container']/div"));
		for(WebElement w: we) {
			String s = w.getText();
			System.out.println(s);
		}
		e.submit();
		
		System.out.println("----------------------------------------");
		  driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
		List<WebElement> l1 = driver.findElements(By.xpath("//div[@class='a-popover-inner']"));
		for(WebElement we2 : l1) {
			String s1 = we2.getText();
			System.out.println(s1);
		}
		driver.findElement(By.xpath("//a[text()='Price: High to Low']")).click();
		
		System.out.println("-----------------------------------");
		
		WebElement ee = driver.findElement(By.xpath("//span[starts-with(text(), 'Micron DDR4-3200 16GB')]/../../../following-sibling::div/div/div/div/div/div/a/span"));
		String ss = ee.getText();
		System.out.println(ss);
		
		
		
		
		
		
		  List<WebElement> payment = driver.findElements(By.tagName("a"));
		  String[] linkTexts = new String[payment.size()];
	//	  System.out.println(payment.size());
		  int i = 0;
		  for (WebElement es : payment) {
			  linkTexts[i] = es.getText();
		  System.out.println(linkTexts[i]); 
		  }
		 
		
		/*
		 * List<String> link = new LinkedList()<>(); for(WebElement web : webLink) {
		 * link.add(web.getAttribute("href")); }
		 * 
		 * Object[] prityFormat = link.toArray(); for(Object obj : prityFormat) {
		 * System.out.println(obj); }
		 */
		
		
		
		
		
		
		
		
	}
}
