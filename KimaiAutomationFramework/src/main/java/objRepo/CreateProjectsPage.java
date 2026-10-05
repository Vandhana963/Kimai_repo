package objRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProjectsPage {
	WebDriver driver;

	public CreateProjectsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='project_edit_form_name']")
	private WebElement nametxt;

	@FindBy(xpath = "//input[@id='project_edit_form_customer-ts-control']")
	private WebElement customerdd;

	@FindBy(xpath = "//button[@id='form_modal_save']")
	private WebElement savebtn;

	public WebElement getNametxt() {
		return nametxt;
	}

	public WebElement getCustomerdd() {
		return customerdd;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void createProject(String name, String value) throws Exception {
		
		nametxt.sendKeys(name);
		customerdd.click();
		Thread.sleep(2000);
		WebElement ele=driver.findElement(By.xpath("//div[text()='" + value + "']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).click().perform();
		savebtn.click();
	}
}
