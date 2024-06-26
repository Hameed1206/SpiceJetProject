package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class BookSeat extends BaseClass{

	@FindBy (id = "at_addon_close_icon")
	WebElement addClose;
	
	@FindBy (xpath = "//div[text() = 'Choose Your Seat']/parent::div/parent::div/parent::div/following-sibling::div/div")
	WebElement addButtonToSelectSeat;
	
	@FindBy (xpath = "//div[@id='addons-container']/following-sibling::div[1]/div/div/div[4]")
	WebElement continueBtn;
	
	@FindBy (xpath ="//div[text()='Information']/following-sibling::div")
	WebElement specialFarePopUp;
	
	public BookSeat(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SeatMap getAddClose1() {
		if (addClose.isDisplayed()) {
			addClose.click();
			addButtonToSelectSeat.click();
		} else {
			addButtonToSelectSeat.click();
		}		
		return new SeatMap(driver);
	}

	public SeatMap getAddClose() {
		if (specialFarePopUp.isDisplayed()) {
			specialFarePopUp.click();
		}
		if (addClose.isDisplayed()) {
			addClose.click();
			addButtonToSelectSeat.click();
		} else {
			addButtonToSelectSeat.click();
		}		
		return new SeatMap(driver);
	}


	public PaymentPage getContinueBtn() throws InterruptedException {
		//other wait functions not resolved the issue
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//div[text() = 'Investors']"));
		JavaScriptExecutorScrollDown(element);
		if (addClose.isDisplayed()) {
			addClose.click();
			continueBtn.click();
		} else {
			continueBtn.click();
		}	
		return new PaymentPage(driver);
	}
	
}
