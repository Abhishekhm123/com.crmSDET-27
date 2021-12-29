package pomrepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;

	@FindBy(xpath = "//td[contains(@onmouseover,'ondemand_sub')]")
	private WebElement administratorimg;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getAdministratorimg() {
		return administratorimg;
	}

	public WebElement getSingoutlink() {
		return signoutlink;
	}

	public void logOut() {
		Actions act = new Actions(driver);
		act.moveToElement(administratorimg).perform();
		signoutlink.click();

	}

}
