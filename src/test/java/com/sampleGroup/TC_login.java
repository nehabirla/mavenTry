package com.sampleGroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_login {

	@Test
	public void test()
	{
		ChromeDriver d = new ChromeDriver();
		d.get("http://newtours.demoaut.com");
		d.manage().window().maximize();
		
		//-----------------------------Test case - Login----------------------------------
		d.findElement(By.xpath("//input[@name='userName']")).sendKeys("mercury");
		d.findElement(By.xpath("//input[@name='password']")).sendKeys("mercury");
		d.findElement(By.xpath("//input[@name=\"login\"]")).click();
		d.findElement(By.xpath("//font[contains(text(),'Flight')]"));
			
		if(d.findElements(By.xpath("//font[contains(text(),'Flight')]")).size()>=1)
			System.out.println("Test Case 1 : Pass : Log in successful and navigated to correct page");	
		else
			System.out.println("Test Case 1 : Fail : Navigated to wrong page"); 
		d.findElement(By.xpath("//input[@value='oneway']")).click();
		
		Select s_passenger = new Select(d.findElement(By.xpath("//select[@name='passCount']")));
		s_passenger.selectByVisibleText("2");
		WebElement e1 =s_passenger.getFirstSelectedOption();
		String result=e1.getText().trim();
		System.out.println("Number of passenger selected"+ result);  // Question = i want result in int format.
	    	
		
		
		Select s_from_port =new Select(d.findElement(By.xpath("//select[@name='fromPort']")));
		s_from_port.selectByValue("London");
		
		Select s_from_month = new Select(d.findElement(By.xpath("//select[@name='fromMonth']")));
		s_from_month.selectByVisibleText("January");
		
		Select s_from_day = new Select(d.findElement(By.xpath("//select[@name='fromDay']")));
		s_from_day.selectByVisibleText("1");
		
		Select s_to_port =new Select(d.findElement(By.xpath("//select[@name='toPort']")));
		s_to_port.selectByVisibleText("Paris");
		
		Select s_to_month = new Select(d.findElement(By.xpath("//select[@name='toMonth']")));
		s_to_month.selectByVisibleText("January");
		
		Select s_to_day = new Select(d.findElement(By.xpath("//select[@name='toDay']")));
		s_to_day.selectByVisibleText("15");
		
		d.findElement(By.cssSelector("input[value='Business']")).click();
		
	    Select s=new Select(d.findElement(By.name("airline")));
	    s.selectByVisibleText("Unified Airlines");
	    WebElement selected_option = s.getFirstSelectedOption();
	    String selected_airline = selected_option.getText();
	    System.out.println("Selected Airline = "+ selected_airline);
	    
	    d.findElement(By.name("findFlights")).click();
	    if(d.findElements(By.xpath("//font[contains(.,'DEPART')]")).size()>=1 && d.findElements(By.xpath("//font[contains(.,'RETURN')]")).size()>=1)
		  	System.out.println("Test Case 4: Pass :Page navigated to correct page.. select Flight");
	    else
		   System.out.println("Test Case 4: Fail :Incorrect navigation");
	    
	    //d.findElement(By.xpath("//input[@name='outFlight' and @value='Unified Airlines$363$281$11:24']")).click();// Question - I want to use combination of name and contains tag which contain previous selection from previous page
	    
	    d.findElement(By.xpath("//input[@name='outFlight' and contains(@value,'"+selected_airline+"')]")).click();
	    d.findElement(By.xpath("//input[@name='inFlight' and @value='Unified Airlines$633$303$18:44']")).click();
	    d.findElement(By.xpath("//input[@name='reserveFlights']")).click(); 
	    
	    //Question - On Book a flight page - how to verify all text?
	    
	    /* if(d.findElements(By.partialLinkText('BOOK ')).size()>=1)    // Question - how to verify we are on BOOK A FLIGHT page.
	    	System.out.println("Navigated to Book  Flight Page");
	    else
	    	System.out.println("wrong Navigation"); */

	   if(d.findElements(By.xpath("//font[contains(.,'First Name:')]")).size()== Integer.parseInt(result))   //Question - how to convert text to int 
	    	System.out.println("Test Case 5: Pass : correct number of text box displayed..");    
	   else
		   System.out.println("Test Case 5: Fail : Incorrect number of text box displayed.."); 
	    
	    d.findElement(By.cssSelector("input[name='passFirst0']")).sendKeys("Neha");
	    String pass_1st_0= d.findElement(By.cssSelector("input[name='passFirst0']")).getAttribute("Value");
	    
	    d.findElement(By.cssSelector("input[name='passLast0']")).sendKeys("B");
	    String pass_last_0= d.findElement(By.cssSelector("input[name='passLast0']")).getAttribute("Value");
	        
	    Select s1 =new Select(d.findElement(By.xpath("//select[@name='pass.0.meal']")));
	    s1.selectByVisibleText("Hindu");
	    WebElement e = s1.getFirstSelectedOption();
	    String pass_0_meal = e.getText();
	    
	    
	    d.findElement(By.xpath("//input[@name='passFirst1']")).sendKeys("Raghu");
	    String pass_1st_1 = d.findElement(By.xpath("//input[@name='passFirst1']")).getAttribute("Value");
	    
	    d.findElement(By.xpath("//input[@name='passLast1']")).sendKeys("M");
	    String pass_last_1 = d.findElement(By.xpath("//input[@name='passLast1']")).getAttribute("Value");  //Question = why value inside getAttribute?
	    
		Select s2 =new Select(d.findElement(By.xpath("//select[@name='pass.1.meal']")));
		s2.selectByVisibleText("Hindu");
		String pass_1_meal=s2.getFirstSelectedOption().getText();
		
		Select credit_card_select =new Select(d.findElement(By.xpath("//select[@name='creditCard']")));
		credit_card_select.selectByVisibleText("Visa");
		d.findElement(By.xpath("//input[@name='creditnumber']")).sendKeys("1234567890");
		Select cc_exp_dt_mn =new Select(d.findElement(By.xpath("//select[@name='cc_exp_dt_mn']")));
		cc_exp_dt_mn.selectByVisibleText("03");
		Select cc_exp_dt_yr =new Select(d.findElement(By.xpath("//select[@name='cc_exp_dt_yr']")));
		cc_exp_dt_yr.selectByVisibleText("2005");
		
		d.findElement(By.xpath("//font[contains(.,'Ticketless')]/preceding-sibling::input[@name='ticketLess']")).click();
		d.findElement(By.xpath("//font[contains(.,'Same as Billing Address')]/preceding-sibling::input[@name='ticketLess']")).click();
		d.findElement(By.xpath("//input[@name='buyFlights']")).click();
		
		d.findElement(By.xpath("//img[@src='/images/forms/Logout.gif']")).click();
		
		//Question : cost and flight details check   

		d.close();
		
		
	}

}
