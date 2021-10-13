package com.mavenselenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GroupActivity {
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
	 
	@Test
	public void login() throws InterruptedException{
		driver.get("https://www.lambdatest.com/");   
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		//linkText locator
		driver.findElement(By.linkText("Login")).click();
		//className locator
		Boolean titleDisplayed=driver.findElement(By.className("form_title")).isDisplayed();
		if(titleDisplayed)
		{
		System.out.println("Welcome Back ! is displayed ");
		}
		else
		{
			System.out.println("Welcome Back ! is not displayed");
		}
		//partialLinkText locator
		driver.findElement(By.partialLinkText("up")).click();
		//name locator
	    driver.findElement(By.name("name")).sendKeys("AquaTeam");
	    Thread.sleep(1000);
	    //cssSelector locator
	    driver.findElement(By.cssSelector("#signup-form > div:nth-child(3) > input")).sendKeys("AquaTeam001@gmail.com");
	    Thread.sleep(1000);
	   //id locator
	    driver.findElement(By.id("userpassword")).sendKeys("Aqua007");
	    Thread.sleep(1000);
	    //xpath locator
	    driver.findElement(By.xpath("//input[@type='phone']")).sendKeys("+1 888 888 8888");
	    Thread.sleep(1000);
	   //tagName locator
	    List<WebElement> droplist=driver.findElements(By.tagName("option"));
	    for(WebElement s:droplist)
	    {
	    
	    if(s.getText().equalsIgnoreCase("Developer / Tester"))
	    {
	    	s.click();
	  
	    }
	    else if(s.getText().equalsIgnoreCase("5001-10000"))
	    {
	    	s.click();
	    	break;
	    }
	    }
	    //tagName locator
	    
	    Boolean checboxEnabled=driver.findElement(By.tagName("samp")).isEnabled();
	    Boolean checkboxSelected=driver.findElement(By.tagName("samp")).isSelected();
	    if(checboxEnabled&&!checkboxSelected)
	    {
	    driver.findElement(By.tagName("samp")).click();
	    }
	    else
	    {
	    System.out.println("Checkbox is not enabled or already selected");
	    }


		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}

