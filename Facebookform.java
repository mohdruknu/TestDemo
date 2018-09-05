package TcsForm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Facebookform { // This class is using main method for email validation

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver(); // launch Chrome  Driver
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");  // launches facebook
		
		driver.findElement(By.id("u_0_j")).sendKeys("Ruknuddin"); // Using id as locator
		
		driver.findElement(By.name("lastname")).sendKeys("Mohammed"); // using Name as locator
		
		
		//driver.findElement(By.name("reg_email__")).sendKeys("ruknuddin_mohd@yahoo.com");
		
		//String actual_error=driver.findElement(By.xpath("//input[@id=\"u_0_o\"]")).getText();
		
		//String expected_error="please enter your email address";
		
		//Assert.assertTrue(actual_error.contains("Please enter your email"));
		
		/**JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		driver.findElement(By.xpath("//input[@id=\"u_0_o\"]")).sendKeys("asd");
		
		Object s=js.executeScript("return document.getElementById(\"u_0_o\").validity.valid");
		
		System.out.println(s);
		
		driver.findElement(By.xpath("//input[@id=\"u_0_o\"]")).sendKeys("asd@gmail.com");
		
		s=js.executeScript("return document.getElementById(\"u_0_o\").validity.valid");
		
		System.out.println(s);**/
		
		driver.findElement(By.xpath("//input[@id=\"u_0_o\"]")).sendKeys("@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"u_0_v\"]")).sendKeys("accountfb");
        Select day = new Select(driver.findElement(By.name("birthday_day")));
		
		day.selectByIndex(6);
		
		Select month = new Select(driver.findElement(By.xpath("//Select[@title=\"Month\"]")));
		
		month.selectByVisibleText("Sept");
		
		Select year = new Select(driver.findElement(By.xpath("//Select[@title=\"Year\"]")));
		
		year.selectByValue("1987");
		
		driver.findElement(By.xpath("//input[@id=\"u_0_a\"]")).click();
		
		driver.findElement(By.xpath("//button[@id=\"u_0_11\"]")).click();
		
		String actual_error = driver.findElement(By.xpath("//input[@id=\"u_0_o\"]")).getText();
		String expected_error = "Please enter a valid mobile number or email address.";
		
	     Assert.assertTrue(actual_error.contains("Please enter a valid mobile number or email address."));// if this assertion wants to be true then we need to give expected value in the parameter
		
		driver.quit();
		
	}

}
