package SpiceJet.SpiceJet_TestNG.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import SpiceJet.SpiceJet_TestNG.utils.Constants;

public class BookPage extends BasePage {
	WebDriver driver;
	
	@FindBy(xpath="//a[@title='Flights']")
	WebElement flightsLink;
	
	@FindBy(xpath="//td/input[@type='radio' and @value='RoundTrip']")
	WebElement roundTripRadioButton;
	
	@FindBy(xpath="//div/label[contains(text(),'PASSENGERS')]")
	WebElement passengersDropdown;
	
	@FindBy(id="ctl00_mainContent_ddl_Adult")
	WebElement adultDropdown;
	
	public BookPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getSpicejetTitle()
	{
		WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_EXPLICIT_WAIT);
		wait.until(ExpectedConditions.titleContains(Constants.SPICEJET_PAGE_TITLE));
		return driver.getTitle();		
	}
	public boolean verifyFlightsLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(flightsLink));
		return flightsLink.isDisplayed();	
	}
	public void selectFlights()
	{
		WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(flightsLink));
		flightsLink.click();	
	}
	public void selectRoundTrip()
	{
		WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(roundTripRadioButton));
		roundTripRadioButton.click();	
	}
	public void selectPassengersAdult()
	{
		WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_EXPLICIT_WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(passengersDropdown));
		passengersDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(adultDropdown));
		adultDropdown.click();
		Select selectObject = new Select(adultDropdown);
		selectObject.selectByValue("2");
	}	
}
