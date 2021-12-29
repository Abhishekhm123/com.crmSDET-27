package Practices;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustry {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys("Qspiders");
		driver.findElement(By.name("website")).sendKeys("Qspiders.com");
		driver.findElement(By.id("employees")).sendKeys("5000");
		driver.findElement(By.id("email2")).sendKeys("Qspiders@gmail.com");

		WebElement industry = driver.findElement(By.name("industry"));
		Select s = new Select(industry);
		s.selectByIndex(17);

		driver.findElement(By.id("phone")).sendKeys("2244668899");
		driver.findElement(By.id("fax")).sendKeys("080-224466");
		driver.findElement(By.id("otherphone")).sendKeys("080-245678");
		driver.findElement(By.id("email1")).sendKeys("xyz@gmail.com");
		driver.findElement(By.id("ownership")).sendKeys("abc");

		driver.findElement(By.name("button")).click();

		Thread.sleep(2000);
		WebElement mouseover = driver.findElement(By.xpath("//td[contains(@onmouseover,'ondemand_sub')]"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseover).perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
