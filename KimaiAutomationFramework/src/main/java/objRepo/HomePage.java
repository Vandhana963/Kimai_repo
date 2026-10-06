package objRepo;

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

	@FindBy(xpath = "//span[text()='Administration']")
	private WebElement administrationlink;

	@FindBy(xpath = "//span[text()='Time Tracking']")
	private WebElement timetrackinglink;

	@FindBy(xpath = "//a[contains(.,'Customers')]")
	private WebElement customerlink;

	@FindBy(xpath = "//a[contains(.,'Projects')]")
	private WebElement projectlink;

	@FindBy(xpath = "//a[contains(.,'Activities')]")
	private WebElement activitieslink;

	@FindBy(xpath = "//i[@class='fas fa-user-clock']")
	private WebElement alltimeslink;

	@FindBy(xpath = "//i[@class='fas fa-download']")
	private WebElement exportlink;

	@FindBy(xpath = "(//div[@class='navbar-nav flex-row d-lg-none']/following::a[@aria-label='Open personal menu' and @class='nav-link d-flex lh-1 p-0 px-2']")
	private WebElement myprofilelink;

	@FindBy(xpath = "//a[text()='Log out']")
	private WebElement logoutlink;

	@FindBy(xpath = "//span[text()='System']")
	private WebElement systemlink;

	@FindBy(xpath = "//a[contains(.,'Users')]")
	private WebElement userlink;

	@FindBy(xpath = "//a[contains(.,'Roles')]")
	private WebElement roleslink;

	public WebElement getAdministrationlink() {
		return administrationlink;
	}

	public WebElement getTimetrackinglink() {
		return timetrackinglink;
	}

	public WebElement getCustomerlink() {
		return customerlink;
	}

	public WebElement getProjectlink() {
		return projectlink;
	}

	public WebElement getActivitieslink() {
		return activitieslink;
	}

	public WebElement getAlltimeslink() {
		return alltimeslink;
	}

	public WebElement getExportlink() {
		return exportlink;
	}

	public WebElement getMyprofilelink() {
		return myprofilelink;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}

	public WebElement getSystemlink() {
		return systemlink;
	}

	public WebElement getUserlink() {
		return userlink;
	}

	public WebElement getRoleslink() {
		return roleslink;
	}

	public void logout() throws Exception {
//		Actions a = new Actions(driver);
//		a.moveToElement(myprofilelink).click().build().perform();
		myprofilelink.click();
		Actions a1 = new Actions(driver);
		a1.moveToElement(logoutlink).click().perform();

	}

}
