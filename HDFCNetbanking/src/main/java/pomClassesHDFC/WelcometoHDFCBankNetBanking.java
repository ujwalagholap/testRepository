package pomClassesHDFC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcometoHDFCBankNetBanking {
	
	//variables
	@FindBy (partialLinkText="More...")
	private WebElement lblKnowMore;
	
	private WebDriver driver;
	
	//Constructor
	public WelcometoHDFCBankNetBanking(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//Methods
	public void clickOnKnowMoreLable()
	{
		lblKnowMore.click();
	}

}
