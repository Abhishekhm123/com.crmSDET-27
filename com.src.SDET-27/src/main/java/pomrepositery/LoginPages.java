package pomrepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {

	WebDriver driver;
	public LoginPages(WebDriver webDriver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	public WebDriver getDriver() {
		return driver;
	}


	@FindBy(id="submitButton")
	private WebElement loginButton;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginToApp(String userName,String passWord)
	{
		username.sendKeys(userName);
		password.sendKeys(passWord);
		loginButton.click();

	}
}
