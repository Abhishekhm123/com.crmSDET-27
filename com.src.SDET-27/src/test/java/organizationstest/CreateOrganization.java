package organizationstest;

import java.io.FileInputStream;
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

public class CreateOrganization {

	
		
		public static void main(String[] args) throws Throwable
		{
		Random ran=new Random();
		int ranDomNum=ran.nextInt(1000);
		
		FileInputStream fis=new FileInputStream("./data/common.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");

		
		FileInputStream efis=new FileInputStream("./data/excel.xlsx");
		Workbook wb=WorkbookFactory.create(efis);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(1);
		String orgname = row.getCell(2).getStringCellValue()+ranDomNum;
		wb.close();
		
		
		WebDriver driver=null;
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equals("FireFox"))
				{
			driver=new FirefoxDriver();
				}
		else
		{
			driver=new ChromeDriver();
		}
		
		
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.name("button")).click();
		
		
		String actorgName=driver.findElement(By.className("dvHeaderText")).getText();
		if(actorgName.contains(orgname))
		{
			System.out.println(orgname+"org is created==PASS");
		}else
		{
			System.out.println(orgname+"org is not created==FAIL");
		}
		
		
		Thread.sleep(2000);
		WebElement mouseover = driver.findElement(By.xpath( "//td[contains(@onmouseover,'ondemand_sub')]"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseover).perform();

	 	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    driver.quit();

		

	}

}
