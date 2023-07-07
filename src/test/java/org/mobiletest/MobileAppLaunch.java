package org.mobiletest;

import java.awt.AWTException;
import java.awt.Robot;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MobileAppLaunch  {
	
	public static void main(String[] args) throws MalformedURLException, AWTException {
		
		DesiredCapabilities options = new DesiredCapabilities();
		options.setCapability("deviceName", "50a6c4cc");
		options.setCapability("platformName", "Android");
		options.setCapability("platformVersion", "11");
		options.setCapability("appPackage", "com.omr_branch");
		options.setCapability("appActivity", "com.omr_branch.MainActivity");
		options.setCapability("automationName","UiAutomator2");
		
		WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
		
		WebElement txtEmail = driver.findElement(By.xpath("//*[@resource-id='login_email_input']"));
		txtEmail.sendKeys("aarthimeera72@gmail.com");
		WebElement txtPassword = driver.findElement(By.xpath("//*[@resource-id='login_password_input']"));
		txtPassword.sendKeys("Greens@123");
		WebElement btnLogin = driver.findElement(By.xpath("//*[@resource-id='login_button']"));
		btnLogin.click();
		
		WebElement txtWelcomeMsg = driver.findElement(By.xpath("//a[@data-testid='username']"));
		System.out.println(txtWelcomeMsg.getText());
		
		WebElement txtExploreHotelsMsg = driver.findElement(By.xpath("//h5[text()='Explore Hotels']"));
		System.out.println(txtExploreHotelsMsg.getText());
		
		WebElement dropState = driver.findElement(By.id("state"));
		Select s = new Select(dropState);
		s.selectByVisibleText("Kerala");
		
		WebElement dropCity = driver.findElement(By.id("city"));
		Select s1 = new Select(dropCity);
		s1.selectByVisibleText("Thiruvananthapuram");
		
		WebElement dropRoomType = driver.findElement(By.id("room_type"));
		Select s2 = new Select(dropRoomType);
		s2.selectByVisibleText("Deluxe");
		
		//checkIn
		driver.findElement(By.name("check_in")).click();
		//txtcheckInDate
		driver.findElement(By.xpath("//a[text()='11']")).click();
		
		//checkOut
		driver.findElement(By.name("check_out")).click();
		//txtcheckInDate
		driver.findElement(By.xpath("//a[text()='20']")).click();
				
		WebElement dropNoOfRooms = driver.findElement(By.id("no_rooms"));
		Select s3 = new Select(dropNoOfRooms);
		s3.selectByVisibleText("1-One");
		
		WebElement dropNoOfAdults = driver.findElement(By.id("no_adults"));
		Select s4 = new Select(dropNoOfAdults);
		s4.selectByVisibleText("1-One");
		
		//WebElement btnNoOfChild = driver.findElement(By.id("no_child"));
		//Robot r = new Robot();
		
		//search
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
		WebElement txtSelectHotels = driver.findElement(By.xpath("//h5[text()='Select Hotel']"));
		System.out.println(txtSelectHotels.getText());
	}	
}
