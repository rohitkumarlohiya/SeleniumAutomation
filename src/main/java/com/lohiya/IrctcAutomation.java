package com.lohiya;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IrctcAutomation {

	public static void main(String[] args) {
		WebDriver driver = null;
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\ADMIN\\Downloads\\geckodriver.exe");
		try {
		String baseURL = "https://www.irctc.co.in";
        String email = "rklohiya";
        String password = "lohiya";

        
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        //Goes to SellerCloud website
        driver.get(baseURL);
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 2000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("j_username")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("j_password")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nlpAnswer")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginbutton")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("captchaImg")));

        driver.findElement(By.name("j_username")).sendKeys(email);
        driver.findElement(By.name("j_password")).sendKeys(password);
       // driver.findElement(By.id("loginbutton")).click();
        
        driver.findElement(By.id("nlpAnswer"));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jpform:fromStation")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jpform:toStation")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jpform:journeyDateInputDate")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jpform:jpsubmit")));
        
        String fromStation = "H NIZAMUDDIN - NZM";
        String toStation = "MAU RANIPUR - MRPR";
        String journeyDate = "24-04-2018";
        
        driver.findElement(By.id("jpform:fromStation")).sendKeys(fromStation);
        driver.findElement(By.id("jpform:toStation")).sendKeys(toStation);
        driver.findElement(By.id("jpform:journeyDateInputDate")).sendKeys(journeyDate);
        driver.findElement(By.id("jpform:jpsubmit")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("quota")));
        
        driver.findElement(By.xpath("//input[@name='quota' and @value='TQ']")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cllink-12448-SL-3")));
        
        driver.findElement(By.id("cllink-12448-SL-3")).click();
        
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("12448-SL-TQ-0")));
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Book Now")));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"12448-SL-TQ-0\"]")));
        
        driver.findElement(By.xpath("//*[@id=\"12448-SL-TQ-0\"]")).click();
        
      //  driver.findElement(By.id("12448-SL-TQ-0")).click();
      //  driver.findElement(By.linkText("Book Now")).sendKeys(Keys.ENTER);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addPassengerForm:psdetail:0:p1665421764")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addPassengerForm:psdetail:0:psgnAge")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addPassengerForm:psdetail:0:psgnGender")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addPassengerForm:psdetail:0:berthChoice")));
        
        
		String name = "Rohit Lohiya";
		String age = "29";
		String gender = "Male";
		String birth = "UPPER";
        
        driver.findElement(By.id("addPassengerForm:psdetail:0:p1665421764")).sendKeys(name);
        driver.findElement(By.id("addPassengerForm:psdetail:0:psgnAge")).sendKeys(age);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		}
		finally {
			driver.quit();
		}
	}
}
