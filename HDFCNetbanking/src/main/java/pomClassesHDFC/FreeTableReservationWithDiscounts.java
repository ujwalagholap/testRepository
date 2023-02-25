package pomClassesHDFC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeTableReservationWithDiscounts {
	//Source-HDFCHeaderPOM
	//Variables
	@FindBy (xpath="//div[@class='AmO1L']//h2")
	private WebElement tableCityHeader;
	
	@FindBy (xpath="(//div[@class='AmO1L']//li)[6]")
	private WebElement selectCity;
	
	@FindBy (xpath="((//div[@class='react-multi-carousel-list  '])[1]//div)[1]/a/img")
	private WebElement selectOffer;
	
	//Constructors
	public FreeTableReservationWithDiscounts(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public void getTableHeaderText()
	{
		String actualText=tableCityHeader.getText();
		String expectedText="Select City";
		if(expectedText.equals(actualText))
		{
			selectCityFromTable();
			clickOnSelectOffer();
		}
	}
	public void selectCityFromTable()
	{
		selectCity.click();
	}
	public void clickOnSelectOffer()
	{
		selectOffer.click();
	}

}
