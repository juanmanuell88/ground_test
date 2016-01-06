package ground_transfer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Myres {

	public void selectMyres(WebDriver driver, int reservationIdList) throws InterruptedException {
		
		List<WebElement> resList = driver.findElements(By.cssSelector("div[class='reservationListingRightColumn ng-scope']>div[class='detail ng-scope']>span>[class='ng-scope']"));
		resList.get(reservationIdList).click();
		Thread.sleep(10000);
		
        // Data of Myres (View Details) 
		String viewDetailsDates = driver.findElement(By.cssSelector(".sailingDates.ng-binding")).getText();
		String viewDetailsName = driver.findElement(By.xpath("html/body/div[4]/div/div/div[1]/h1/div[1]")).getText();
		String viewDetailsstateroom = driver.findElement(By.xpath("html/body/div[4]/div/div/div[2]/div[2]/div/div[2]/h3")).getText();
		int listviewDetailsGuest = driver.findElements(By.cssSelector("div[class='guestStateroomCard ng-scope']>div[class='left ng-binding']")).size();
		String viewDetailsguest = "";
		for (int n = 0; n < listviewDetailsGuest; n++) {
			String viewDetailsNameGuest = driver
					.findElements(
							By.cssSelector("div[class='guestStateroomCard ng-scope']>div[class='left ng-binding']"))
					.get(n).getText();
			viewDetailsguest = viewDetailsguest + " " + viewDetailsNameGuest;
		}
		
		
		driver.findElement(By.cssSelector("div[class='left ng-scope'][ng-if='item.invoice.groundTransfer.modifiable']>a")).click();
		Thread.sleep(10000);
		
		// Data of Ground 
		String groundDates = driver.findElement(By.xpath(".//*[@id='pageContent']/div[2]/div/div[2]/cruise-overview-stateroom-details/div/section/div[1]/div/span")).getText();
		String groundName = driver.findElement(By.xpath(".//*[@id='pageContent']/div[2]/div/div[2]/cruise-overview-stateroom-details/div/section/div[1]/div/h3")).getText();
		String groundstateroom = driver.findElement(By.xpath(".//*[@id='pageContent']/div[2]/div/div[2]/cruise-overview-stateroom-details/div/section/div[3]/div/h3")).getText();
		int listGroundGuest = driver.findElements(By.cssSelector("[class='ng-isolate-scope']>[tabindex='0']>tbody>tr>td>span[class='ng-binding']")).size();
		String groundguest = "";
		for (int n = 0; n < listGroundGuest; n++) {
			String groundNameGuest = driver
					.findElements(
							By.cssSelector("[class='ng-isolate-scope']>[tabindex='0']>tbody>tr>td>span[class='ng-binding']"))
					.get(n).getText();
			groundguest = groundguest + " " + groundNameGuest;
		}
		
		
		//Compare data of Myres with Ground		
		Boolean Compare =  viewDetailsName.equals(groundName);
		        Compare =  viewDetailsDates.equals(groundDates);
		        Compare =  viewDetailsstateroom.equals(groundstateroom);
		        Compare =  viewDetailsguest.equals(groundguest);
				
		if (Compare == true) {
	    System.out.println("successful comparison");	
		} else {
	    System.out.println("unsuccessful comparison");
		}
   
	   //Check radio
	   //Click on radio buttom without ground
	   driver.findElement(By.id("ground-transportation-button-no")).click();   	   
	   
	   //arie-hidden=false when click on radio buttom without ground
	   driver.findElement(By.cssSelector("span[class='no-selection ng-scope'][aria-hidden='false']"));
	   System.out.println("Successful test ....... radio without ground");
	   
	   //Click on radio buttom with ground
	   driver.findElement(By.id("ground-transportation-button-yes")).click();
	   
	   //check radio with ground
	   driver.findElement(By.cssSelector("td[class=ground-price]>[hide-currency='true'][class='ng-isolate-scope']"));
	   System.out.println("Successful test ....... radio with ground");
		
	   //check summary ground
	   int guestTotal = 0;
	   int groundTotal = 0;
		for (int n = 0; n < listGroundGuest; n++) {
			String guestPriceList = driver
					.findElements(
							By.cssSelector("td[class=ground-price]>[hide-currency='true'][class='ng-isolate-scope']>span[class='sr-only ng-binding']"))
					.get(n).getText();

			if (guestPriceList.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
				int guestPrice = Integer.parseInt(guestPriceList);
				guestTotal = guestTotal + guestPrice;
			}			
											
		}
	    
		String ground_Total = driver.findElement(By.cssSelector("[class='price-total']>[class='ng-isolate-scope']>span")).getText();
	    groundTotal = Integer.parseInt(ground_Total);
	    
		if (guestTotal == groundTotal) {
			System.out.println("Successful test ....... total price of ground");
		}
	   
		driver.findElement(By.cssSelector("div[class='subflow-dock']>div[class='buttonsWrapper clearfix has-steps']>div[class='rightContainer pull-right']")).click();
		Thread.sleep(10000);
		
	   //Test in checkout of the amount of ground 	
		int checkoutgroundtotal = 0;
		String checkout_ground_total = driver.findElement(By.cssSelector("[class='price-list list-items']>div>table>tbody>[class='item ng-scope']>[class='item-price ng-scope']>[class='ng-isolate-scope']>span")).getText();
		checkoutgroundtotal = Integer.parseInt(checkout_ground_total);
		if (guestTotal == checkoutgroundtotal) {
			System.out.println("Ground amount in checkout ..... fine");
		};
		
		
	}
	
}
