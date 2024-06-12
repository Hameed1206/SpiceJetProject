package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class FlightResultPage extends BaseClass{
 
	//By changing this index we can cutomize xpath to choose different options  
	                                        //2-onwardFlight/3-return    flight1/2       which seat type1/2/3
	                             //                         |                |                    |
	//  //div[@id='main-container']/div/div[1]/div[6]/div[2...]/div[5]/div[1...]/div/div[2]/div[3....]/div/div/div
	@FindBy(xpath = "//div[@id='main-container']/div/div[1]/div[6]/div[2]/div[5]/div[2]/div/div[2]/div[1]/div/div/div")
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
	public FlightResultPage getChooseFlightFareMax() throws InterruptedException {
		spiceMaxSeat.click();
		return this;
	}
	public FlightResultPage getChooseFlightFareFlex() throws InterruptedException {
		spiceFlexSeat.click();
		return this;
	}
	public FlightResultPage getChooseFlightFareSaver() throws InterruptedException {
		spiceSaverSeat.click();
		return this;
	}
	public FlightResultPage getCurrentURL() {
		explicitWait(continueButton);
		System.out.println(driver.getCurrentUrl());
		return this;
	}

	public BookingContactDetails getContinueButton() throws InterruptedException {
		//explicitWait(continueButton);
		//All other waits didn't helped to rectify the exception, so I used this static wait
		Thread.sleep(4000);
		continueButton.click();
		return new BookingContactDetails(driver);
	}
}
