package Bse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectMotorCycle {
	WebDriver driver;
	WebDriverWait wait;
	public PageObjectMotorCycle(WebDriver d) {
		this.driver=d;
		PageFactory.initElements(d, this);
	}
	Base bs;
	Select sl;
	Actions ac;
	@FindBy(id="make")
	WebElement make;
	
	@FindBy(id="model")
	WebElement model;
	
	@FindBy(id="cylindercapacity")
	WebElement cylindercapacity;
	
	@FindBy(id="engineperformance")
	WebElement engineperformance;
	
	@FindBy(id="dateofmanufacture")
	WebElement dateofmanufacture;
	
	@FindBy(id="numberofseatsmotorcycle")
	WebElement numberofseatsmotorcycle;
	
	@FindBy(id="listprice")
	WebElement listprice;
	
	@FindBy(id="annualmileage")
	WebElement annualmileage;
	
	@FindBy(id="nextenterinsurantdata")
	WebElement nextenterinsurantdata;
	
	@FindBy(id="firstname")
	WebElement firstname;
	
	@FindBy(id="lastname")
	WebElement lastname;
	
	@FindBy(id="birthdate")
	WebElement birthdate;
	@FindBy(id="gendermale")
	WebElement gendermale;
	@FindBy(id="genderfemale")
	WebElement genderfemale;
	@FindBy(id="streetaddress")
	WebElement streetaddress;
	@FindBy(id="country")
	WebElement country;
	@FindBy(id="zipcode")
	WebElement zipcode;
	@FindBy(id="city")
	WebElement city;
	@FindBy(id="occupation")
	WebElement occupation;
	@FindBy(id="skydiving")
	WebElement skydiving;
	@FindBy(id="website")
	WebElement website;
	@FindBy(id="picturecontainer")
	WebElement picturecontainer;
	@FindBy(id="nextenterproductdata")
	WebElement 	nextenterproductdata;
	@FindBy(id="startdate")
	WebElement 	startdate;
	@FindBy(id="insurancesum")
	WebElement 	insurancesum;
	@FindBy(id="damageinsurance")
	WebElement 	damageinsurance;
	@FindBy(id="EuroProtection")
	WebElement 	EuroProtection;
	@FindBy(id="nextselectpriceoption")
	WebElement 	nextselectpriceoption;
	@FindBy(id="selectultimate")
	WebElement 	selectultimate;
	@FindBy(id="nextsendquote")
	WebElement 	nextsendquote;
	@FindBy(id="email")
	WebElement 	email;
	@FindBy(id="phone")
	WebElement 	phone;
	@FindBy(id="username")
	WebElement 	username;
	@FindBy(id="password")
	WebElement 	password;
	@FindBy(id="confirmpassword")
	WebElement 	confirmpassword;
	@FindBy(id="Comments")
	WebElement 	Comments;
	@FindBy(id="sendemail")
	WebElement 	sendemail;
	public Select selMet(WebElement ele) {
		return new Select(ele);
	}
	public void vehicleData() {
		selMet(make).selectByVisibleText("BMW");
		selMet(model).selectByVisibleText("Scooter");
		cylindercapacity.sendKeys("200");
		engineperformance.sendKeys("1000");
		dateofmanufacture.sendKeys("02/03/2000");
		selMet(numberofseatsmotorcycle).selectByVisibleText("2");
		listprice.sendKeys("572");
		annualmileage.sendKeys("234");
		nextenterinsurantdata.click();
	}
	public void insurantData() {
		ac=new Actions(driver);
		firstname.sendKeys("Adithya");
		lastname.sendKeys("Vardhan");
		birthdate.sendKeys("03/16/2000");
		ac.click(gendermale).build().perform();
		streetaddress.sendKeys("112345");
		selMet(country).selectByVisibleText("India");
		zipcode.sendKeys("500032");
		city.sendKeys("Hyderabad");
		selMet(occupation).selectByVisibleText("Employee");
		ac.click(skydiving).build().perform();
		website.sendKeys("google.com");
		picturecontainer.sendKeys(System.getProperty("user.dir") + "\\Screenshot_20230124_111632.png");
		nextenterproductdata.click();
	}
	public void productData() {
		startdate.sendKeys("09/18/2023");
		selMet(insurancesum).selectByValue("10000000");
		selMet(damageinsurance).selectByVisibleText("Full Coverage");
		ac.click(EuroProtection).build().perform();
		nextselectpriceoption.click();
   }
	public void priceOption() {
		ac.click(selectultimate).build().perform();
		nextsendquote.click();
	}
	public void sendQuote() {
		email.sendKeys("adithya@gmail.com");
		phone.sendKeys("9885147634");
		username.sendKeys("adithya");
		password.sendKeys("windows10");
		confirmpassword.sendKeys("windows10");
		Comments.sendKeys("Good");
		sendemail.click();
	}
}
