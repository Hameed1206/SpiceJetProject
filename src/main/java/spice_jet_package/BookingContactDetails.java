package spice_jet_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;

public class BookingContactDetails extends BaseClass {

	@FindBy (xpath = "(//div[text() = 'First and Middle Name*']/parent::div/following-sibling::div/input)[1]")
	WebElement contactFName;
	
	@FindBy (xpath = "(//div[text() = 'Last Name*']/parent::div/following-sibling::div/input)[1]")
	WebElement contactLName;
	
	@FindBy (xpath = "//div[text() = 'Contact Number*']/parent::div/following-sibling::div/input")
	WebElement contactNo;
	
	@FindBy (xpath = "//div[text() = 'Email Address*']/parent::div/following-sibling::div/input")
	WebElement emailID;
	
	@FindBy (xpath = "//div[text() = 'Town or City']/parent::div/following-sibling::div/input")
	WebElement cityName;
	
	@FindBy (xpath = "(//div[text() = 'First and Middle Name*']/parent::div/following-sibling::div/input)[2]")
	WebElement passengerFName;
	
	@FindBy (xpath = "(//div[text() = 'Last Name*']/parent::div/following-sibling::div/input)[2]")
	WebElement passengerLName;
	
	@FindBy (xpath = "//div[contains(text() , 'Mobile Number')]/parent::div/following-sibling::div/input")
	WebElement passengerPhNo;
	
	public BookingContactDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
