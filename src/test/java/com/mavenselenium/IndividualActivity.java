package com.mavenselenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IndividualActivity {
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
	if(browser.equalsIgnoreCase("firefox")){
		WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	}
	 
	else if (browser.equalsIgnoreCase("chrome")){
		WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	 
	}

	else{
	//If no browser passed throw exception
	throw new Exception("Browser is not correct");
	}
	}
	 
	@BeforeMethod
		public void logintest() throws InterruptedException {
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
			Thread.sleep(1000);
			driver.findElement(By.id("login-button")).click();
			
	}
	@Test
		public void Scenariotest() throws InterruptedException {
			
			boolean eleSelected= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")).isDisplayed();
			if (eleSelected) System.out.println("Text displayed succesfully");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("shopping_cart_container")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("checkout")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("firstName")).sendKeys("sainiranjan");
			Thread.sleep(1000);
			driver.findElement(By.name("lastName")).sendKeys("Boora");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("507003");
			Thread.sleep(1000);
			WebElement el=driver.findElement(By.id("continue"));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", el);
			driver.findElement(By.name("continue")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("finish")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
			Thread.sleep(1000);
	}
	
	@AfterMethod
		public void logouttest() throws InterruptedException {
			driver.findElement(By.id("react-burger-menu-btn")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("logout_sidebar_link")).click();
			}
			
	@AfterTest
		public void tearDown()
			{
				driver.quit();				
	}

}

	
	
	
	
	
	
	