package org.mobiletest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Table.Cell;

import net.bytebuddy.asm.Advice.This;

public class BaseClass {

		public static WebDriver driver;

		public void getDriver(String browser) {

			switch (browser) {
			case "chrome":
				
				driver = new ChromeDriver();
				break;
			case "Firefox":
				driver = new FirefoxDriver();
				break;
			case "Edge":
				driver = new EdgeDriver();
				break;
			default:
				break;
			}

			//driver.manage().deleteAllCookies();

		}

		// window maximize
		public void maximizeWindow() {
			driver.manage().window().maximize();
		}

		// To click the button using javascript
		public static void elementClickButtonByJs(WebElement element) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", element);
		}

		

		public static String getProjectPath() {
			String path = System.getProperty("user.dir");
			return path;
		}

		public static String getPropertyFileValue(String Key) throws FileNotFoundException, IOException {
			Properties properties = new Properties();
			properties.load(new FileInputStream(getProjectPath() + "//Config//Config.properties"));
			Object obj = properties.get(Key);
			String value = (String) obj;
			System.out.println(value);
			return value;

		}

		public static void enterAppUrl(String Url) {
			driver.get(Url);
		}

		// sendKeys

		public static void elementsendKeys(WebElement element, String data) {
			element.sendKeys(data);
		}
		
		// click
		public static void elementClick(WebElement element) {

			element.click();
		}
		public static void sendEnterKey(WebElement element) {
			
			element.sendKeys(Keys.ENTER);
		}

		// to locate the WebElement
		WebElement findElement;

		public WebElement locator(String locatorName, String value) {
			switch (locatorName) {

			case "id":
				findElement = driver.findElement(By.id(value));
				break;

			case "name":
				findElement = driver.findElement(By.name(value));
				break;

			case "xpath":
				findElement = driver.findElement(By.xpath(value));
				break;
			}

			return findElement;
		}

		// to get the multiple elements as text

		public List<String> elementsGetText(List<WebElement> element) {

			List<String> a = new LinkedList<String>();

			for (int i = 0; i < element.size(); i++) {
				WebElement l = element.get(i);
				String text = l.getText();
				a.add(text);

			}
			return a;
		}

		
		// navigation
		// launchUrl
		public void navigatetoUrl(String url) {
			driver.navigate().to(url);
		}

		// oneUrlToAnother
		public void oneUrlToanother(String Url) {
			driver.navigate().to(Url);
		}

		// forwardUrl
		public void forwardUrl() {
			driver.navigate().forward();
		}

		// backUrl
		public void backUrl() {
			driver.navigate().back();
		}

		// refresh
		public void refresh() {
			driver.navigate().refresh();
		}

		// scrollUpandDown-JavascriptExecutor
		// using pixel

		public void scroll(String scroll, int a) {

			JavascriptExecutor j = (JavascriptExecutor) driver;
			switch (scroll) {
			case "Down":

				j.executeScript("window.scrollBy(0,a)");
				break;

			case "Up":
				j.executeScript("window.scrollBy(0,-a)");
				break;
			}
		}

		// getTitle
		public String title() {
			String title = driver.getTitle();
			System.out.println(title);

			return title;
		}

		// getCurrentUrl
		public String currentUrl() {
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);

			return currentUrl;
		}

		// closeBrowser
		public void closeBrowser() {
			driver.close();
		}

		// closewindow
		public void quitWindow() {
			driver.quit();
		}
		//elementGetText
		public String elementGetText(WebElement element) {
			String text = element.getText();
			return text;
		}
		//elementGetAttribute
		public String elementGetAttribute(WebElement element,String attributeName) {
			String attribute = element.getAttribute(attributeName);
			return attribute;
		}
		
		// DropDown
		// Select by index
		public void selectByIndex(WebElement element, int index) {
			Select s = new Select(element);
			s.selectByIndex(index);
		}

		// select By Attribute value
		public void selectByValue(WebElement element, String value) {
		
			Select s = new Select(element);
			s.selectByValue(value);
		}

		// select by Visible text
		public void selectByVisibleText(WebElement element, String value) {
			Select s = new Select(element);
			s.selectByVisibleText(value);
		}

		// isMultiple
		public boolean isMultiple(WebElement element) {
			Select s = new Select(element);
			boolean multiple = s.isMultiple();
			System.out.println(multiple);

			return multiple;
		}

		// getOptions
		public void getOptions(WebElement element) {
			Select s = new Select(element);
			List<WebElement> options = s.getOptions();
			for (WebElement a : options) {
				String text = a.getText();
				System.out.println(text);
			}
		}

		// get all selected Options
		public void getAllSelectedOptions(WebElement element) {
			Select s = new Select(element);
			List<WebElement> aso = s.getAllSelectedOptions();
			for (WebElement a : aso) {
				String text = a.getText();
				System.out.println(text);
			}
		}

		// get First Selected Option
		public void getFirstSelectedOption(WebElement element) {
			Select s = new Select(element);
			WebElement fso = s.getFirstSelectedOption();
			String text = fso.getText();
			System.out.println(text);
		}

		// to pass text in Webpage- JavascriptExecutor

		public void jsText(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute(a,b)", element);
		}

		// TakesScreenshot

		public void screenshot(String value) throws IOException {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			File f = new File(value);
			FileUtils.copyFile(screenshotAs, f);
		}

		// screen shot
		public byte[] screenshot() {

			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] b = ts.getScreenshotAs(OutputType.BYTES);
			return b;
		}

		// getAttribute

		public void attribute(WebElement element, String value, String a) {

			String attribute = element.getAttribute("value");
			System.out.println(attribute);
		}

		// Waits
		// Static wait
		public void staticWait(int milliseconds) throws InterruptedException {
			Thread.sleep(milliseconds);
		}

		// Implicit Wait
		public void implicitWait() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

		// Frames
		// switch to a frame by using Index
		public void indexFrame(int value) {
			driver.switchTo().frame(value);
		}

		// switch to a frame by using id (or) name
		public void idOrNameFrame(WebElement webElement) {
			driver.switchTo().frame(webElement);
		}

		// switch to a frame by using WebElement ref
		public void webElementRefFrame(WebElement element, String locator, String value) {
			driver.switchTo().frame(element);
			WebElement findelement = driver.findElement(By.xpath(locator));
			findelement.sendKeys(value);
		}

		// Nested Frame
		// switch from child frame to parent frame
		public void parentFrame() {
			driver.switchTo().parentFrame();
		}

		// switch from child frame to webpage
		public void webpageFrame() {
			driver.switchTo().defaultContent();
		}

		// Alert
		// switching the alert
		public void clickOkAlert() {
			driver.switchTo().alert().accept();
		}
		

		// dismissAlert
		
		/**
		 * @author Hemalatha
		 * @since 14-05-2023
		 * @see This method is used to cancel the alert
		 */
		public void clickCancelAlert() {
			driver.switchTo().alert().dismiss();
		}
		

		// sendKeys
		
		// Windows Handling
		// To return parent window id
		public String windowHandle() {
			String parentId = driver.getWindowHandle();
			return parentId;
		}

		// To return all windows id
		public Set<String> windowHandles() {
			Set<String> allIds = driver.getWindowHandles();
			return allIds;
		}

		// To switch to windows
		public void switchWindow(Set<String> allIds, String parentId) {
			for (String s : allIds) {
				if (!parentId.equals(s)) {
					driver.switchTo().window(s);
				}
			}
		}

		// KeyBoard Actions using Robot class
		// Robot
		// keyPress Keyrelease multiple times
		public void robotDownMultiple(int n) throws AWTException {
			Robot r = new Robot();
			for (int i = 1; i < n; i++) {
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}

		// Robot CONTROL V
		public void robotControlV() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
		}

		// Robot CONTROL A
		public void robotControlA() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_A);
		}

		// Robot Alphabets
		public void robotAlphabets() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);
		}

		// Robot Numerals
		public void robotNumerals() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_1);
			r.keyRelease(KeyEvent.VK_1);
		}

		// Robot ENTER
		public void enterKey() throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}

		// Robot TAB
		public void robotTab(int n) throws AWTException {
			Robot r = new Robot();
			for (int i = 1; i < n; i++)
				r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}

		// KeyBoard Actions using Actions class
		// Control A
		public void actionsControlA() {
			Actions a = new Actions(driver);
			a.keyDown(Keys.CONTROL).perform();
			a.sendKeys("a").perform();
			a.keyUp(Keys.CONTROL).perform();
		}

		// Control X Actions class
		public void actionsControlX() {
			Actions a = new Actions(driver);
			a.keyDown(Keys.CONTROL).perform();
			a.sendKeys("x").perform();
			a.keyUp(Keys.CONTROL).perform();
		}

		// TAB- Actions class
		public void actionsTab() {
			Actions a = new Actions(driver);
			a.sendKeys(Keys.TAB).perform();

		}

		// ScrollDown using Actions class
		public void actionsScrollDown() {
			Actions a = new Actions(driver);
			a.sendKeys(Keys.PAGE_DOWN).perform();

		}

		// ScrollUp using Actions class
		public void actionsScrollUp() {
			Actions a = new Actions(driver);
			a.sendKeys(Keys.PAGE_UP).perform();

		}

		// Enter using Actions class
		public void actionsEnter() {
			Actions a = new Actions(driver);
			a.sendKeys(Keys.ENTER).perform();

		}

		// Shift using Actions Class
		public void actionsShift() {
			Actions a = new Actions(driver);
			a.sendKeys(Keys.SHIFT).perform();

		}

		// excel read
		//public String readExcel(String location, String sheet, int a, int b) throws IOException {
			//File f = new File(location);
			//FileInputStream file = new FileInputStream(f);
			//Workbook w = new XSSFWorkbook(file);
			//Sheet sheet1 = w.getSheet(sheet);

			//Row row = sheet1.getRow(a);
			//Cell cell = row.getCell(b);
			//String scv = cell.getStringCellValue();

			//return scv;
		//}

	}

