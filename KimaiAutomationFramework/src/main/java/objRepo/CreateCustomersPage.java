package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCustomersPage {
	WebDriver driver;

	public CreateCustomersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='customer_edit_form_name']")
	private WebElement nametxt;

	@FindBy(xpath = "//button[@id='form_modal_save']")
	private WebElement savebtn;

	public WebElement getNametxt() {
		return nametxt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void createCustomer(String name) {
		
		nametxt.sendKeys(name);
		savebtn.click();
	}

}
