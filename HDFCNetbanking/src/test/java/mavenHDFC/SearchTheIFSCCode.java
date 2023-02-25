package mavenHDFC;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClassesHDFC.CheckOnIFSCCodePage;
import pomClassesHDFC.HDFCHeaderPOM;
import pomClassesHDFC.SearchHDFCBankBranchAndATMsPage;
import pomClassesHDFC.WelcometoHDFCBankNetBanking;

public class SearchTheIFSCCode {

	public static void main(String[] args) throws InterruptedException {
		
				// Locate the Nearest the Branch
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				
				driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get("https://netbanking.hdfcbank.com/netbanking/");
				
				WelcometoHDFCBankNetBanking welcometoHDFCBankNetBanking=new WelcometoHDFCBankNetBanking(driver);
				driver.switchTo().frame("login_page");
				welcometoHDFCBankNetBanking.clickOnKnowMoreLable();
				
				HDFCHeaderPOM hDFCHeaderPOM=new HDFCHeaderPOM(driver);
					
				ArrayList<String> add=new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(add.get(1));
				
				hDFCHeaderPOM.clickOnLocateUsLogo();
				add=new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(add.get(2));
				
						
				SearchHDFCBankBranchAndATMsPage searchHDFCBankBranchAndATMsPage=new SearchHDFCBankBranchAndATMsPage(driver);
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
				CheckOnIFSCCodePage checkOnIFSCCodePage=new CheckOnIFSCCodePage(driver);
				checkOnIFSCCodePage.clickOnIFSCCodeLink();

	}

}
