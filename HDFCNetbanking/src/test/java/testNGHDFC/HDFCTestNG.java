package testNGHDFC;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import pomClassesHDFC.CheckOnIFSCCodePage;
import pomClassesHDFC.HDFCHeaderPOM;
import pomClassesHDFC.SearchHDFCBankBranchAndATMsPage;
import pomClassesHDFC.WelcometoHDFCBankNetBanking;

public class HDFCTestNG  extends Browser{
	WebDriver driver;
	WelcometoHDFCBankNetBanking welcometoHDFCBankNetBanking;
	HDFCHeaderPOM hDFCHeaderPOM;
	SearchHDFCBankBranchAndATMsPage searchHDFCBankBranchAndATMsPage;
	CheckOnIFSCCodePage checkOnIFSCCodePage;
	ArrayList<String> add;
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String strBrowserName)
	{
		
		if(strBrowserName.equals("Chrome"))
		{
			//driver=Pojo.openChromeBrowser();
			driver=openChromeBrowser();
			driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		}
		if(strBrowserName.equals("Firefox"))
		{
			driver=openFirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		if(strBrowserName.equals("Opera"))
		{
			driver=openOperaDriver();
			driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		}
	
		//driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);	
		driver.manage().window().maximize();
	}
	@BeforeClass
	public void createPOMObjects()
	{
		welcometoHDFCBankNetBanking=new WelcometoHDFCBankNetBanking(driver);
		hDFCHeaderPOM=new HDFCHeaderPOM(driver);
		searchHDFCBankBranchAndATMsPage=new SearchHDFCBankBranchAndATMsPage(driver);
		checkOnIFSCCodePage=new CheckOnIFSCCodePage(driver);
		
	}
	
	@BeforeMethod
	public void goToKnowMore()
	{
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.switchTo().frame("login_page");
		welcometoHDFCBankNetBanking.clickOnKnowMoreLable();
	
	}
	@Test (priority = 1)
	public void locateTheBranch() throws InterruptedException
	{		
		add=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(add.get(1));
		hDFCHeaderPOM.clickOnLocateUsLogo();
		
		add=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(add.get(2));
				
		searchHDFCBankBranchAndATMsPage.selectItemInDropDownState("maharashtra");
		searchHDFCBankBranchAndATMsPage.selectItemInDropDownCity("Sangli");
		searchHDFCBankBranchAndATMsPage.enterLocality("Gaonbhag");
		searchHDFCBankBranchAndATMsPage.selectItemInDropDownRadius("7");
		searchHDFCBankBranchAndATMsPage.selectChkBoxATM();
		searchHDFCBankBranchAndATMsPage.selectChkBoxBranch();
		searchHDFCBankBranchAndATMsPage.selectChkBoxHomeLoan();
		searchHDFCBankBranchAndATMsPage.clickOnButtonSearch();
	}
	
	@Test (priority = 2)
	public void checkTheIFSCCode() throws InterruptedException
	{
		add=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(add.get(1));
		hDFCHeaderPOM.clickOnLocateUsLogo();
		add=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(add.get(2));
		
		searchHDFCBankBranchAndATMsPage.selectItemInDropDownState("maharashtra");
		searchHDFCBankBranchAndATMsPage.selectItemInDropDownCity("Sangli");
		searchHDFCBankBranchAndATMsPage.enterLocality("Gaonbhag");
		searchHDFCBankBranchAndATMsPage.selectItemInDropDownRadius("7");
		searchHDFCBankBranchAndATMsPage.selectChkBoxATM();
		searchHDFCBankBranchAndATMsPage.selectChkBoxBranch();
		searchHDFCBankBranchAndATMsPage.selectChkBoxHomeLoan();
		searchHDFCBankBranchAndATMsPage.clickOnButtonSearch();
		
		//Search the IFSC code for located branch
		searchHDFCBankBranchAndATMsPage.clickOnButtonMoreDetails();
		checkOnIFSCCodePage.clickOnIFSCCodeLink();
	}
	
	@AfterMethod
	public void backToMainPage()
	{
		driver.close();
		driver.switchTo().window(add.get(1));
		driver.close();
		driver.switchTo().window(add.get(0));
	}
	@AfterClass
	public void clearPOMObjects()
	{
		welcometoHDFCBankNetBanking=null;
		hDFCHeaderPOM=null;
		searchHDFCBankBranchAndATMsPage=null;
		checkOnIFSCCodePage=null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver.quit();
		driver=null;
		System.gc();
	}

}
