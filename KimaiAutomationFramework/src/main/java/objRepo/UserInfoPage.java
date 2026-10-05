package objRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInfoPage 
{
	WebDriver driver;

	public UserInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[contains(.,' Edit')]")
	private WebElement editbtn;

	@FindBy(xpath = "//a[text()='Profile' and @class='dropdown-item action-edit']")
	private WebElement proflink;

	@FindBy(xpath = "//input[@id='user_edit_enabled']")
	private WebElement togglebtn;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement savbtn;



	public void deactivateUser() throws Exception{
		driver.findElement(By.xpath("//span[contains(.,'AJ')]")).click();
		Actions a=new Actions(driver);
		a.moveToElement(editbtn).click().perform();
		Actions ac=new Actions(driver);
		ac.moveToElement(proflink).click().perform();
		Actions a1=new Actions(driver);
		a1.moveToElement(togglebtn).click().perform();
		Thread.sleep(1000);
		Actions a2=new Actions(driver);
		a2.moveToElement(savbtn).click().perform();	
	}
	
	public void reactivateUser() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[contains(.,'AJ')]")).click();
		Actions a=new Actions(driver);
		a.moveToElement(editbtn).click().perform();
		Actions ac=new Actions(driver);
		ac.moveToElement(proflink).click().perform();
		Actions a1=new Actions(driver);
		a1.moveToElement(togglebtn).click().perform();
		Thread.sleep(1000);
		Actions a2=new Actions(driver);
		a2.moveToElement(savbtn).click().perform();	
		
		
		
	}

}
