package com.lohiya;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcAutomation {

	public static void main(String[] args) {
		WebDriver driver = null;
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\ADMIN\\Downloads\\geckodriver.exe");		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\rlohiy\\Downloads\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		//This call replace the above call to manually download and set system property to use geckodriver
		WebDriverManager.firefoxdriver().setup();
		
		try {
		String baseURL = "https://www.irctc.co.in";
        String email = "";
        String password = "";
        
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get(baseURL);
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 200);
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("j_username")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("j_password")));
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.id("cimage")),
				ExpectedConditions.visibilityOfElementLocated(By.id("nlpAnswer"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginbutton")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("captchaImg")));

        driver.findElement(By.name("j_username")).sendKeys(email);
        driver.findElement(By.name("j_password")).sendKeys(password);
       // driver.findElement(By.id("loginbutton")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jpform:fromStation")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jpform:toStation")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jpform:journeyDateInputDate")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jpform:jpsubmit")));
        
        String fromStation = "H NIZAMUDDIN - NZM";
        String toStation = "MAU RANIPUR - MRPR";
        String journeyDate = "25-04-2018";
        
        driver.findElement(By.id("jpform:fromStation")).sendKeys(fromStation);
        driver.findElement(By.id("jpform:toStation")).sendKeys(toStation);
        driver.findElement(By.id("jpform:journeyDateInputDate")).sendKeys(journeyDate);
        driver.findElement(By.id("jpform:jpsubmit")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("quota")));
        
        driver.findElement(By.xpath("//input[@name='quota' and @value='TQ']")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cllink-12448-SL-3")));
        
        driver.findElement(By.id("cllink-12448-SL-3")).click();
        
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("12448-SL-TQ-0")));
        
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("12448-SL-TQ-0"));
		js.executeScript("arguments[0].click();", element);

		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[starts-with(@id,'addPassengerForm:psdetail:0:p')]")));
		/* wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[starts-with(@id,'addPassengerForm:psdetail:0:psgnAge')]")));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[starts-with(@id,'addPassengerForm:psdetail:0:psgnGender')]")));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[starts-with(@id,'addPassengerForm:psdetail:0:berthChoice')]")));
		 */
		String name = "Rohit Lohiya";
		String age = "29";
		String gender = "Male";
		String birth = "UPPER";
		
		 driver.findElement(By.xpath("//input[starts-with(@id,'addPassengerForm:psdetail:0:p')]")).sendKeys(name);
         driver.findElement(By.xpath("//input[starts-with(@id,'addPassengerForm:psdetail:0:psgnAge')]")).sendKeys(age);
         new Select(driver.findElement(By.id("addPassengerForm:psdetail:0:psgnGender"))).selectByVisibleText(gender);
         new Select(driver.findElement(By.id("addPassengerForm:psdetail:0:berthChoice"))).selectByVisibleText(birth);
         
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("PREFERRED")));
         
         driver.findElement(By.xpath("//input[@name='PREFERRED' and @value='60']")).click();
         
         driver.findElement(By.id("validate")).click();
         
         
        
		Thread.sleep(100000);
        
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}
}
