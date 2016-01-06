package ground_transfer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	@FindBy(id = "loginPageUsername")
	private WebElement emailField;

	@FindBy(id = "loginPagePassword")
	private WebElement passField;

	@FindBy(id = "loginPageSubmitButton")
	private WebElement signButtom;


	public void go(WebDriver driver, String url) {
		driver.get(url);

	}

	public void sendLogin(String email, String pass) {
		emailField.sendKeys(email);
		passField.sendKeys(pass);
		signButtom.click();

	}

}
