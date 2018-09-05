package TcsForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Form {  // This class is using TestNg annotation for email validation.
	@Test(priority=0)
	public void MyTest() {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver(); // launch Chrome  Driver
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");  // launches facebook
		
		driver.findElement(By.id("u_0_j")).sendKeys("Ruknuddin"); // Using id as locator
		
		driver.findElement(By.name("lastname")).sendKeys("Mohammed"); // using Name as locator
		
		driver.findElement(By.xpath("//input[@id=\"u_0_o\"]")).sendKeys("@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"u_0_v\"]")).sendKeys("Password@123");
        Select day = new Select(driver.findElement(By.name("birthday_day")));
		
		day.selectByIndex(6);
		
		Select month = new Select(driver.findElement(By.xpath("//Select[@title=\"Month\"]")));
		
		month.selectByVisibleText("Sept");
		
		Select year = new Select(driver.findElement(By.xpath("//Select[@title=\"Year\"]")));
		
		year.selectByValue("1987");
		
		driver.findElement(By.xpath("//input[@value=\"2\"]")).click();
		
		driver.findElement(By.xpath("//button[@id=\"u_0_11\"]")).click();
		
		String actual_error = driver.findElement(By.xpath("//input[@id=\"u_0_o\"]")).getAttribute("innerHTML");
		String expected_error = "Please enter a valid mobile number or email address.";
		
     	Assert.assertTrue(actual_error.contains("asasas"));
     	
		
		driver.quit();
		
		
		
		
		

	}

}
