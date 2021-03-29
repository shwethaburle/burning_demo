package testSuite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Utilities.WebElements;

public class Testing_utilities
{

	WebElements util=new WebElements();
	
	@FindBy(xpath="//button[@title='Accept All']") static WebElement cookie;
	@FindBy(xpath="//a[@data-testid='open-registration-form-button']") static WebElement createacc;
	@FindBy(id="month") static WebElement month;
	
	
	@FindBy(id="customerCurrency") static WebElement custcurrency;
	
	
	@FindBy(id="firstName") static WebElement firstname;
	@FindBy(id="lastName") static WebElement lastname;
	
	@Test
	public void testing()
	{
		FirefoxDriver driver=new FirefoxDriver();
		PageFactory.initElements(driver,this);
		util.wait(driver);
		///////////////////////**************************************************
		driver.get("http://www.facebook.com");
		cookie.click();
		createacc.click();	
		try {Thread.sleep(3000);}catch(Exception e) {}
		month.click();
		try {Thread.sleep(2000);}catch(Exception e) {}
		String expmonths[]= {"Month","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		util.validate_dropdown_list(month,expmonths);
		//////////////////////*********************************************************
		
		driver.get("https://demo.nopcommerce.com/");
		String expcurrency[]= {"US Dollar","Euro"};
		util.validate_dropdown_list(custcurrency, expcurrency);
		
		///////////////////////************************************************
		
		driver.get("https://demoqa.com/automation-practice-form");
		util.typetext(firstname, "john");
		util.typetext(lastname,"smith");
		try {Thread.sleep(2000);}catch(Exception e) {}
		driver.close();
		
		
		
	}
}
