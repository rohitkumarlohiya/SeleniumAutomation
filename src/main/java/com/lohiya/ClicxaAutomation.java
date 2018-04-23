package com.lohiya;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClicxaAutomation {

	public static void main(String[] args) {

		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\ADMIN\\Downloads\\geckodriver.exe");
		
		String baseURL = "http://www.clicxa.com/login/index.html";
        String email = "letsgetviralagain";
        String password = "Test@1243";

        WebDriver driver;
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        //Goes to SellerCloud website
        driver.get(baseURL);
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        driver.findElement(By.name("username")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("Submit")).click();



        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='nav']/div/div[1]/div/div[4]/div/a/div[1]")));
        
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Clicxa Grid Ads")));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div[1]/div[2]/div/nav/ul/li[1]/a")));
        driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div[2]/div/nav/ul/li[1]/a")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/header/div[1]/div[2]/div/nav/ul/li[1]/ul/li[4]/a")));
        
        driver.findElement(By.xpath("/html/body/div/header/div[1]/div[2]/div/nav/ul/li[1]/ul/li[4]/a")).click();
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section[2]/div/div[2]/aside/div/div/div[2]/div[4]/div[1]/div[1]/div/table/tbody/tr[9]/td[12]")));
        
        driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div[2]/aside/div/div/div[2]/div[4]/div[1]/div[1]/div/table/tbody/tr[9]/td[12]")).click();
        
        
        
       // driver.findElement(By.xpath("/html/body/div/header/div[1]/div[2]/div/nav/ul/li[1]/ul/li[4]/a")).sendKeys(Keys.ENTER);
        
//Enter code here to perform functions after login
		
		
		
		/*WebDriver driver = new FirefoxDriver();

		//driver.get("http://learn-automation.com");
		driver.get("http://www.clicxa.com/login/index.html");

		//driver.quit();
*/	}

}
