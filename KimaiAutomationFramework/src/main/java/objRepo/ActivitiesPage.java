package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivitiesPage {

	WebDriver driver;

	public ActivitiesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Create' and contains(@class,'btn')]")
	private WebElement createbtn;

	@FindBy(xpath = "//input[@id='searchTerm']")
	private WebElement searchtxt;

	@FindBy(xpath = "//button[@data-toggle='tooltip']")
	private WebElement searchbtn;

	public WebElement getCreatebtn() {
		return createbtn;
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

}
