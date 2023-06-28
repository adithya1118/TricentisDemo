package Tst;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;

import Bse.Base;
import Bse.PageObjectTruck;

public class TestingTruck extends Base {
	public WebDriver driver;
	Base bs;
	Select sl;
	Actions ac;
	PageObjectTruck pg;
	WebDriverWait wait;
	SoftAssert ar;
	ExtentReports extent;
	@BeforeTest
	public void intitlise() throws IOException {
		driver = driverSetup();
	}

	@Test(priority = 1, dataProvider = "loginTest")
	public void siteTruck(String arr[]/*String car, String performance, String dom, String noseats, String fueltype, String payld,
			String ttlweight, String lstprice, String plateno, String milage, String frstname, String lstname,
			String dob, String gender, String adress, String contry, String zpcode, String cty, String occu,
			String webste, String fileloc, String strdate, String sum, String dmg, String EuroProtection,
			String emailid, String phno, String userid, String pass, String confpass, String comment, String vld*/) {

		pg = new PageObjectTruck(driver);
		pg.openSite(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],arr[9]/*car, performance, dom, noseats, fueltype, payld, ttlweight, lstprice, plateno, milage*/);
		pg.insurantData(arr[10],arr[11],arr[12],arr[13],arr[14],arr[15],arr[16],arr[17],arr[18],arr[19],arr[20]/*frstname, lstname, dob, gender, adress, contry, zpcode, cty, occu, webste, fileloc*/);
		pg.productData(arr[21],arr[22],arr[23],arr[24]/*strdate, sum, dmg, EuroProtection*/);
		pg.priceoption();
		ar=new SoftAssert();
		WebElement message=pg.sendQuaote(arr[25],arr[26],arr[27],arr[28],arr[29],arr[30],arr[31]/*emailid, phno, userid, pass, confpass, comment, vld*/);
		if (arr[31].equals("valid")) {
			ar.assertFalse(message.isDisplayed(),"Test Failed due to display of message for valid e-mail id");
		} else {
			ar.assertTrue(message.isDisplayed(),"Test Failed due to not display of message for invalid e-mail id");
			wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(message));
			pg.clickNo();
		}
		ar.assertAll();
	}

	@DataProvider(name = "loginTest")
	public String[][] getData() throws IOException {
		String path = ".\\DataSheet.xlsx";
		Xssfsheet xl = new Xssfsheet(path);
		int totalrows = xl.getRowcount("Sheet2");
		int totalcolmns = xl.getCellCount("Sheet2", 1);
		//System.out.println(totalrows + " " + totalcolmns);// 2,3
		String loginData[][] = new String[totalrows][totalcolmns];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcolmns; j++) {
				loginData[i-1][j]=xl.getCellData("Sheet2", i, j);
			}
		}
		return loginData;
	}

	@AfterTest
	public void closing() {
		driver.close();
	}
}
