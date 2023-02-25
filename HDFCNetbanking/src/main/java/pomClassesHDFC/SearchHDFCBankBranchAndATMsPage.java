package pomClassesHDFC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHDFCBankBranchAndATMsPage {
	
	//Source-WelcometoHDFCBankNetBanking
	
	//Variable
	@FindBy (xpath="//select[@id='customState']")
	private WebElement dropDownState;
	
	@FindBy (xpath="//select[@id='customCity']")
	private WebElement dropDownCity;
	
	@FindBy (xpath="//input[@id='customLocality']")
	private WebElement txtLocality;
	
	@FindBy (xpath="//select[@id='customRadius']")
	private WebElement dropDownRadius;
	
	@FindBy (xpath="//input[@id='amenity_category_order_types50']")
	private WebElement chkBoxATM;
	
	@FindBy (xpath="//input[@id='amenity_category_order_types49']")
	private WebElement chkBoxBranch;
	
	@FindBy (xpath="//input[@id='amenity_service_types48']")
	private WebElement chkBoxHomeLoan;
	
	@FindBy (xpath="//button[@class='btn btn-search']")
	private WebElement btnSearch;
	
	@FindBy (xpath="//span[text()=' More Details ']")
	private WebElement btnMoreDetails;
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Constructor
	public SearchHDFCBankBranchAndATMsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver,80);
	}
	
	//Methods
	
	public void selectItemInDropDownState(String strState)
	{
		Select sState=new Select(wait.until(ExpectedConditions.elementToBeClickable(dropDownState)));
		sState.selectByValue(strState);	 
	}
	
	public void selectItemInDropDownCity(String strCity)
	{
		Select sCity=new Select(wait.until(ExpectedConditions.elementToBeClickable(dropDownCity)));	
		sCity.selectByVisibleText(strCity);
	}
	
	public void enterLocality(String strLocality)
	{
		txtLocality.sendKeys(strLocality);
	}
	
	public void selectItemInDropDownRadius(String strValue)
	{
		Select sRadius=new Select(dropDownRadius);
		sRadius.selectByValue(strValue);
	}
	
	public void selectChkBoxATM()
	{
		chkBoxATM.click();
	}
	
	public void selectChkBoxBranch()
	{
		chkBoxBranch.click();
	}
	public void selectChkBoxHomeLoan()
	{
		chkBoxHomeLoan.click();
	}
	public void clickOnButtonSearch()
	{
		btnSearch.click();
	}
	public void clickOnButtonMoreDetails()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnMoreDetails)).click();;
		
	}

}
