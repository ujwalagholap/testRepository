package pomClassesHDFC;

import java.net.Socket;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SmartBuyPage {
	
	//Source-HDFCHeaderPOM
	//Variables
	
	@FindBy (xpath="(//div[@class='redirect-block'])[2]/a")
	private WebElement btnAccept;
	
	@FindBy (xpath="//button[text()='Accept ']")
	private WebElement btnAcceptPopUp;
	
	@FindBy (xpath="//a[@id='redirectPopupUrl1']")
	private WebElement btnProceed;
	
	@FindBy (xpath="(//div[@class='select-root-area']//div)[1]//h5")
	private WebElement selectSource;
	
	@FindBy (xpath="((//ul[@class='flight-from-data-ul'])[1]//li)[4]")
	private WebElement selectFrom;
	
	@FindBy (xpath="(//div[@class='select-root-area']//div)[19]//h5")
	private WebElement selectDestination;
	
	@FindBy (xpath="((//ul[@class='flight-from-data-ul'])[2]//li)[2]")
	private WebElement selectTo;
	
	@FindBy (xpath="(//div[@class='select-dep-ret']//div)[3]/i")
	private WebElement departureCalender;
	
	@FindBy (xpath="//span[@class='mat-button-wrapper']/span")
	private WebElement depatureCalenderMonth;
	
	@FindBy (xpath="((//div[@class='mat-calendar-header']//div)[1]//button)[3]")
	private WebElement nextBtnOnDepatureCalender;
	
	@FindBy (xpath="(//div[@class='select-root-reutrn departure-date']//span)[2]")
	private WebElement returnCalender;
	
	@FindBy (xpath="//span[@class='mat-button-wrapper']/span")
	private WebElement returnCalenderMonth;
	
	@FindBy (xpath="((//div[@class='mat-calendar-header']//div)[1]//button)[3]")
	private WebElement nextBtnOnReturnCalender;
	
	@FindBy (xpath="//button[text()='Search']")
	private WebElement btnSearch;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Constructors
	public SmartBuyPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver,30);  
	}
	
	//Methods
	public void clickOnButtonAccept()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnAccept)).click();
	}
	public void clickOnButtonAcceptAlertPopUp()
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(btnAcceptPopUp)).click();;
		
	}
	public void clickOnButtonProceed()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnProceed)).click();;	
	}
	
	public void clickOnSelectSource()
	{
		wait.until(ExpectedConditions.elementToBeClickable(selectSource)).click();
	}
	public void clickOnSelectFrom()
	{
		selectFrom.click();
	}
	public void clickOnSelectDestination()
	{
		selectDestination.click();
	}
	public void clickOnSelectTo()
	{
		selectTo.click();
	}
	public void clickOnDepatureCalender()
	{
		departureCalender.click();
	}
	public void selectDepatureDate(String strDepatureMonth,String strDepatureDay)
	{
		while(true)
		{
			//Thread.sleep(2000);
			String strCalenderMonth=depatureCalenderMonth.getText();			
			if(strCalenderMonth.equals(strDepatureMonth))
			{
				break;
			}
			else
			{
				nextBtnOnDepatureCalender.click();
			}
		}
		driver.findElement(By.xpath("//div[@class='mat-calendar-content']//tr//td/button/div[contains(text(),' "+strDepatureDay+"')]")).click();
	}
	public void clickOnReturnCalender()
	{
		returnCalender.click();
	}
	public void selectReturnDate(String strReturnMonth,String strReturnDay)
	{
		while(true)
		{
			//Thread.sleep(2000);
			String strCalenderMonth=returnCalenderMonth.getText();
						
			if(strCalenderMonth.equals(strReturnMonth))
			{
				break;
			}
			else
			{
				nextBtnOnReturnCalender.click();
			}
		}
		
		driver.findElement(By.xpath("//div[@class='mat-calendar-content']//tr//td/button/div[contains(text(),' "+strReturnDay+"')]")).click();
		
	}
	public void clickOnSearchButton()
	{
		btnSearch.click();
	}

}
