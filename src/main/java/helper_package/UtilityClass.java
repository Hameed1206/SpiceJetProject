package helper_package;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class UtilityClass {

public static WebDriver driver;
	
	public static void launch() {
		ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", java.util.Collections.singletonMap("profile.default_content_setting_values.javascript", 1));
		driver = new ChromeDriver(options);
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));	
	}
	public static void explicitWait(WebElement element) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void selectFromDropDown(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	public static void windowSwitch() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String string : allWindow) {
			if (!string.equals(parentWindow)) {
				driver.switchTo().window(string);
			}   }
	}
	public static void moveToParticularElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	public static void captureScreenshot() throws IOException {
		TakesScreenshot tk = (TakesScreenshot)driver;
		File file = tk.getScreenshotAs(OutputType.FILE);
		File path = new File("C:\\Users\\91936\\eclipse-workspace\\Spice_Jet\\target\\snap.jpg");
		Files.copy(file, path);
	}
	public void javaScriptSendkeys(WebElement refName, String value) {
		JavascriptExecutor jks = (JavascriptExecutor) driver;
		jks.executeScript("arguments[0].setAttribute('value', arguments[1]);", refName, value);
		
	}
	public void javaScriptClick(WebElement refName) {
		JavascriptExecutor jks = (JavascriptExecutor) driver;
		jks.executeScript("arguments[0].click;", refName);
	}
	public static void JavaScriptExecutorScrollDown(WebElement element) {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
