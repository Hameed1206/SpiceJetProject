package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class BookingContactDetails extends BaseClass {

	@FindBy (xpath = "(//div[text() = 'First and Middle Name*']/parent::div/following-sibling::div/input)[1]")
	WebElement contactFName;
	
	@FindBy (xpath = "(//div[text() = 'Last Name*']/parent::div/following-sibling::div/input)[1]")
	WebElement contactLName;
	
	@FindBy (xpath = "//div[text() = 'Contact Number*']/parent::div/following-sibling::div/input")
	WebElement contactNo;
	
	@FindBy (xpath = "//div[text() = 'Email Address*']/parent::div/following-sibling::div/input")
	WebElement emailID;
	
	@FindBy (xpath = "//div[text()='Country*']/parent::div/div[2]/div[1]")
	WebElement countryBox;
	
	@FindBy (xpath = "//div[text()='Country*']/parent::div/div[2]/div[2]/div[2]/div/div")
	List<WebElement> chooseCountry;
	
	@FindBy (xpath = "//div[text() = 'Town or City']/parent::div/following-sibling::div/input")
	WebElement cityName;
	
	@FindBy(xpath= "//div[contains(text(),'I am flying as the primary')]/preceding-sibling::div")
	WebElement primaryPassenger;
	
	@FindBy (xpath = "(//div[text() = 'First and Middle Name*']/parent::div/following-sibling::div/input)[2]")
	WebElement passengerFName;
	
	@FindBy (xpath = "(//div[text() = 'Last Name*']/parent::div/following-sibling::div/input)[2]")
	WebElement passengerLName;
	
	@FindBy (xpath = "//div[contains(text() , 'Mobile Number')]/parent::div/following-sibling::div/input")
	WebElement passengerPhNo;
	
	@FindBy (xpath = "//div[@data-testid='traveller-info-continue-cta']")
	WebElement continueButton;
	
	public BookingContactDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public BookingContactDetails getContactFName(String fname) {
		contactFName.sendKeys(fname);
		return this;
	}
	public BookingContactDetails getContactLName(String lname) {
		contactLName.sendKeys(lname);
		return this;
	}
	public BookingContactDetails getContactNo(String phone) {
		contactNo.sendKeys(phone);
		return this;
	}
	public BookingContactDetails getEmailID(String email) {
		emailID.sendKeys(email);
		return this;
	}
	public BookingContactDetails getCountryName(String country) {
		countryBox.click();
		int elementIndexByText = findElementIndexByText(chooseCountry, country);
		chooseCountry.get(elementIndexByText).click();
		return this;
	}
	public BookingContactDetails getCityName(String city) {
		cityName.sendKeys(city);
		return this;
	}
	public BookingContactDetails getPrimaryPassenger() {
		primaryPassenger.click();
		return this;
	}
	public BookingContactDetails getPassengerFName(String pFname) {
		passengerFName.sendKeys(pFname);
		return this;
	}
	public BookingContactDetails getPassengerLName(String pLname) {
		passengerLName.sendKeys(pLname);
		return this;
	}
	public BookingContactDetails getPassengerPhNo(String pPhone) {
		passengerPhNo.sendKeys(pPhone);
		return this;
	}
	public BookSeat getContinueButton() {
		continueButton.click();
		return new BookSeat(driver);
	}
	
}
