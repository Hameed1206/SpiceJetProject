package spice_jet_package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;

public class FlightResultPage extends BaseClass{
 
	////div[@id='list-results-section-0']/div[5]/div[1]/div/div[2]/div[2]/div/div/div/div[1]
	////div[@data-testid='spiceflex-flight-select-radio-button-1']/parent::div
	                                                  //to2/return3      flight1/2        which seat type1/2/3
	//  //div[@id='main-container']/div/div[1]/div[6]/div[2...]/div[5]/div[1...]/div/div[2]/div[3....]/div/div/div
	@FindBy(xpath = "//div[@id='main-container']/div/div[1]/div[6]/div[3]/div[5]/div[2]/div/div[2]/div[1]/div/div/div")
	WebElement spiceSaverSeat;
	
	@FindBy(xpath = "//div[@id='main-container']/div/div[1]/div[6]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div/div")
	WebElement spiceFlexSeat;
	
	@FindBy(xpath = "//div[@id='main-container']/div/div[1]/div[6]/div[2]/div[5]/div[1]/div/div[2]/div[3]/div/div/div")
	WebElement spiceMaxSeat;
	
	@FindBy(xpath = "//div[@data-testid ='continue-search-page-cta']")
	WebElement continueButton;

	public FlightResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public FlightResultPage getChooseFlightFare() throws InterruptedException {
		//explicitWait(spiceFlexSeat);
		spiceMaxSeat.click();
		//spiceSaverSeat.click();
	//	WebElement element = driver.findElement(By.xpath("(//div[text() = 'Direct'])["+to2_return4+"]/parent::div/parent::div/parent::div/following-sibling::div/child::div["+fare+"]/div"));
	//	element.click();  int to2_return4, int fare
		return this;
	}
	public FlightResultPage getCurrentURL() {
		explicitWait(continueButton);
		System.out.println(driver.getCurrentUrl());
		return this;
	}

	public BookingContactDetails getContinueButton() throws InterruptedException {
		//explicitWait(continueButton);
		Thread.sleep(4000);
		continueButton.click();
		return new BookingContactDetails(driver);
	}
}
