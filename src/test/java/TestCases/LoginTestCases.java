package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModule.HomePageObjects;
import PageObjectModule.LoginPageObjects;
import Resources.BaseClass;
import Resources.CommonMethods;
import Resources.Constants;


public class LoginTestCases extends BaseClass {
	
	@Test
	public void  verifyLoginWithValidData() throws IOException {
		
		String emailID = getRandomEmailID();  //testuer_chrome_1233444@example.com
		
		HomePageObjects hpo = new HomePageObjects(driver);
		hpo.clickOnMyAccount().click();
		
		hpo.clickOnlogin().click();
		
	
		LoginPageObjects lpo = new LoginPageObjects(driver);
		
		lpo.enterEmail().sendKeys(emailID);
		lpo.enterLoginPassword().sendKeys(Constants.password);
		lpo.clickOnSubmit().click();
		CommonMethods.handleAssertion(lpo.AccountLoggedin().getText(), "My Account");
	
	}
	
}
