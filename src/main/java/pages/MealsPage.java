package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class MealsPage extends BaseClass{

	@FindBy (xpath = "//div[text() ='Done']/parent::div")
	WebElement doneBtn;

	@FindBy(xpath = "(//div[@data-testid='meals-filter'])[2]/ancestor::div[4]/div[2]/div[1]/div/div[2]/div/div/div/div[1]/div")
	WebElement meals;
	
	
	public MealsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public MealsPage getChickenDinner() {
		meals.click();
		return this;
	}
	public BookSeat getDoneBtn() {
		doneBtn.click();
		return new BookSeat(driver);
	}
}
