package Tst;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Bse.Base;
import Bse.PageObjectMotorCycle;

public class TestingMotorCycle extends Base {
	WebDriver driver;
	PageObjectMotorCycle pg;
	@BeforeTest
	public void intitlise() throws IOException {
		driver=driverSetup();
	}
	@Test
	public void siteTwoWheeler() {
		pg= new PageObjectMotorCycle(driver);
		driver.get("http://sampleapp.tricentis.com/102/");
		driver.findElement(By.id("nav_motorcycle")).click();
		pg.vehicleData();
		pg.insurantData();
		pg.productData();
		pg.priceOption();
		pg.sendQuote();
	}
	@AfterTest
	public void close() {
		//driver.close();
	}
}
