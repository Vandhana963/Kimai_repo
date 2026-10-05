package objRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAllTimesPage {
	WebDriver driver;

	public CreateAllTimesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='timesheet_admin_edit_form_duration']")
	private WebElement durationtxt;

	@FindBy(xpath = "//input[@id='timesheet_admin_edit_form_customer-ts-control']")
	private WebElement customerdd;
	@FindBy(xpath = "//input[@id='timesheet_admin_edit_form_project-ts-control']")
	private WebElement projectdd;
	@FindBy(xpath = "//input[@id='timesheet_admin_edit_form_activity-ts-control']")
	private WebElement activitydd;
	@FindBy(xpath = "//input[@id='timesheet_admin_edit_form_user-ts-control']")
	private WebElement userdd;
	@FindBy(xpath = "//button[@class='btn  dropdown-toggle' and contains(.,'Export')]")
	private WebElement expertbtn;
	@FindBy(xpath = "//a[@class='dropdown-item action-xlsx toolbar-action']")
	private WebElement excellink;

	@FindBy(xpath = "//button[@id='form_modal_save']")
	private WebElement savebtn;

	public WebElement getDurationtxt() {
		return durationtxt;
	}

	public WebElement getCustomerdd() {
		return customerdd;
	}

	public WebElement getProjectdd() {
		return projectdd;
	}

	public WebElement getActivitydd() {
		return activitydd;
	}

	public WebElement getUserdd() {
		return userdd;
	}

	public WebElement getExpertbtn() {
		return expertbtn;
	}

	public WebElement getExcellink() {
		return excellink;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void createAllTimes(String time, String pvalue, String avalue) throws Exception {

		durationtxt.sendKeys(time);
		projectdd.click();
		WebElement ele = driver.findElement(By.xpath("//div[text()='" + pvalue + "']"));
		Actions a = new Actions(driver);
		a.moveToElement(ele).click().perform();
		Thread.sleep(1000);
		activitydd.click();
		WebElement ele2 = driver.findElement(By.xpath("//div[text()='" + avalue + "']"));
		Actions a1 = new Actions(driver);
		a1.moveToElement(ele2).click().perform();
		savebtn.click();
		Thread.sleep(4000);
		HomePage hp = new HomePage(driver);
		hp.getAlltimeslink().click();
		Thread.sleep(1000);
		Actions a2 = new Actions(driver);
		a2.moveToElement(expertbtn).click().moveToElement(excellink).click().perform();
	}

	public void createAllTimes(String time, String cvalue, String pvalue, String avalue) throws Exception {
		durationtxt.sendKeys(time);
		customerdd.click();
		WebElement e = driver.findElement(By.xpath("//div[text()='" + cvalue + "']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(e).click().perform();
		Thread.sleep(1000);
		projectdd.click();
		WebElement ele = driver.findElement(By.xpath("//div[text()='" + pvalue + "']"));
		Actions a = new Actions(driver);
		a.moveToElement(ele).click().perform();
		Thread.sleep(1000);
		activitydd.click();
		WebElement ele2 = driver.findElement(By.xpath("//div[text()='" + avalue + "']"));
		Actions a1 = new Actions(driver);
		a1.moveToElement(ele2).click().perform();
		savebtn.click();

		Actions a2 = new Actions(driver);
		a2.moveToElement(expertbtn).pause(1).moveToElement(excellink).click().perform();
	}

}
