package spice_jet_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;

public class SeatMap extends BaseClass{

	@FindBy (xpath = "(//div[text() = '29E'])[1]")
	WebElement seat;
	
	@FindBy (xpath = "//div[text() = 'Seat Selection']/parent::div/div/div/div[2]//span")
	WebElement verifySeat;
	
	@FindBy (xpath = "//div[text() = 'Seat Selection']/parent::div/div/div/div[5]/div")
	WebElement returnSeat;
	
	@FindBy (xpath = "//div[text() = 'Done']")
	WebElement doneBtn;

	public SeatMap(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
