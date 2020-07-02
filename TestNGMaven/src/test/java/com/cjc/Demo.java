package com.cjc;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo 
{
	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver","F:\\Testing\\Class\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        System.out.println("SuccessFully Open Browser");
        driver.manage().window().maximize();
        
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("F:\\Testing\\Class\\ScreenShot\\auo.jpeg"));
        System.out.println("Done");
	}

}
