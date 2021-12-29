package com.crm.genericutility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * its contains WebDriver specific reusable actions
 * 
 * @author Abhishek
 *
 */
public class WebDriverUtility {
	/**
	 * wait for page to load beforing identifying any synchronized element in DOM
	 * 
	 * @param driver
	 */
	public void waitForPageTLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * wait for page to load before identifyin and assychronized [java scripts
	 * actions]element in DOM[HTML-document]
	 * 
	 * @param driver
	 */
	public void waitForPageToLoadForJavaScriptElement(WebDriver driver) {

		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}

	/**
	 * used to wait for element to be clickble in GUI,& check For specific Element
	 * for every 500milli seconds
	 * 
	 * @driver
	 * @element
	 */

	public void waitForElementToBeClickAble(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * used to wait for element to be clickable in GUI & check for specific element
	 * for every 500 millin second s param driver param element param pollingTime in
	 * the form second
	 * 
	 * @throws Throwable
	 */
	public void waitForElemetWithCumTomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable {

		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * used to Switch To Any Window based on Window Title
	 * 
	 * @param Driver
	 * @parem partialWindow Title
	 */

	public void switchToWindow(WebDriver driver, String partialWindowTitle) {

		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {

			String wID = it.next();
			driver.switchTo().window(wID);
			String currentwindowTitle = driver.getTitle();
			if (currentwindowTitle.contains(partialWindowTitle)) {
				break;
			}

		}
	}

	/**
	 * used to switc to Alert Window and click on ok button param driver
	 */

	public void switchToAlertWindowAndAccpect(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * used to Switch to Alert Window And click on chancel button
	 * 
	 * @param Driver
	 */

	public void switchToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * used to Switch to Frame window based on index
	 * 
	 * @param driver parameter index
	 */

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	/**
	 * used to switch frame window based on id or name attribute
	 * 
	 * @param driver
	 * @param id_name_attribute
	 */

	public void switchToFrame(WebDriver driver, String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}

	/**
	 * used to select the value from the DropDown based on index
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * used to select the value from the DropDrown based on the value
	 * 
	 * @param element
	 * @param text
	 */

	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to place mouse cursor on specified element
	 * 
	 * @param driver
	 * @param element
	 */

	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * 
	 * @param driver
	 * @param javaScrpit
	 */

	public void executeJavaScript(WebDriver driver, String javaScrpit) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript(javaScrpit, null);

	}

	public void waitAndClick(WebElement element) throws InterruptedException

	{

		int count = 0;
		while (count < 20) {
			try {

				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(1000);
				count++;
			}

		}
	}

	public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/" + screenshotName + ".PNG");
		Files.copy(src, dest);
	}

	/**
	 * pass entery Key appertain in to Browser
	 * 
	 * @param driver
	 */
	public void passEnteryKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

}
