package Practices;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateContacts {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		WebElement salutationtype = driver.findElement(By.name("salutationtype"));
		Select s = new Select(salutationtype);
		s.selectByIndex(1);

		driver.findElement(By.name("firstname")).sendKeys("Aditya");
		driver.findElement(By.name("lastname")).sendKeys("Chopra");
		driver.findElement(By.id("title")).sendKeys("xyz");
		driver.findElement(By.id("department")).sendKeys("IT");
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");

		driver.findElement(By.id("phone")).sendKeys("1234567897");
		driver.findElement(By.id("mobile")).sendKeys("2244886611");
		driver.findElement(By.name("email")).sendKeys("abc@gmail.com");

		driver.findElement(By.name("button")).click();

		Thread.sleep(2000);
		WebElement mouseover = driver.findElement(By.xpath("//td[contains(@onmouseover,'ondemand_sub')]"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseover).perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		

		

	}

}
