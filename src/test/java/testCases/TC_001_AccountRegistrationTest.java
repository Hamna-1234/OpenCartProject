package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import testBase.BaseClass;
import pageObjects.*;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	public static String email;
	
	@Test(groups= {"Regression","Master"})
	void test_registrationaccount() throws InterruptedException
	{
		
		Homepage hp=new Homepage(driver);
		hp.Clickregister();
	    logger.info("****TC_001_AccountRegistrationTest has started*****");
		AccountRegistrationpage regpage=new AccountRegistrationpage(driver);
		
		regpage.setfirstname("sree");
		logger.info("First name is entered");
		
		 regpage.setlastname("lakshmi");
		 logger.info("Last name is entered");
		 
		 email=randomstring();
		 regpage.setemail(email+"@gmail.com");
		 logger.info("email is entered");
		 
		 regpage.setpassword(rb.getString("password"));
		 logger.info("Password is set");
		 
		 regpage.confirmpassword(rb.getString("password"));
		 logger.info("password is confirmed");
		 
		 regpage.clickRegister();
		 logger.info("Register button clicked");
		 
		 String message=regpage.Getconfirmationmsg();
		 
		 Assert.assertEquals(message,"Your registration completed");
		 logger.info("registered");

		    logger.info("****TC_001_AccountRegistrationTest has finished*****");
		 Thread.sleep(3000);
		
	}
	
	
	

}
