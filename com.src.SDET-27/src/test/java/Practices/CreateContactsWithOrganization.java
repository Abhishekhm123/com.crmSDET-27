package Practices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactsWithOrganization {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Naveen12");
		driver.findElement(By.name("lastname")).sendKeys("Chavan22");

		driver.findElement(By.xpath("//img[contains(@onclick,'return window')]")).click();
		String parentwindow = driver.getWindowHandle();

		Set<String> wid = driver.getWindowHandles();
		List<String> allwin = new ArrayList<String>(wid);
		String win1 = allwin.get(1);
		driver.switchTo().window(win1);

		driver.findElement(By.linkText("Test Yantra")).click();

		driver.switchTo().window(parentwindow);

		driver.findElement(By.name("button")).click();

		Thread.sleep(2000);
		WebElement mouseover = driver.findElement(By.xpath("//td[contains(@onmouseover,'ondemand_sub')]"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseover).perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


	}

}
