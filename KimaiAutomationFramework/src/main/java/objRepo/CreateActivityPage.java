
package objRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateActivityPage {

	WebDriver driver;

	public CreateActivityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='activity_edit_form_name']")
	private WebElement nametxt;

	@FindBy(xpath = "//input[@id='activity_edit_form_project-ts-control']")
	private WebElement projectdd;

	@FindBy(xpath = "//button[@id='form_modal_save']")
	private WebElement savebtn;

	public WebElement getNametxt() {
		return nametxt;
	}

	public WebElement getProjectdd() {
		return projectdd;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public void createActivity(String name, String value) throws Exception {
		
		nametxt.sendKeys(name);
		projectdd.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='" + value + "']")).click();
		savebtn.click();
	}

}
