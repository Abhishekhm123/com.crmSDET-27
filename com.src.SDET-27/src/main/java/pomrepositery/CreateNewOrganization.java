package pomrepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {

	public CreateNewOrganization(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getIckerSymbol() {
		return ickerSymbol;
	}

	public void setOrgNameEdit(WebElement orgNameEdit) {
		this.orgNameEdit = orgNameEdit;
	}

	public void setSaveBtn(WebElement saveBtn) {
		this.saveBtn = saveBtn;
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdit;

	@FindBy(name = "detailedViewTextBox")
	private WebElement ickerSymbol;

	@FindBy(name = "industry")
	private WebElement typeDropDown;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

}
