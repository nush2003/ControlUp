import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class temperaturePagePOM {
	WebDriver driver;
	WebDriverWait wait;
	
	
	By temperatureButton = By.xpath("/html/body/div[1]/div[2]/a[1]");
	By celsiusLink = By.xpath("/html/body/div[1]/div[2]/nav/a[3]");	
	                         
	By celsiusToFahrenheitLink = By.xpath("/html/body/div[1]/div[3]/nav/a[4]");
	By convertInputField = By.id("argumentConv");
	By answerField = By.id("answer");
	
	
	
    public temperaturePagePOM(WebDriver driver) {		
		this.driver = driver;
		
	}
    
    public String convertCelsiusToFahrenheitTemperature(String celTemp){    	
    	wait = new WebDriverWait(driver,10);
    	
    	System.out.println("-go to 'Celsius To Fahrenheit' conversion");    	
		driver.findElement(temperatureButton).click();
		
    	wait.until(ExpectedConditions.elementToBeClickable(celsiusLink));
		driver.findElement(celsiusLink).click();
		
	 	wait.until(ExpectedConditions.elementToBeClickable(celsiusToFahrenheitLink));
		driver.findElement(celsiusToFahrenheitLink).click();
		
		System.out.println("-write temperature '"+celTemp+"' in Celsius to be converted"); 
		wait.until(ExpectedConditions.elementToBeClickable(convertInputField));
		driver.findElement(convertInputField).sendKeys(celTemp);
    	
    	return driver.findElement(answerField).getText();    	
    }
    
    public void checkActualWithExpectedResult(String actualRes, String expectRes ) {
    	System.out.println("-check the correctness of conversion from Celsius To Fahrenheit");
    	
    	String[] temp = actualRes.split("= ");
    	
    	Assert.assertTrue("Verification Failed: The conversion from Celsius To Fahrenheit is wrong! "  ,temp[1].substring(0, 4).equals(expectRes));	
    }
    
    
   
}
