	package ground_transfer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Home {
	WebDriver driver;


	public void go(WebDriver driver) {
		driver.get("https://stage.disneycruise.disney.go.com");

	}

	public void clickOnMyRes(WebDriver driver, String urlMyres) throws InterruptedException {
		 driver.get(urlMyres);
	}
		
}