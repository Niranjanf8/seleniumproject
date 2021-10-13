package com.mavenselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumSample {
	@Test
	//public static void main(String[] args) throws InterruptedException {
		public void logintest() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/");
			Thread.sleep(3000);
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			Thread.sleep(1000);
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			Thread.sleep(1000);
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("welcome")).click();
			Thread.sleep(1000);
			driver.findElement(By.linkText("Logout")).click();
			Thread.sleep(3000);
			driver.quit();

	}

}
