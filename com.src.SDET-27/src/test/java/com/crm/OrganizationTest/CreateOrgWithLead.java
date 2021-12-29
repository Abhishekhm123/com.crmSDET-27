package com.crm.OrganizationTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrgWithLead {

	public static void main(String[] args) throws Throwable {
		Random ran=new Random();
		int ranDomNum = ran.nextInt(100);
		
		FileInputStream fis = new FileInputStream("./data/common.properties.txt");
		Properties pobj=new Properties();
		pobj.load(fis);
		
		String Browser=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		
		FileInputStream efis=new FileInputStream("./data/test.xlsx.xlsx");
		Workbook wb=WorkbookFactory.create(efis);
		Sheet sh = wb.getSheet("sheet2");
		Row row = sh.getRow(1);
		String Lname = row.getCell(0).getStringCellValue()+ranDomNum;
		String Dpt=row.getCell(1).getStringCellValue();
		String Email=row.getCell(2).getStringCellValue();
		String Mobile=row.getCell(3).getStringCellValue();
		
		Sheet sh1 = wb.getSheet("sheet1");
		Row row1 = sh1.getRow(1);
		String orgname = row1.getCell(2).getStringCellValue()+ranDomNum;
		
		
		wb.close();
		
		WebDriver driver=null;
		if(Browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}else if(Browser.equals("FireFox"))
				{
			driver=new FirefoxDriver();
				}
		else
		{
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.name("button")).click();
		
		WebElement headerwb = driver.findElement(By.className("dvHeaderText"));
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(headerwb));
		
		
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(Lname);
		driver.findElement(By.name("lastname")).sendKeys(Lname);
		driver.findElement(By.id("department")).sendKeys(Dpt);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("mobile")).sendKeys(Mobile);
		String parentwind = driver.getWindowHandle();
		driver.findElement(By.xpath("//img[contains(@onclick,'return window')]")).click();
		
		Set<String> wid = driver.getWindowHandles();
		for(String win:wid)
		{
			if(!win.equals(parentwind))
				driver.switchTo().window(win);
		}
		
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		
        driver.switchTo().window(parentwind);
		
		WebElement Leadsource = driver.findElement(By.name("leadsource"));
		Select s=new Select(Leadsource);
		s.selectByIndex(5);
		
		driver.findElement(By.name("emailoptout")).click();

		driver.findElement(By.name("button")).click();

		Thread.sleep(2000);
		WebElement mouseover = driver.findElement(By.xpath("//td[contains(@onmouseover,'ondemand_sub')]"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseover).perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


	}

}
