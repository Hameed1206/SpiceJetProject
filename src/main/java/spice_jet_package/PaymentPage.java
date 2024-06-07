package spice_jet_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;

public class PaymentPage extends BaseClass{

	@FindBy (id = "at_addon_close_icon")
	WebElement addClose; 
	
	@FindBy (className = "card_number_iframe")
	WebElement frame1;
	
	@FindBy (id = "card_number")
	WebElement cardNo;
	
	@FindBy (className = "name_on_card_iframe")
	WebElement frame2;
	
	@FindBy (id = "name_on_card")
	WebElement cardName;
	
	@FindBy (className = "card_exp_month_iframe")
	WebElement frame3;
	
	@FindBy (id = "card_exp_month")
	WebElement expMonth;
	
	@FindBy (className = "card_exp_year_iframe")
	WebElement frame4;
	
	@FindBy (id = "card_exp_year")
	WebElement expYear;
	
	@FindBy (className = "security_code_iframe")
	WebElement frame5;
	
	@FindBy (id = "security_code")
	WebElement cvvNo;
	
	@FindBy (xpath = "//div[text()='Proceed to pay']")
	WebElement proceedPayment;
	
	@FindBy (xpath = "//div[text() = 'Payment Failed']")
	WebElement errorMsg1;
	
	@FindBy (xpath = "//div[text() = 'Payment Failed']//following-sibling::div")
	WebElement errorMsg2;
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
