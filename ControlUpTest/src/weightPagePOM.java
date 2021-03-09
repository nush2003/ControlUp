import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class weightPagePOM {
	WebDriver driver;
	WebDriverWait wait;
	
	
	By weightButton = By.xpath("/html/body/div[1]/div[2]/a[2]");
	By ouncesLink = By.xpath("/html/body/div[1]/div[2]/nav/a[5]");	
	                         
	By ouncesToGramsLink = By.xpath("/html/body/div[1]/div[3]/nav/a[6]");
	By convertInputField = By.id("argumentConv");
	By answerField = By.id("answer");
	
	
	
    public weightPagePOM(WebDriver driver) {		
		this.driver = driver;		
	}
    
    public String convertOuncesToGramsWeight(String ounTemp){    	
    	wait = new WebDriverWait(driver,10);
    	
    	System.out.println("-go to 'ounces to grams' conversion");    	
		driver.findElement(weightButton).click();
		
    	wait.until(ExpectedConditions.elementToBeClickable(ouncesLink));
		driver.findElement(ouncesLink).click();
		
	 	wait.until(ExpectedConditions.elementToBeClickable(ouncesToGramsLink));
		driver.findElement(ouncesToGramsLink).click();
		
		System.out.println("-write weight '"+ounTemp+"' in ounces to be converted"); 
		wait.until(ExpectedConditions.elementToBeClickable(convertInputField));
		driver.findElement(convertInputField).sendKeys(ounTemp);
		
		    	
    	return driver.findElement(answerField).getText();    	
    }
    
    public void checkActualWithExpectedResult(String actualRes, String expectRes ) {
    	System.out.println("-check the correctness of conversion from ounces to grams");
    	
    	String[] temp = actualRes.split("= ");   
    	
       	Assert.assertTrue("Verification Failed: The conversion ounces to grams is wrong! "  ,temp[1].substring(0, 3).equals(expectRes));	
    }

}
