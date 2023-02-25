package pomClassesHDFC;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CalculateFDInterestPage {
	/*
	 * add=new ArrayList<>(driver.getWindowHandles());
					driver.switchTo().window(add.get(3));
	 */
	//Variables
	@FindBy (xpath="//div[@class='form-group']/select")
	private WebElement dropDownTypeOfDeposit;
	
	@FindBy (xpath="//div[@id='js-rangeslider-0']")
	private WebElement sliderForDeposit;
	
	@FindBy (xpath="//input[@id='months']")
	private WebElement selectMonths;
	
	@FindBy (xpath="(//input[@id='days'])[1]")
	private WebElement selectDays;
	
	@FindBy (xpath="//input[@placeholder='dd/mm/yyyy']")
	private WebElement calenderIcon;
	
	@FindBy (xpath="//button[text()='OK']")
	private WebElement btnOk;
	
	@FindBy (xpath="((//table[@class='ui-datepicker-calendar']//tr)[6]//td)[3]")
	private WebElement startDate;
	
	@FindBy (xpath="//input[@id='radio-senior-no']")
	private WebElement rdbSeniorCitizen;
	
	@FindBy (xpath="//a[text()='Calculate']")
	private WebElement btnCalculate;
	
	private WebDriver driver;
		
	//Constructor
	public CalculateFDInterestPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	//Methods
	public void selectTypeOfDeposit()
	{
		Select sTypeOfDep=new Select(dropDownTypeOfDeposit);
		sTypeOfDep.selectByVisibleText("Monthly Payout");
	}
	public void selectAmountYouDeposit()
	{
		Actions move=new Actions(driver);
		Action action=(Action)move.dragAndDropBy(sliderForDeposit,-40,0).build();
		action.perform();
	}
	public void sendMonthsMethods(String strMonth)
	{
		selectMonths.sendKeys(strMonth);
	}
	public void sendDaysMethods(String strDays)
	{
		selectDays.sendKeys(strDays);
	}
	public void clickOnCalenderIcon()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", calenderIcon);
		calenderIcon.click();
	}
	public void clickOnButtonOK()
	{
		btnOk.click();
	}
	public void selectStartDate()
	{
		startDate.click();
	}
	public void checkSeniorCitizen()
	{
		if(rdbSeniorCitizen.isSelected())
			{
				clickOnButtonCalculate();
			} 
	}
	public void clickOnButtonCalculate()
	{
		btnCalculate.click();
	}
	

}
