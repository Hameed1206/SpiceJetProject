package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class MealsPage extends BaseClass{

	@FindBy (xpath = "//div[text() ='Done']/parent::div")
	WebElement doneBtn;
//(//div[contains(text() , 'DINNER')])[2]/ancestor::div[2]/following-sibling::div[1]//div[contains(text(),'Chicken')]
	@FindBy(xpath = "(//div[@data-testid='meals-filter'])[2]/ancestor::div[4]/div[2]/div[1]/div/div[2]/div/div/div/div[1]/div")
	WebElement chickenDinner;
	
	
	public MealsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public MealsPage getChickenDinner() {
		chickenDinner.click();
		return this;
	}
	public BookSeat getDoneBtn() {
		doneBtn.click();
		return new BookSeat(driver);
	}
}
