package Utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElements
{

	public void validate_dropdown_list(WebElement listbox,String exp[])
	{
		int flag=0;
		List<WebElement> lst=listbox.findElements(By.tagName("option"));
	
		for(int i=0;i<lst.size();i++)
		{			
		  if(lst.get(i).getText().matches(exp[i])==false)
		  {
		      System.out.println("value in the list not matching  "+exp[i]);
		      flag=1;
		  }
		}
		if(flag==0)
		{
			System.out.println("All values in the list are matching");
			for(String s:exp)
			{
				System.out.print(s+" : ");
			}
			System.out.println();
			System.out.println("=========================");
		}
	}	
	public void typetext(WebElement editbox,String inputtext)
	{
		  int flag=0;
		  try
		  {
		  if(editbox.isDisplayed()==false)
		     flag=1;
		  if(editbox.isEnabled()==false)
		     flag=1;
		  }
		  catch(Exception e) 
		  {
			System.out.println("The editbox is either not displayed / not editable to type value :"+inputtext);   
		  }
		  
		  if(flag==0)
		  {
		    editbox.clear();
		    editbox.sendKeys(inputtext);
		  }
	}
	public void wait(WebDriver driver)
	{
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
}
