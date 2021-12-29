package com.crm.OrganizationTest;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
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

public class CreateOrgNameWithText {

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
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(Lname);
		driver.findElement(By.id("department")).sendKeys(Dpt);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("mobile")).sendKeys(Mobile);
		 
		WebElement wdt = driver.findElement(By.id("jscal_field_support_end_date"));
		wdt.clear();
		
		Date dobj=new Date();
		int date=dobj.getDate();
		int month=dobj.getMonth()+1;
		String year=dobj.toString().split(" ")[5];
		
		String formate = year +"-"+ month + "-"+ date;
		wdt.sendKeys(formate);
		
		driver.findElement(By.name("button")).click();
		
		String name = driver.findElement(By.className("dvHeaderText")).getText();
		if(name.contains(Lname))
		{
			System.out.println(Lname+"org is created=PASS");
		}else
		{
			System.out.println(Lname+"org is  not created=FAIL");
		}
		
		Thread.sleep(2000);
		WebElement mouseover = driver.findElement(By.xpath("//td[contains(@onmouseover,'ondemand_sub')]"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseover).perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();



	}

}
