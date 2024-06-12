package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

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

	@FindBy (xpath = "//div[@class='container']/div[2]/div/div[1]/div[7]/div[1]/a/button")
	WebElement submitBtn;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//SignUp page fill form
	public SignUpPage getNameTitle(String title) {
		explicitWait(nameTitle);
		selectFromDropDown(nameTitle, title);
		return this;
	}
	public SignUpPage getfName(String fname) {
		explicitWait(fName);
		fName.sendKeys(fname);
		return this;
	}
	public SignUpPage getlName(String lname) {
		explicitWait(lName);
		lName.sendKeys(lname);
		return this;
	}
	public SignUpPage getCountry(String countryName) {
		explicitWait(country);
		selectFromDropDown(country, countryName);
		return this;
	}
	public SignUpPage getDob(String month, String year, String date) {
		explicitWait(dob);
		dob.click();
		selectFromDropDown(dobMonth, month);
		explicitWait(dobYear);
		selectFromDropDown(dobYear, year);
		driver.findElement(By.xpath("//div[text() = '"+date+"']")).click();	
		return this;
	}
	public SignUpPage getPhNo(String phone) {
		explicitWait(phNo);
		phNo.sendKeys(phone);
		return this;
	}
	public SignUpPage getEmail(String emailID) {
		explicitWait(email);
		moveToParticularElement(email);
		email.sendKeys(emailID);
		return this;
	}
	public SignUpPage getPassword(String pass) {
		explicitWait(password);
		password.sendKeys(pass);
		cPassword.sendKeys(pass);
		return this;
	}
	public SignUpPage getSubmitBtn() throws InterruptedException {
		moveToParticularElement(tncClick);
		tncClick.click();
		explicitWait(submitBtn);
		submitBtn.click();
		return this;
	}
}
