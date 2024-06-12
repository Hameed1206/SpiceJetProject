package spice_jet_package;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_package.BaseClass;

public class SeatMap extends BaseClass{

	@FindBy (xpath = "//div[@data-testid ='seat-map-columns']/following-sibling::div[1]/div//*[@id=\"spiceMaxSeata\"]/ancestor::div[1]")
	List<WebElement> spiceMaxSeat;
	
	@FindBy (xpath = "//div[@data-testid ='seat-map-columns']/following-sibling::div[1]/div//*[@id=\"normalSeata\"]/ancestor::div[1]")
	List<WebElement> normalSeat;
	
	@FindBy (xpath = "//div[@data-testid ='seat-map-columns']/following-sibling::div[1]/div//*[@id=\"preferredSeata\"]/ancestor::div[1]")
	List<WebElement> preferredSeat;
	
	@FindBy (xpath = "//div[text()='Skip']/parent::div")
	WebElement popUp;
	
	@FindBy (xpath = "//div[text() = 'Seat Selection']/parent::div/div/div/div[2]//span")
	WebElement verifySeat;
	
	@FindBy (xpath = "//div[text() = 'Seat Selection']/parent::div/div/div/div[5]/div")
	WebElement returnSeat;
	
	@FindBy (xpath = "//div[text() ='Select Meals']/parent::div")
	WebElement selectMealsButton;
	
	@FindBy (xpath = "//div[text() ='Done']/parent::div")
	WebElement doneBtn;

	public SeatMap(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public SeatMap getSpiceMaxSeat() {
		spiceMaxSeat.get(1).click();
		if (popUp.isDisplayed()) {
			popUp.click();
		}
		return this;
	}
	public SeatMap getNormalSeat() {
		normalSeat.get(3).click();
		if (popUp.isDisplayed()) {
			popUp.click();
		}
		return this;
	}
	public SeatMap getPreferredSeat() {
		preferredSeat.get(3).click();
		if (popUp.isDisplayed()) {
			popUp.click();
		}
		return this;
	}
	public SeatMap getVerifySeat() {
		return this;
	}
	public SeatMap getReturnSeat() {
		returnSeat.click();
		return this;
	}
	public MealsPage getSmealsBtn() {
		selectMealsButton.click();
		return new MealsPage(driver);
	}
	public BookSeat getDoneBtn() {
		doneBtn.click();
		return new BookSeat(driver);
	}
	
	
}
