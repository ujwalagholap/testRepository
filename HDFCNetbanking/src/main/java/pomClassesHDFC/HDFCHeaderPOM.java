package pomClassesHDFC;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HDFCHeaderPOM {
	
	//source-WelcometoHDFCBankNetBanking
	//Variables
	@FindBy (xpath="//a[text()='Locate us']")
	private WebElement locateUsLogo;
	
	@FindBy (xpath="((//div[@class='navbar-collapse collapse']//ul)[1]//li[@id='webShop']//span)[2]")
	private WebElement linkShop;
	
	@FindBy (xpath="((//ul[@class='sub-menu'])[48]//li)[1]/a")
	private WebElement linkCompareAndFly; 
	
	@FindBy (xpath="(//span[text()='Dining Offers'])[2]")
	private WebElement linkDinningOffers;
	
	private WebDriver driver;
	private Actions actions;
	
	//constructor
	public HDFCHeaderPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		actions=new Actions(driver);
	}
	
	//Methods
//	public void childBrowserHandling(WebDriver driver)
//	{
//		ArrayList<String> add=new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(add.get(1));
//	}
	public void clickOnLocateUsLogo() throws InterruptedException
	{
		Thread.sleep(2000);
		locateUsLogo.click();
	}
	public void clickOnCompareAndFly()
	{
		actions.moveToElement(linkShop).moveToElement(linkCompareAndFly).click().build().perform();
	}
	public void clickOnDinningOffers()
	{
		actions.moveToElement(linkShop).moveToElement(linkDinningOffers).click().build().perform();
	}

}
