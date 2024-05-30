package Booking;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class Flightbooking {
	    @Test
		public static void Booking()
		{
			WebDriverManager.chromedriver().setup();
			ChromeDriver bookingflight=new ChromeDriver();	
			String url="https://blazedemo.com/";
		    bookingflight.get(url);
		    Select dep=new Select(bookingflight.findElement(By.xpath("//select[@name='fromPort']")));
		    dep.selectByValue("Paris");
		    Select dest=new Select(bookingflight.findElement(By.xpath("//select[@name='toPort']")));
		    dest.selectByIndex(2);
		    //Finds flight
		    bookingflight.findElement(By.xpath("//input[@type='submit']")).click();
		    //select flight
		    bookingflight.findElement(By.xpath("(//input[@type='submit'])[4]")).click();
		    //add details
		    bookingflight.findElement(By.id("inputName")).sendKeys("Hishila");
		    bookingflight.findElement(By.id("address")).sendKeys("Patan");
		    bookingflight.findElement(By.id("city")).sendKeys("Lalitpur");
		    bookingflight.findElement(By.id("state")).sendKeys("Bagmati");
		    bookingflight.findElement(By.id("zipCode")).sendKeys("3579");
		    Select cardtype= new Select(bookingflight.findElement(By.id("cardType")));
		    cardtype.selectByVisibleText("American Express");
		    bookingflight.findElement(By.id("creditCardNumber")).sendKeys("236789754");
		    bookingflight.findElement(By.id("creditCardMonth")).sendKeys("05");
		    bookingflight.findElement(By.id("creditCardYear")).sendKeys("2022");
		    bookingflight.findElement(By.id("rememberMe")).click();
		    bookingflight.findElement(By.id("nameOnCard")).sendKeys("Test User");
		    bookingflight.findElement(By.id("rememberMe")).click();
		    bookingflight.findElement(By.xpath("//input[@type='submit']")).click();
		    WebDriverWait wait = new WebDriverWait(bookingflight,Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Thank you for your purchase today!')]")));
		    
		    }
		
	}
