package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityClass {

public static WebDriver driver;
	
	public static void launch(String browser) {
		if(browser.equals("Edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		} else if (browser.equals("FireFox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		} else {
		driver = new ChromeDriver();	
		}
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
	public static void windowSwitchBack() {
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String string : allWindow) {
			if (string.equals(parentWindow)) {
				driver.switchTo().window(string);
			}   }
	}
	public static int findElementIndexByText(List<WebElement> elements, String text) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)) {
                return i;
            }
        }   return -1;  // Return -1 if not found
    }
	public static void moveToParticularElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	public static XSSFSheet readValueFromExcel(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\91936\\eclipse-workspace\\Spice_Jet\\ExcelFile\\Spice_Jet_App_Testing.xlsx");
		XSSFWorkbook wBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = wBook.getSheet(sheetName);
		return sheet;
	}
	public static String captureScreenshot() throws IOException {
		TakesScreenshot tk = (TakesScreenshot)driver;
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		File file = tk.getScreenshotAs(OutputType.FILE);
		long timeMillis = System.currentTimeMillis();
		String title = driver.getTitle();
		String snapPath = "C:\\Users\\91936\\eclipse-workspace\\Spice_Jet\\target\\"+title+"-"+timeMillis+".jpg";
		File path = new File(snapPath);
		Files.copy(file, path);
		return snapPath;
	}
	public void javaScriptSendkeys(WebElement refName, String value) {
		JavascriptExecutor jks = (JavascriptExecutor) driver;
		jks.executeScript("arguments[0].setAttribute('value', arguments[1]);", refName, value);
		
	}
	public void javaScriptClick(WebElement refName) {
		JavascriptExecutor jks = (JavascriptExecutor) driver;
		jks.executeScript("arguments[0].click();", refName);
	}
	public static void JavaScriptExecutorScrollDown(WebElement element) {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void closeBrowser() {
		 driver.quit();
	}
}
