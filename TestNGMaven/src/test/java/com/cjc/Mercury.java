package com.cjc;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Mercury {
	public WebDriver driver;
	@BeforeSuite
	public void OpenBrowser()
	{
		System.out.println("Under Before Suit");
		System.setProperty("webdriver.chrome.driver", "F:\\Testing\\Class\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("SuccessFully Open Browser");
	}
	//@Parameters({"url"})
	@BeforeTest
	public void EnteUrl()
	{
		System.out.println("Before Test");
		driver.get("http://newtours.demoaut.com/");
	}
	@BeforeClass
	public void maximizewindow()
	{
		System.out.println("Before Class");
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getCookies()
	{
		System.out.println("Before Method");
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie : cookies) 
		{
		System.out.println(cookie.getName());	
		}
		driver.get("http://newtours.demoaut.com/");
	}
	
	  @Test(priority=0)
	  public void loginwithvaliduser() 
	  {
		  System.out.println("Login with valid user test annotation");
		    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("rukeshingole");
		    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("9960130505");
			driver.findElement(By.xpath("//input[@name='login']")).click();
			
			System.out.println("Successful Login");
	  }
	  @Test(priority=2)
	  public void loginwithvaliduser1() 
	  {
		  System.out.println("Login with valid user test annotation");
		    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("mayuringole");
		    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("9960130505");
			driver.findElement(By.xpath("//input[@name='login']")).click();
			
			System.out.println("Successful Login");
	  }
	  @Test(priority=1)
	  public void loginwithvaliduser2() 
	  {
		  System.out.println("Login with valid user test annotation");
		    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("QQQQQ");
		    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qqqqq");
			driver.findElement(By.xpath("//input[@name='login']")).click();
			
			System.out.println("Successful Login");
	  }
	@AfterMethod
	  public void CaptureScreen() throws IOException
	  {
		  System.out.println("Under After Method");
		  System.out.println("successfuly ScreenShot");
		   }
	  @AfterClass
	  public void DeleteCookies()
	  {
		  System.out.println("After Class");
		  driver.manage().deleteAllCookies();
	  }
	  @AfterTest
	  public void dbconnection()
	  {
		  System.out.println("After Test");
	  }
	  @AfterSuite
	  public void closebrowser()
	  {
		  System.out.println("After Suite");
		  driver.close();
	  }
}
