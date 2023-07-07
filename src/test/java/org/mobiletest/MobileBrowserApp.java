package org.mobiletest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class MobileBrowserApp {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities options = new DesiredCapabilities();
		options.setCapability("deviceName", "50a6c4cc");
		options.setCapability("platformName", "Android");
		options.setCapability("automationName","UiAutomator2");
		options.setCapability("capabilityType.BROWSER_NAME", "chrome");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
		WebElement txtEmail = driver.findElement(By.xpath("//*[@resource-id='login_email_input']"));
		txtEmail.sendKeys("aarthimeera72@gmail.com");

		WebElement txtPassword = driver.findElement(By.xpath("//*[@resource-id='login_password_input']"));
		txtPassword.sendKeys("Greens@123");
		
		WebElement btnLogin = driver.findElement(By.xpath("//*[@resource-id='login_button']"));
		btnLogin.click();
	}
}
