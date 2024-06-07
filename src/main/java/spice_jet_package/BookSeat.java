package spice_jet_package;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;

public class BookSeat extends BaseClass{

	@FindBy (id = "at_addon_close_icon")
	WebElement addClose;
	
	@FindBy (xpath = "//div[text() = 'Choose Your Seat']/parent::div/parent::div/parent::div/following-sibling::div/div")
	WebElement addButtonToSelectSeat;
	
	@FindBy (xpath = "//div[text() = 'Continue']")
	List<WebElement> continueBtn;
	
	public BookSeat(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
