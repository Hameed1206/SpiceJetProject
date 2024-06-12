package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

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
	
	@FindBy (xpath = "//div[@data-testid='common-proceed-to-pay']")
	WebElement proceedPayment;
	
	@FindBy (xpath = "//div[text() = 'Payment Failed']")
	WebElement errorMsg1;
	
	@FindBy (xpath = "//div[text() = 'Payment Failed']//following-sibling::div")
	WebElement errorMsg2;
	
	@FindBy (xpath = "//div[contains(text() , 'Sorry!')]/parent::div/preceding-sibling::div/div")
	WebElement errorMsg3;
	
	@FindBy (xpath = "//div[contains(text() , 'Sorry!')]")
	WebElement errorMsg4;
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    // fill card details and proceed
	public PaymentPage getCardNo(String cardno, String name) {
		driver.switchTo().frame(frame1);
		cardNo.sendKeys(cardno);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(frame2);
		cardName.sendKeys(name);
		driver.switchTo().defaultContent();
		return this;
	}
	public PaymentPage getExpMonth(String month, String year) {
		driver.switchTo().frame(frame3);
		expMonth.sendKeys(month);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(frame4);
		expYear.sendKeys(year);
		driver.switchTo().defaultContent();
		return this;
	}
	public PaymentPage getCvvNo(String cvv) {
		driver.switchTo().frame(frame5);
		cvvNo.sendKeys(cvv);
		driver.switchTo().defaultContent();
		return this;
	}
	public PaymentPage getProceedPayment() {
		proceedPayment.click();
		try {
			System.out.println(errorMsg1.getText());
			System.out.println(errorMsg2.getText());
		} catch (Exception e) {
			System.out.println(errorMsg3.getText());
			System.out.println(errorMsg4.getText());
		}
		return this;
	}
	
}
