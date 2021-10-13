package com.mavenselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IndividualActivity {
	@Test
	//public static void main(String[] args) throws InterruptedException {
		public void logintest() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
			Thread.sleep(1000);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(3000);
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
			driver.findElement(By.id("react-burger-menu-btn")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("logout_sidebar_link")).click();
			Thread.sleep(1000);
			driver.quit();
				
	}

}

	
	
	
	
	
	
	