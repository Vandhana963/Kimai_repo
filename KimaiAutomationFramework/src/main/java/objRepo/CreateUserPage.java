package objRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUserPage {
	WebDriver driver;

	public CreateUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='user_create_username']")
	private WebElement usertxt;

	@FindBy(xpath = "//input[@id='user_create_email']")
	private WebElement emailtxt;
	@FindBy(xpath = "//input[@id='user_create_plainPassword_first']")
	private WebElement pwdtxt;
	@FindBy(xpath = "//input[@id='user_create_plainPassword_second']")
	private WebElement cnfpwdtxt;
	@FindBy(xpath = "//input[@id='user_create_enabled']")
	private WebElement checkbox;
	@FindBy(xpath = "//input[@id='user_create_roles-ts-control']")
	private WebElement roledd;
	
	@FindBy(xpath = "//button[@id='form_modal_save']")
	private WebElement savebtn;
	@FindBy(xpath = "//a[text()='Roles' and @role='tab']")
	private WebElement roleslink;
	@FindBy(xpath = "//input[@id='user_roles_roles_0']")
	private WebElement roleoptn;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitbtn;
	@FindBy(xpath = "//a[@class='btn  action-profile-stats']")
	private WebElement profilelink;

	public WebElement getUsertxt() {
		return usertxt;
	}

	public WebElement getEmailtxt() {
		return emailtxt;
	}

	public WebElement getPwdtxt() {
		return pwdtxt;
	}

	public WebElement getCnfpwdtxt() {
		return cnfpwdtxt;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	

	public WebElement getRoledd() {
		return roledd;
	}

	public WebElement getRoleoptn() {
		return roleoptn;
	}
	

	public WebElement getRoleslink() {
		return roleslink;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public WebElement getProfilelink() {
		return profilelink;
	}

	public void createUser(String name,String email,String pwd,String cnpwd) throws Exception {
		usertxt.sendKeys(name);
		emailtxt.sendKeys(email);
		pwdtxt.sendKeys(pwd);
		cnfpwdtxt.sendKeys(cnpwd);
		savebtn.click();
		roleslink.click();
		roleoptn.click();
		Actions a=new Actions(driver);
		a.moveToElement(submitbtn).click().perform();

		profilelink.click();
		HomePage hp=new HomePage(driver);
		hp.getUserlink().click();
		UsersPage up=new UsersPage(driver);
		up.getSearchtxt().sendKeys(name);
		up.getSearchbtn().click();
		
		
		
	}

}
