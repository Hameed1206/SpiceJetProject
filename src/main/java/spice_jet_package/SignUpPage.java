package spice_jet_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;

public class SignUpPage extends BaseClass {

	@FindBy (xpath = "//label[text() = 'Title']//following-sibling::select")
	WebElement nameTitle;
	
	@FindBy (id = "first_name")
	WebElement fName;
	
	@FindBy (id = "last_name")
	WebElement lName;
	
	@FindBy (xpath = "//label[contains(text() , 'Country')]//following-sibling::select")
	WebElement country;
	
	@FindBy (id = "dobDate")
	WebElement dob;
	
	@FindBy (xpath = "//select[contains(@class , 'month-select')]")
	WebElement dobMonth;
	
	@FindBy (xpath = "//select[contains(@class , 'year-select')]")
	WebElement dobYear;

	@FindBy (xpath = "//div[text() = '21']")
	WebElement dobDate;
	
	@FindBy (css = "input[type='tel']")
	WebElement phNo;
	
	@FindBy (css = "input#email_id")
	WebElement email;
	
	@FindBy (id = "new-password")
	WebElement password;
	
	@FindBy (id = "c-password")
	WebElement cPassword;
	
	@FindBy (id = "defaultCheck1")
	WebElement tncClick;
	
	@FindBy (css = "button[type='button']")
	WebElement submitBtn;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SignUpPage getNameTitle() {
		explicitWait(nameTitle);
		selectFromDropDown(nameTitle, "Mr");
		return this;
	}

	public SignUpPage getfName() {
		explicitWait(fName);
		fName.sendKeys("Hameed");
		return this;
	}

	public SignUpPage getlName() {
		explicitWait(lName);
		lName.sendKeys("Hussain");
		return this;
	}

	public SignUpPage getCountry() {
		explicitWait(country);
		selectFromDropDown(country, "Fiji");
		return this;
	}

	public SignUpPage getDob(int dobDate) {
		explicitWait(dob);
		dob.click();
		selectFromDropDown(dobMonth, "June");
		selectFromDropDown(dobYear, "2000");
		driver.findElement(By.xpath("//div[text() = '"+dobDate+"']")).click();	
		return this;
	}

	public SignUpPage getPhNo() {
		explicitWait(phNo);
		phNo.sendKeys("9551231008");
		return this;
	}

	public SignUpPage getEmail() throws InterruptedException {
		//explicitWait(email);
		Thread.sleep(5000);
		javaScriptSendkeys(email , "Hameed@Yahoo.com");
		//email.sendKeys("Hameed@Yahoo.com");
		return this;
	}

	public SignUpPage getPassword() {
		//explicitWait(password);
		password.sendKeys("Hameed$123");
		cPassword.sendKeys("Hameed$123");
		return this;
	}

	public SignUpPage getSubmitBtn() {
		//explicitWait(tncClick);
		moveToParticularElement(tncClick);
		tncClick.click();
		explicitWait(submitBtn);
		javaScriptClick(submitBtn);
		//submitBtn.click();
		return this;
	}
	
	
	
	
}
