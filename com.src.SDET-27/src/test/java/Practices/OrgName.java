package Practices;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrgName {

	public static void main(String[] args) throws IOException  {

		FileInputStream fis = new FileInputStream("./data/common.properties");
		Properties pobj = new Properties();
		pobj.load(fis);

		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");

		FileInputStream efis = new FileInputStream("./data/excel.xlsx");
		Workbook wb = WorkbookFactory.create(efis);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		String randumnum = null;
		String OrgName = row.getCell(1).getStringCellValue() + randumnum;
		wb.close();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		

	}

}
