package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModule.HomePageObjects;
import PageObjectModule.RegisterPageObjects;
import Resources.BaseClass;
import Resources.CommonMethods;
import Resources.Constants;

public class RegisterTestCases extends BaseClass {

	@Test
	public void verifyRegsiterationWithValidData() throws IOException, InterruptedException {
		
		String emailID = getRandomEmailID();  //testuer_chrome_1233444@example.com


		HomePageObjects hpo = new HomePageObjects(driver);
		hpo.clickOnMyAccount().click();
		hpo.clickOnregsiter().click();

		RegisterPageObjects rpo = new RegisterPageObjects(driver);
	    CommonMethods.handleExplictWait(driver, 2, rpo.getfirstName());
	    
	    
		rpo.getfirstName().sendKeys(Constants.firstName);
		rpo.getLastName().sendKeys(Constants.lastName);
		rpo.geteMail().sendKeys(emailID);
		rpo.getTelephone().sendKeys(Constants.telephone);
		
	  //  commonMethods.handleExplictWait(driver, 5, rpo.getPassword());

		rpo.getPassword().sendKeys(Constants.password);
		

		rpo.getPasswordConfirm().sendKeys(Constants.password);
		rpo.getSubscribe().click();
		rpo.getPrivacyPolicy().click();
		rpo.getContinue().click();
		CommonMethods.handleAssertion(rpo.accountCreationSuccess().getText(), Constants.suucefullActCreation);
		
	}

	@Test
	public void verifyRegsiterationWithBlankData() throws IOException, InterruptedException {

		HomePageObjects hpo = new HomePageObjects(driver);
		hpo.clickOnMyAccount().click();
		hpo.clickOnregsiter().click();

		RegisterPageObjects rpo = new RegisterPageObjects(driver);

		rpo.getContinue().click();
		
		Thread.sleep(2000);
		
	

		String firsNameWaringExpected = "First Name must be between 1 and 32 characters!";
		String firsNameWaringActual = rpo.getfirstNameWarnig().getText();		
		CommonMethods.handleAssertion(firsNameWaringActual, firsNameWaringExpected);

		String lastNameWaringExpected = "Last Name must be between 1 and 32 characters!";
		String lastNameWaringActual = rpo.getLastNameWarnig().getText();

		CommonMethods.handleAssertion(lastNameWaringActual, lastNameWaringExpected);

		String MailWarnigExpected = "E-Mail Address does not appear to be valid!";
		String MailWarnigActual = rpo.geteMailWarnig().getText();
		CommonMethods.handleAssertion(MailWarnigActual, MailWarnigExpected);

		String TelephoneWaringExpected = "Telephone must be between 3 and 32 characters!";
		String TelephoneWaringActual = rpo.getTelephoneWarnig().getText();
		CommonMethods.handleAssertion(TelephoneWaringActual, TelephoneWaringExpected);

		String PasswordWaringExpected = "Password must be between 4 and 20 characters!";
		String PasswordWaringActual = rpo.getPasswordWarnig().getText();
		CommonMethods.handleAssertion(PasswordWaringActual, PasswordWaringExpected);

		String privacypolicyWarningExpected = "Warning: You must agree to the Privacy Policy!";
		String privacypolicyWarningWaringActual = rpo.getPrivacyPolicyWaring().getText();
		CommonMethods.handleAssertion(privacypolicyWarningWaringActual, privacypolicyWarningExpected);

	}

}
