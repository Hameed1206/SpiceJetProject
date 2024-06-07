package spice_jet_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;

public class FlightResultPage extends BaseClass{

	@FindBy(xpath = "(//div[text() = 'Direct'])[2]/parent::div/parent::div/parent::div/following-sibling::div/child::div[1]/div")
	WebElement chooseFlightFare;
	
	@FindBy(xpath = "(//div[text() = 'Direct'])[4]/parent::div/parent::div/parent::div/following-sibling::div/child::div[1]/div")
	WebElement chooseFlightReturnFare;
	
	@FindBy(xpath = "(//div[text()='Continue'])[1]")
	WebElement continueButton;
	
	public FlightResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
