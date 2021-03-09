
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class mainTest {
	static WebDriver driver;
	temperaturePagePOM tempP = new temperaturePagePOM(driver);
	lengthPagePOM lenP = new lengthPagePOM(driver);
	weightPagePOM weigP = new weightPagePOM(driver);
	
	
	
	@BeforeClass
	public static void initDriver() {
		
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");		
		ChromeOptions options = new ChromeOptions();		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	
	 @Test
	 public void test1() throws IOException, InterruptedException {
		System.out.println("-----------------Test1 -----------------");
		System.out.println("-enter to https://www.metric-conversions.org/");
		
		driver.get("https://www.metric-conversions.org/");			
		
		String res = tempP.convertCelsiusToFahrenheitTemperature("20");
		tempP.checkActualWithExpectedResult(res,"68.0");			 
	 } 
	 
	 @Test
	 public void test2() throws IOException, InterruptedException {
		System.out.println("-----------------Test2 -----------------");
		System.out.println("-enter to https://www.metric-conversions.org/");
		
		driver.get("https://www.metric-conversions.org/");			
		
		String res = lenP.convertMeterToFeetLength("10");
		lenP.checkActualWithExpectedResult(res,"32");			 
	 } 
	 
	 @Test
	 public void test3() throws IOException, InterruptedException {
		System.out.println("-----------------Test3 -----------------");
		System.out.println("-enter to https://www.metric-conversions.org/");
		
		driver.get("https://www.metric-conversions.org/");			
		
		String res = weigP.convertOuncesToGramsWeight("10");
		weigP.checkActualWithExpectedResult(res,"283");			 
	 } 
  
	
	 
	 @AfterClass
	 public static void tearDown() {
		driver.quit();
	 }
	
}
