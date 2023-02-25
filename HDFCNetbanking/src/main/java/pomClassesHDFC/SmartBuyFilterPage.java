package pomClassesHDFC;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SmartBuyFilterPage {
	//Source-SmartBuyPage
	//Variables
	@FindBy (xpath="((//ul[@class='category-list clearfix mt-2']//li)[1]//span)[1]")
	private WebElement firstFilterCheckbox;
	
	@FindBy (xpath="((//div[@class='sidebar-widget Airlines-widget']//div)[3]//span)[1]")
	private WebElement secondFilterAirlines;
	
	@FindBy (xpath="(//div[@class='col-md-6']//div)[14]")
	private WebElement rdbSourceToDestination;
	
	@FindBy (xpath="(//div[@class='round-options-box collapse show']//div//a)[1]")
	private WebElement selectBtnFirstFlight;
	
	@FindBy (xpath="((//div[@class='col-md-6'])[2]//div)[13]")
	private WebElement rdbDestinationToSource;
	
	@FindBy (xpath="(//div[@class='round-options-list-top'])[26]//button")
	private WebElement btnClearTripFlight;
	
	@FindBy (xpath="(//div[@class='round-options-list-top'])[27]//button")
	private WebElement btnGoibiboFlight;
	
	@FindBy (xpath="(//div[@class='round-options-list-top'])[28]//button")
	private WebElement btnEasyMyTripFlight;
	
	@FindBy (xpath="//button[text()='Book']")
	private WebElement btnBook;
	
	private WebDriver driver;
	
	//Constructors
	public SmartBuyFilterPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	//Methods
	public void clickOnFirstFilerOption()
	{
		WebDriverWait wait=new WebDriverWait(driver,25);
		wait.until(ExpectedConditions.visibilityOf(firstFilterCheckbox)).click();
	}
	public void clickOnSecondFilterAirlines()
	{
		if(firstFilterCheckbox.isSelected()==true)
		{
			secondFilterAirlines.click();
		}
	}
	public void clickOnRdbtnSourceToDestination()
	{
		rdbSourceToDestination.click();
	}
	public void clickOnSelectBtnFromSourceToDest()
	{
		selectBtnFirstFlight.click();
	}
	public void clickOnRdbtnDestinationToSource()
	{
		rdbDestinationToSource.click();
	}
	/*public void clickOnSelectClearFlight()
	{
		btnClearTripFlight.click();
	}
	public void clickOnSelectGoibiboFlight()
	{
		btnGoibiboFlight.click();
	}*/
	public void clickOnBtnBook()
	{
		btnBook.click();
	}
	/*public void clickOnSelectEasyMyTrip()
	{
		btnEasyMyTripFlight.click();
	}*/
	public void selectDestinationToSourceFlight()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Boolean result=btnClearTripFlight.isEnabled();
		System.out.println(result);
		if(result== true)
		{
			js.executeScript("arguments[0].click();", btnClearTripFlight);
			
		}
		else
		{
			
			result=btnGoibiboFlight.isEnabled();
			if(result==true)
			{
				js.executeScript("arguments[0].click();", btnGoibiboFlight);
			}
			else
			{
				
				js.executeScript("arguments[0].click();", btnEasyMyTripFlight);
			}
			
		}
	}
	
	

}
