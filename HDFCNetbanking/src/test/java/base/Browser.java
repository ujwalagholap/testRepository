package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser {
	
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	public static WebDriver openFirefoxDriver()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.32.1-win32\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		return driver;
		
	}
	public static WebDriver openOperaDriver()
	{
		System.setProperty("webdriver.opera.driver", "D:\\chromedriver_win32\\operadriver.exe");
		WebDriver driver=new OperaDriver();
		return driver;
	}

}
