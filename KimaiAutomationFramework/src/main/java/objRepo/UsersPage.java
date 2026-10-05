package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
	WebDriver driver;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Create' and contains(@class,'btn')]")
	private WebElement createbtn;

	@FindBy(xpath = "//input[@id='searchTerm']")
	private WebElement searchtxt;

	@FindBy(xpath = "//button[@data-toggle='tooltip']")
	private WebElement searchbtn;

	@FindBy(xpath = "//td[@class='alwaysVisible col_username' and contains(.,'Ajith')]")
	private WebElement user;

	@FindBy(xpath = "//button[contains(.,'Edit')]")
	private WebElement editlink;

	@FindBy(xpath = "//div[@data-popper-placement='bottom-start']//a[text()='Profile']")
	private WebElement profilelink;

	@FindBy(xpath = "//input[@id='user_edit_enabled']")
	private WebElement togglebtn;

	@FindBy(xpath = "//input[@value='Save']")
	private WebElement savebtn;

	public WebElement getCreatebtn() {
		return createbtn;
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getUser() {
		return user;
	}

	public WebElement getEditlink() {
		return editlink;
	}

	public WebElement getProfilelink() {
		return profilelink;
	}

	public WebElement getTogglebtn() {
		return togglebtn;
	}
    
	
	public WebElement getSavebtn() {
		return savebtn;
	}

	public void verifyUser() throws Exception {
		user.click();
		editlink.click();
		Thread.sleep(1000);
		profilelink.click();
		togglebtn.click();
		savebtn.click();
	}

}
