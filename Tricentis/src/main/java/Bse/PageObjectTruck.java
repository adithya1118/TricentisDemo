package Bse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageObjectTruck {
	WebDriver driver;
	WebDriverWait wait;

	public PageObjectTruck(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
	}

	Base bs;
	Select sl;
	Actions ac;
	@FindBy(id = "nav_truck")
	WebElement truck;

	@FindBy(id = "make")
	WebElement make;

	@FindBy(id = "engineperformance")
	WebElement engineperformance;

	@FindBy(id = "dateofmanufacture")
	WebElement dateofmanufacture;

	@FindBy(id = "numberofseats")
	WebElement numberofseats;

	@FindBy(id = "fuel")
	WebElement fuel;

	@FindBy(id = "payload")
	WebElement payload;

	@FindBy(id = "totalweight")
	WebElement totalweight;

	@FindBy(id = "listprice")
	WebElement listprice;

	@FindBy(id = "licenseplatenumber")
	WebElement licenseplatenumber;

	@FindBy(id = "annualmileage")
	WebElement annualmileage;

	@FindBy(id = "nextenterinsurantdata")
	WebElement nextenterinsurantdata;

	@FindBy(id = "enterinsurantdata")
	WebElement enterinsurantdata;

	@FindBy(id = "firstname")
	WebElement firstname;

	@FindBy(id = "lastname")
	WebElement lastname;

	@FindBy(id = "birthdate")
	WebElement birthdate;

	@FindBy(id = "gendermale")
	WebElement gendermale;

	@FindBy(id = "genderfemale")
	WebElement genderfemale;

	@FindBy(id = "streetaddress")
	WebElement streetaddress;

	@FindBy(id = "country")
	WebElement country;

	@FindBy(id = "zipcode")
	WebElement zipcode;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "occupation")
	WebElement occupation;

	@FindBy(id = "speeding")
	WebElement speeding;

	@FindBy(id = "bungeejumping")
	WebElement bungeejumping;

	@FindBy(id = "cliffdiving")
	WebElement cliffdiving;

	@FindBy(id = "skydiving")
	WebElement skydiving;

	@FindBy(id = "other")
	WebElement other;

	@FindBy(id = "website")
	WebElement website;

	@FindBy(id = "picturecontainer")
	WebElement picturecontainer;

	@FindBy(id = "nextenterproductdata")
	WebElement nextenterproductdata;

	@FindBy(id = "enterproductdata")
	WebElement enterproductdata;

	@FindBy(id = "startdate")
	WebElement startdate;

	@FindBy(id = "insurancesum")
	WebElement insurancesum;

	@FindBy(id = "damageinsurance")
	WebElement damageinsurance;

	@FindBy(id = "EuroProtection")
	WebElement EuroProtection;

	@FindBy(id = "LegalDefenseInsurance")
	WebElement LegalDefenseInsurance;

	@FindBy(id = "nextselectpriceoption")
	WebElement nextselectpriceoption;

	@FindBy(id = "selectultimate")
	WebElement selectultimate;

	@FindBy(id = "nextsendquote")
	WebElement nextsendquote;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "phone")
	WebElement phone;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "confirmpassword")
	WebElement confirmpassword;

	@FindBy(id = "Comments")
	WebElement Comments;

	@FindBy(id = "sendemail")
	WebElement sendemail;

	@FindBy(xpath = "//h2")
	WebElement message;

	@FindBy(xpath = "//button[text()='No']")
	WebElement No;

	public void openSite(String car, String performance, String dom, String noseats, String fueltype, String payld,
			String ttlweight, String lstprice, String plateno, String milage) {
		driver.get("http://sampleapp.tricentis.com/102/");
		truck.click();
		sl = new Select(make);
		sl.selectByVisibleText(car);
		engineperformance.sendKeys(performance);
		dateofmanufacture.sendKeys(dom);
		sl = new Select(numberofseats);
		sl.selectByVisibleText(noseats);
		sl = new Select(fuel);
		sl.selectByVisibleText(fueltype);
		payload.sendKeys(payld);
		totalweight.sendKeys(ttlweight);
		listprice.sendKeys(lstprice);
		licenseplatenumber.sendKeys(plateno);
		annualmileage.sendKeys(milage);
		nextenterinsurantdata.click();
	}

	public void insurantData(String frstname, String lstname, String dob, String gender, String adress, String contry,
			String zpcode, String cty, String occu, String webste, String fileloc) {
		enterinsurantdata.click();
		firstname.sendKeys(frstname);
		lastname.sendKeys(lstname);
		birthdate.sendKeys(dob);
		ac = new Actions(driver);

		if (gender.equalsIgnoreCase("male")) {
			ac.click(gendermale).build().perform();
		} else {
			ac.click(genderfemale).build().perform();
		}

		streetaddress.sendKeys(adress);
		sl = new Select(country);
		sl.selectByVisibleText(contry);
		zipcode.sendKeys(zpcode);
		city.sendKeys(cty);
		sl = new Select(occupation);
		sl.selectByVisibleText(occu);
		ac.click(speeding).build().perform();
		website.sendKeys(webste);
		picturecontainer.sendKeys(System.getProperty("user.dir") + "\\Screenshot_20230124_111632.png");
		nextenterproductdata.click();
	}

	public void productData(String strdate, String sum, String dmg, String EuroProtection) {
		// enterproductdata.click();
		startdate.sendKeys(strdate);
		sl = new Select(insurancesum);
		sl.selectByValue(sum);
		sl = new Select(damageinsurance);
		sl.selectByVisibleText(dmg);
		ac.click(driver.findElement(By.id(EuroProtection))).build().perform();

		nextselectpriceoption.click();
	}

	public void priceoption() {
		ac.click(selectultimate).build().perform();
		nextsendquote.click();
	}

	public WebElement sendQuaote(String emailid, String phno, String userid, String pass, String confpass, String comment,
			String vld) {
		email.sendKeys(emailid);
		phone.sendKeys(phno);
		username.sendKeys(userid);
		password.sendKeys(pass);
		confirmpassword.sendKeys(confpass);
		Comments.sendKeys(comment);
		sendemail.click();
		return message;
		/*
		 * boolean A = message.isDisplayed(); boolean B = vld.equals("invalid");
		 * Assert.assertTrue( (A && B) || (!A && !B));
		 */
		
		// No.click();
	}
	public void clickNo() {
		No.click();
	}
}
