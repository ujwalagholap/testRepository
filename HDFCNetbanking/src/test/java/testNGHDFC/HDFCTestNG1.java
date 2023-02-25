package testNGHDFC;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import pomClassesHDFC.BestPuneRestaurantsPage;
import pomClassesHDFC.CheckOnIFSCCodePage;
import pomClassesHDFC.FreeTableReservationWithDiscounts;
import pomClassesHDFC.GetInstantDiscountPage;
import pomClassesHDFC.HDFCHeaderPOM;
import pomClassesHDFC.SearchHDFCBankBranchAndATMsPage;
import pomClassesHDFC.SmartBuyFilterPage;
import pomClassesHDFC.SmartBuyPage;
import pomClassesHDFC.WelcometoHDFCBankNetBanking;

public class HDFCTestNG1 extends Browser{
	
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
	public void compareAndFlyTest()
	{
		HDFCHeaderPOM hDFCHeaderPOM=new HDFCHeaderPOM(driver);
		ArrayList<String> add=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(add.get(1));

		hDFCHeaderPOM.clickOnCompareAndFly();
		
		//Check the functionality of Comapre And Fly
		SmartBuyPage smartBuyPage=new SmartBuyPage(driver);
		smartBuyPage.clickOnButtonAccept();
		smartBuyPage.clickOnButtonAcceptAlertPopUp();
		smartBuyPage.clickOnButtonProceed();
		smartBuyPage.clickOnSelectSource();
		smartBuyPage.clickOnSelectFrom();
		smartBuyPage.clickOnSelectDestination();
		smartBuyPage.clickOnSelectTo();
		smartBuyPage.clickOnDepatureCalender();
		smartBuyPage.selectDepatureDate("Mar 2023","3");
		smartBuyPage.clickOnReturnCalender();
		smartBuyPage.selectReturnDate("April 2023","2");
		smartBuyPage.clickOnSearchButton();
				
		//Select the Flights
		SmartBuyFilterPage smartBuyFilterPage=new SmartBuyFilterPage(driver);
		smartBuyFilterPage.clickOnFirstFilerOption();
		smartBuyFilterPage.clickOnSecondFilterAirlines();
		smartBuyFilterPage.clickOnRdbtnSourceToDestination();
		smartBuyFilterPage.clickOnSelectBtnFromSourceToDest();
		smartBuyFilterPage.clickOnRdbtnDestinationToSource();
		smartBuyFilterPage.selectDestinationToSourceFlight();
		smartBuyFilterPage.clickOnBtnBook();
				
	}
	
	@Test (priority = 2)
	public void BookResturantTest() throws InterruptedException
	{
		HDFCHeaderPOM hDFCHeaderPOM=new HDFCHeaderPOM(driver);
		ArrayList<String> add=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(add.get(1));
		hDFCHeaderPOM.clickOnDinningOffers();
		
		//Book Resturant
		FreeTableReservationWithDiscounts freeTableReservationWithDiscounts=new FreeTableReservationWithDiscounts(driver);
		freeTableReservationWithDiscounts.getTableHeaderText();
		
		BestPuneRestaurantsPage bestPuneRestaurantsPage=new BestPuneRestaurantsPage(driver);
		bestPuneRestaurantsPage.selectChk5StarFilter();
		bestPuneRestaurantsPage.clickOnSelectedRestaturant();
		
		GetInstantDiscountPage getInstantDiscountPage=new GetInstantDiscountPage(driver);
		getInstantDiscountPage.clickOnSelectDate();
		getInstantDiscountPage.clickOnMealType();
		getInstantDiscountPage.selectSlotForMeal();
		getInstantDiscountPage.selectGuestCount();
		getInstantDiscountPage.enterGuestName("Ujwala Gholap","9359576756");
		getInstantDiscountPage.clickOnButtonContinue();
	}

	
	@AfterMethod
	public void backToMainPage()
	{
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
