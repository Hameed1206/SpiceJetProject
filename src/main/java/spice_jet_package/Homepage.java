package spice_jet_package;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base_package.BaseClass;

public class Homepage extends BaseClass{

	@FindBy(xpath = "//div[text() = 'Login']")
	WebElement loginLink;
	
	@FindBy(xpath = "//div[text() = 'Signup']")
	WebElement signUpLink;
	
	@FindBy (xpath = "//div[text() = 'Email']/parent::div")
	WebElement emailCircle;
	
	@FindBy (css = "input[type='email']")
	WebElement emailBox;
	
	@FindBy(css ="input[data-testid='user-mobileno-input-box']")
	WebElement phNoBox;
	
	@FindBy (css = "input[type='password']")
	WebElement passBox;
	
	@FindBy (xpath = "//div[@data-testid='login-cta']")
	WebElement loginBtn; 
	
	@FindBy (xpath = "//div[@id='main-container']/div/div[1]/div[2]/div/div/div[3]/div/div[2]/div[1]")
	WebElement userLoginName;
	
	@FindBy (xpath = "//div[text() = 'Invalid Username/Password']")
	WebElement errorMsg;
	
	@FindBy (xpath = "//div[text() = 'Invalid Username/Password']//following-sibling::div")
	WebElement errorMsg2;
	
	@FindBy (css = "div[data-testid='check-in-horizontal-nav-tabs']")
	WebElement checkInLink;
	
	@FindBy (css = "div[data-testid='flight status-horizontal-nav-tabs']")
	WebElement flightStausLink;
	
	@FindBy (css = "div[data-testid='manage booking-horizontal-nav-tabs']")
	WebElement manageBooking;
	
	@FindBy (xpath = "//div[text() = 'round trip']")
	WebElement roundTrip;

	@FindBy(xpath = "//div[text() = 'From']//parent::div/div/input")
	WebElement fromBox;
	
	@FindBy(xpath = "//div[text() = 'To']//parent::div/div/input")
	WebElement toBox;
	
	@FindBy (css = "div[data-testid='departure-date-dropdown-label-test-id']")
	WebElement depDateBox;
	
	@FindBy (css = "div[data-testid='return-date-dropdown-label-test-id']")
	WebElement returnDateBox;
	
	@FindBy(xpath = "//div[@id='react-root']/div/div/div/div[3]/div[2]/div[7]/div[2]/div[@data-testid ='home-page-flight-cta']")
	WebElement searchButton;

	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SignUpPage getSignUpLink() {
		signUpLink.click();
		windowSwitch();
		return new SignUpPage(driver);
	}
	
	public Homepage getLoginLink() {
		loginLink.click();
		return this;
	}
	public Homepage getEmailCircle() {
		explicitWait(emailCircle);
		emailCircle.click();
		return this;
	}
	public Homepage getEmailBox(String email) {
		emailBox.sendKeys(email);
		return this;
	}
	public Homepage getPhNoBox(String phone) {
		phNoBox.sendKeys(phone);
		return this;
	}
	public Homepage getPassBox(String pass) {
		passBox.sendKeys(pass);
		return this;
	}
	public Homepage getLoginBtn() {
		explicitWait(loginBtn);
		loginBtn.click();
		return this;
	}
	public String getLoginResult() {
		try {
			String error1 = errorMsg.getText();
			String error2 = errorMsg2.getText();
			System.out.println(error1);
			System.out.println(error2);
			return error1;
		} catch (Exception e) {
			String userName = userLoginName.getText();
			System.out.println(userName+" logged in succesfully");
			return userName;
		}
	}
	
	public Homepage getCheckInLink() {
		Assert.assertTrue(checkInLink.isDisplayed(), "Check In field is not displayed");
		Assert.assertTrue(checkInLink.isEnabled(), "Check In field is not enabled");
		System.out.println("Check In Field is Available and enabled");
		return this;
	}
	public Homepage getFlightStausLink() {
		Assert.assertTrue(flightStausLink.isDisplayed(), "Flight status field is not displayed");
		Assert.assertTrue(flightStausLink.isEnabled(), "Flight status field is not enabled");
		System.out.println("Flight status Field is Available and enabled");
		return this;
	}
	public Homepage getManageBooking() {
		Assert.assertTrue(manageBooking.isDisplayed(), "Manage booking field is not displayed");
		Assert.assertTrue(manageBooking.isEnabled(), "Manage booking field is not enabled");
		System.out.println("Manage booking Field is Available and enabled");
		return this;
	}

	public Homepage getRoundTrip() {
		roundTrip.click();
		return this;
	}
	public Homepage getFromBox() {
		fromBox.sendKeys("Chennai");
		return this;
	}
	public Homepage getToBox() {
		toBox.clear();
		toBox.sendKeys("Delhi");
		return this;
	}
	public Homepage getChooseDate(String month, int date) {
		WebElement element = driver.findElement(By.xpath("(//div[contains(text() , '"+month+"')]//parent::div//parent::div//div[text() = '"+date+"'])[1]"));
		element.click();
		return this;
	}
	public FlightResultPage getSearchButton() {
		searchButton.click();
		return new FlightResultPage(driver);
	}
	
}
