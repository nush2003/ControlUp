import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class lengthPagePOM {

	WebDriver driver;
	WebDriverWait wait;
	
	
	By lengthButton = By.xpath("/html/body/div[1]/div[2]/a[3]");
	By metersLink = By.xpath("/html/body/div[1]/div[2]/nav/a[5]");	
	                         
	By metersToFeetLink = By.xpath("/html/body/div[1]/div[3]/nav/a[8]");
	By convertInputField = By.id("argumentConv");
	By answerField = By.id("answer");
	
	
	
    public lengthPagePOM(WebDriver driver) {		
		this.driver = driver;		
	}
    
    public String convertMeterToFeetLength(String metTemp){    	
    	wait = new WebDriverWait(driver,10);
    	
    	System.out.println("-go to 'meters To feet' conversion");    	
		driver.findElement(lengthButton).click();
		
    	wait.until(ExpectedConditions.elementToBeClickable(metersLink));
		driver.findElement(metersLink).click();
		
	 	wait.until(ExpectedConditions.elementToBeClickable(metersToFeetLink));
		driver.findElement(metersToFeetLink).click();
		
		System.out.println("-write length '"+metTemp+"' in meters to be converted"); 
		wait.until(ExpectedConditions.elementToBeClickable(convertInputField));
		driver.findElement(convertInputField).sendKeys(metTemp);
    	
    	return driver.findElement(answerField).getText();    	
    }
    
    public void checkActualWithExpectedResult(String actualRes, String expectRes ) {
    	System.out.println("-check the correctness of conversion from meters To feet");
    	
    	String[] temp = actualRes.split("= ");    
    	
    	Assert.assertTrue("Verification Failed: The conversion from meters To feet is wrong! "  ,temp[1].substring(0, 2).equals(expectRes));	
    }
}
