package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class test {
	WebDriver driver;
	@BeforeClass
	public void  setUp() {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://www.w3schools.com/howto/howto_css_register_form.asp");
		 driver.manage().window().maximize();
		
	}
	@Test(dataProvider="registration")
	public void registrationform(String email,String password,String repeatpassword,String expectedOutcome)
	{
	driver.findElement(By.id("main")).sendKeys(email );
	driver.findElement(By.id("")).sendKeys(password);
	driver.findElement(By.linkText("Repeat Password")).sendKeys(repeatpassword);
	driver.findElement(By.linkText("Register")).click();
	
	
	if(expectedOutcome.equals("success")) {
		Assert.assertTrue(driver.getTitle().contains("Welcome") || driver.getTitle().contains("Dashboard"));
	} else if (expectedOutcome.equals("failure")) {
        // Check for error messages
        Assert.assertTrue(driver.findElement(By.id("errorMessage")).isDisplayed());;
	}
}
	@DataProvider(name="registration")
	public Object[][] registration()
	{
		return new Object[][]
				{
			{"akn12@gmail.com","abc1234","abc1234"},
			{"anjukrihna@gmail.com","wbc1233","wbc1233"}
			
				};
				
	}
}
	
	


