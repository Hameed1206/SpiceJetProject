package test_execution_package;

import org.testng.annotations.Test;

import base_package.BaseClass;
import spice_jet_package.Homepage;

public class TestExecution extends BaseClass{

	@Test
	public void registration() throws InterruptedException {
		Homepage hPage = new Homepage(driver);
		//hPage.getSignUpLink().getNameTitle().getfName().getlName().getCountry().getDob(12).getPhNo().getEmail().getPassword().getSubmitBtn();
		hPage.getLoginLink().getEmailCircle().getEmailBox().getPassBox().getLoginBtn().getErrorMsg().getErrorMsg2();
	}
}
