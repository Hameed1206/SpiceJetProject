package spice_jet_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;

public class Homepage extends BaseClass{

	@FindBy(xpath = "//div[text() = 'Login']")
	WebElement loginLink;
	
	@FindBy(xpath = "//div[text() = 'Signup']")
	WebElement signUpLink;
	
	@FindBy (xpath = "//div[text() = 'Email']")
	WebElement emailCircle;
	
	@FindBy (css = "input[type='email']")
	WebElement emailBox;
	
	@FindBy (css = "input[type='password']")
	WebElement passBox;
	
	@FindBy (xpath = "//div[text() = 'LOGIN']")
	WebElement loginBtn; 
	
	@FindBy (xpath = "//div[text() = 'Invalid Username/Password']")
	WebElement errorMsg;
	
	@FindBy (xpath = "//div[text() = 'Invalid Username/Password']//following-sibling::div")
	WebElement errorMsg2;
	
	@FindBy (xpath = "//div[text() = 'round trip']")
	WebElement roundTrip;
	
	@FindBy(xpath = "//div[text() = 'From']//parent::div/div/input")
	WebElement fromBox;
	
	@FindBy(xpath = "//div[text() = 'To']//parent::div/div/input")
	WebElement toBox;
	
	@FindBy(xpath = "(//div[contains(text() , 'June')]//parent::div//parent::div//div[text() = '21'])[1]")
	WebElement depDate;
	
	@FindBy(xpath = "(//div[contains(text() , 'June')]//parent::div//parent::div//div[text() = '21'])[1]")
	WebElement ReturnDate;
	
	@FindBy(xpath = "//div[text()='Passengers']")
	WebElement noOfPassengers;
	
	@FindBy(xpath = "//div[text() = 'Search Flight']")
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
		emailCircle.click();
		return this;
	}

	public Homepage getEmailBox() {
		emailBox.sendKeys("Hameed@gamil.com");
		return this;
	}

	public Homepage getPassBox() {
		passBox.sendKeys("Hameed12");
		return this;
	}

	public Homepage getLoginBtn() {
		//javaScriptClick(loginBtn);
		explicitWait(loginBtn);
		loginBtn.click();
		return this;
	}

	public Homepage getErrorMsg() {
		System.out.println(errorMsg.getText());
		return this;
	}

	public Homepage getErrorMsg2() {
		System.out.println(errorMsg2.getText());
		return this;
	}
	
	
}
