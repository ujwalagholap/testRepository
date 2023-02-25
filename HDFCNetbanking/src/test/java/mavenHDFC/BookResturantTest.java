package mavenHDFC;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClassesHDFC.BestPuneRestaurantsPage;
import pomClassesHDFC.FreeTableReservationWithDiscounts;
import pomClassesHDFC.GetInstantDiscountPage;
import pomClassesHDFC.HDFCHeaderPOM;
import pomClassesHDFC.WelcometoHDFCBankNetBanking;

public class BookResturantTest {

	public static void main(String[] args) throws InterruptedException {
		
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
		hDFCHeaderPOM.clickOnDinningOffers();
		Thread.sleep(2000);
		//Book Resturant
		FreeTableReservationWithDiscounts freeTableReservationWithDiscounts=new FreeTableReservationWithDiscounts(driver);
		freeTableReservationWithDiscounts.getTableHeaderText();
		
		Thread.sleep(2000);
		
		BestPuneRestaurantsPage bestPuneRestaurantsPage=new BestPuneRestaurantsPage(driver);
		bestPuneRestaurantsPage.selectChk5StarFilter();
		Thread.sleep(2000);
		bestPuneRestaurantsPage.clickOnSelectedRestaturant();
		Thread.sleep(2000);
		
		GetInstantDiscountPage getInstantDiscountPage=new GetInstantDiscountPage(driver);
		Thread.sleep(2000);
		getInstantDiscountPage.clickOnSelectDate();
		getInstantDiscountPage.clickOnMealType();
		getInstantDiscountPage.selectSlotForMeal();
		getInstantDiscountPage.selectGuestCount();
		getInstantDiscountPage.enterGuestName("Ujwala Gholap","9359576756");
		getInstantDiscountPage.clickOnButtonContinue();
		
		
		

	}

}
