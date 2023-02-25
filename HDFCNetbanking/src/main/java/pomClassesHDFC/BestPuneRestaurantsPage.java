package pomClassesHDFC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BestPuneRestaurantsPage {
	//BestPuneRestaurantsPage POM class for searching
	//Source-FreeTableReservationWithDiscounts
	//Variables
	@FindBy (xpath="(//div[@class='filter-component-wrap _quickfilters-wrap']//li)[3]/label/span")
	private WebElement chk5StarFilter;
	
	@FindBy (xpath="(((//div[@class='restnt-card-wrap-new']//div)[2]//div)[5]//div)[5]/a")
	private WebElement selectRestaurant;
	
	//Constructor
	public BestPuneRestaurantsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public void selectChk5StarFilter() throws InterruptedException
	{
		Thread.sleep(2000);
		chk5StarFilter.click();
	}
	public void clickOnSelectedRestaturant()
	{
		selectRestaurant.click();
	}
	
	
}
