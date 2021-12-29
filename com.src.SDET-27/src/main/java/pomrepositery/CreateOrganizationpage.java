package pomrepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutility.WebDriverUtility;

public class CreateOrganizationpage extends WebDriverUtility {

	public CreateOrganizationpage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "accountname")
	private WebElement OragnizationNameEdit;

	@FindBy(xpath = "//a[@href='index.php?module=Potentials&action=index']")
	private WebElement createorganization;

	@FindBy(name = "firstname")
	private WebElement firstName;

	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(id = "title")
	private WebElement title;

	public WebElement getOragnizationNameEdit() {
		return OragnizationNameEdit;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getCreateorganization() {
		return createorganization;
	}
}