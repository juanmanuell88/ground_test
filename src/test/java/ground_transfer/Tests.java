package ground_transfer;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Tests {
	WebDriver driver;

	 @BeforeMethod
	 public void before() { 
       driver = new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.manage().window().maximize(); 
	   }

	@AfterMethod
	public void after() {
		driver.quit();
	}
	
	
    @Test
	public void latest() throws InterruptedException {

		Login login = PageFactory.initElements(driver, Login.class);
		login.go(driver, "https://latest.disneycruise.disney.go.com/login/");
		Thread.sleep(10000);
		login.sendLogin("juan.luduena@mail.com", "password1");
		Thread.sleep(5000);
		Home home = PageFactory.initElements(driver, Home.class);
		home.clickOnMyRes(driver, "https://latest.disneycruise.disney.go.com/my-disney-cruise/reservations/");
		Thread.sleep(10000);
		Myres myres = PageFactory.initElements(driver, Myres.class);
		myres.selectMyres(driver, 0);
	}

	@Test
	public void stage() throws InterruptedException {

		Login login = PageFactory.initElements(driver, Login.class);
		login.go(driver, "https://stage.disneycruise.disney.go.com/login/");
		Thread.sleep(10000);
		login.sendLogin("tickets@tickets.com", "password1");
		Thread.sleep(5000);
		Home home = PageFactory.initElements(driver, Home.class);
		home.clickOnMyRes(driver, "https://stage.disneycruise.disney.go.com/my-disney-cruise/reservations/");
		Thread.sleep(10000);
		Myres myres = PageFactory.initElements(driver, Myres.class);
		myres.selectMyres(driver, 0);
	}

	@Test
	public void lt1() throws InterruptedException {

		Login login = PageFactory.initElements(driver, Login.class);
		login.go(driver, "https://lt1.disneycruise.disney.go.com/login/");
		Thread.sleep(10000);
		login.sendLogin("germanschreiber@mail.com", "password1");
		Thread.sleep(5000);
		Home home = PageFactory.initElements(driver, Home.class);
		home.clickOnMyRes(driver, "https://lt1.disneycruise.disney.go.com/my-disney-cruise/reservations/");
		Thread.sleep(10000);
		Myres myres = PageFactory.initElements(driver, Myres.class);
		myres.selectMyres(driver, 0);		
		
	}
}
