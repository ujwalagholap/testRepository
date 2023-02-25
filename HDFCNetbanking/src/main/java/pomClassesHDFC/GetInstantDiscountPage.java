package pomClassesHDFC;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetInstantDiscountPage {
	//Source-BestPuneRestaurantsPage
	//Variables
	//@FindBy (xpath="//li[@class='cDate current']//div")
	//private WebElement selectDate;
	
	@FindBy (xpath ="(//li[@class='cDate'])[1]//div/strong")
	private WebElement selectDate;
	
	@FindBy (xpath="(//div[@class='collapse in']//li)[2]/a")
	private WebElement mealType;
	
	@FindBy (xpath="((//ul[@class='time-slots-avail clearfix'])[2]//li)[17]/div/span")
	private WebElement selectSlot;
	
	@FindBy (xpath="//div[@class='guest-input']/input")
	private WebElement guestCount;
	
	@FindBy (xpath="//div[@class='qty-plus cursor']/a")
	private WebElement guestNumber;
	
	@FindBy (xpath="//input[@id='name']")
	private WebElement guestName;
	
	@FindBy (xpath="//input[@id='phone']")
	private WebElement mobileNumber;
	
	@FindBy (xpath="//div[@class='btn-floatingDiv']//span")
	private WebElement btnContinue;
	
	private WebDriver driver;
	
	//Constructor
	public GetInstantDiscountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//Methods
	public void clickOnSelectDate()
	{
		selectDate.click();
	}
	public void clickOnMealType()
	{
		mealType.click();
	}
	public void selectSlotForMeal()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", selectSlot);
		selectSlot.click();
	}
	public void selectGuestCount()
	{
		while(true) 
		{		
			String count="2";
			if((guestCount.getAttribute("value")).equals(count))
				{
					break;
				}
				else
				{
					guestNumber.click();
				}
		}
	}
	public void enterGuestName(String StrGuestName,String strMobileNumber)
	{
		guestName.sendKeys(StrGuestName);
		enterMobileNumber(strMobileNumber);
	}
	public void enterMobileNumber(String strMobile)
	{
		mobileNumber.sendKeys(strMobile);
	}
	public void clickOnButtonContinue()
	{
		btnContinue.click();
	}

}
