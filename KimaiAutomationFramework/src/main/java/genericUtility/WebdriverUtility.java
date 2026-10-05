package genericUtility;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility 
{
	public WebDriver driver;
	WebDriverWait wait;
	
	//browser
	//launch browser
	public WebDriver launchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			final Map<String, Object> chromePrefs = new HashMap<>();
			chromePrefs.put("credentials_enable_service", false);
			chromePrefs.put("profile.password_manager_enabled", false);
			chromePrefs.put("profile.password_manager_leak_detection", false);
			
			final ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
			driver=new ChromeDriver(chromeOptions);
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		return driver;
	}
	
	//maximize browser
	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	//minimize browser
	public void minimizeBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	//implicitwait
	public void implicitlyWaitMethod(WebDriver driver,int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	//fullScreen browser
	 public void fullscreenBrowser() 
	 {
	        driver.manage().window().fullscreen();
	    }
	 
	 //setWindowSize
	 public void setWindowSize(int width, int height)
	 {
	      driver.manage().window().setSize(new Dimension(width, height));
	    }
	 
	 //windowsize
	 public Dimension getWindowSize() 
	 {

	        return driver.manage().window().getSize();
	    }
	 
	 //get window position
	 public Point getWindowPosition() 
	 {

	        return driver.manage().window().getPosition();
	    }
	 
	 //ExplicitWait
	 
	 public void explicitWait(WebDriver driver,int seconds,WebElement ele) {

	        wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
	        wait.until(ExpectedConditions.elementToBeClickable(ele));
	    }
	 
	 //open url
	 public void openURL(String url) 
	 {
	        driver.get(url);
	    }
	 //navigate to url
	 public void navigateTo(String url)
	 {

	        driver.navigate().to(url);
	    }
	
	
	//windows with title
	
	public void handlingWindows(WebDriver driver,String targetTitle) {
		Set<String> WindowIds=driver.getWindowHandles();
		for(String WindowId:WindowIds)
		{
			driver.switchTo().window(WindowId);
			if(driver.getTitle().contains(targetTitle))
				break;
		}
	}
	
	//windows with url
	public void handlingWindows(String targetUrl,WebDriver driver) {
		Set<String> WindowIds=driver.getWindowHandles();
		for(String WindowId:WindowIds)
		{
			driver.switchTo().window(WindowId);
			if(driver.getCurrentUrl().contains(targetUrl))
				break;
		}
	}
	
	//select class
	public void selectFromDD(WebElement ele,String visibleText)
	{
		Select sel=new Select(ele);
		sel.selectByVisibleText(visibleText);
	}
	
	public void selectFromDD(String value,WebElement ele)
	{
		Select sel=new Select(ele);
		sel.selectByValue(value);
	}
	
	public void selectFromDD(int index,WebElement ele)
	{
		Select sel=new Select(ele);
				sel.selectByIndex(index);
	}
	
	//Actions class
	//mousehower
	public void moveToElementAction(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	//rightclick
	 public void rightClick(WebDriver driver,WebElement ele) 
	 {
	        Actions actions = new Actions(driver);

	        actions.contextClick(ele).perform();
	    }
	 //doubleclick
	 public void doubleClick(WebDriver driver,WebElement ele) 
	 {
	        Actions actions = new Actions(driver);

	        actions.doubleClick(ele).perform();
	    }
	
	//alert
	public void acceptAlert() 
	{
        driver.switchTo().alert().accept();
    }
	 public void dismissAlert() 
	 {
	        driver.switchTo().alert().dismiss();
	    }
	 
	 //takesscreeshot
	 public void takeScreenshot(String fileName) throws Exception
	 {
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File dest =new File(fileName);
		 FileHandler.copy(src, dest);
	 }
	 //javascriptExecutor
	 
	 
   
}
