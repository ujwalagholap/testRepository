package pomClassesHDFC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOnIFSCCodePage {
	
	//Source-SearchHDFCBankBranchAndATMsPage
	//Variable
	@FindBy (xpath="(//span[text()='IFSC Code'])[1]")
	private WebElement lblIFSCCode;
	
	@FindBy (xpath="//a[text()='FD Calculator']")
	private WebElement linkFDCalculator;
	
	//Constructor
	public CheckOnIFSCCodePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Methods
	public void clickOnIFSCCodeLink()
	{
		lblIFSCCode.click();
	}
	public void clickOnFDCalculatorLink()
	{
		linkFDCalculator.click();
	}
	

}
