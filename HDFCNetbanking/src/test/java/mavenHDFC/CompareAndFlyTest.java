package mavenHDFC;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClassesHDFC.HDFCHeaderPOM;
import pomClassesHDFC.SmartBuyFilterPage;
import pomClassesHDFC.SmartBuyPage;
import pomClassesHDFC.WelcometoHDFCBankNetBanking;

public class CompareAndFlyTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.manage().window().maximize();
		
		WelcometoHDFCBankNetBanking welcometoHDFCBankNetBanking=new WelcometoHDFCBankNetBanking(driver);
		driver.switchTo().frame("login_page");
		welcometoHDFCBankNetBanking.clickOnKnowMoreLable();
		
		HDFCHeaderPOM hDFCHeaderPOM=new HDFCHeaderPOM(driver);
		ArrayList<String> add=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(add.get(1));

		hDFCHeaderPOM.clickOnCompareAndFly();
//		add=new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(add.get(2));
		
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
		smartBuyPage.selectDepatureDate("MAR 2023","3");
		smartBuyPage.clickOnReturnCalender();
		smartBuyPage.selectReturnDate("APRIL 2023","3");
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
		
		//Not executing due to-smartBuyPage.clickOnButtonProceed(driver); ,unable to click on proceed button
		
		
		
		
		
	}

}
