package test_execution_package;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base_package.BaseClass;
import spice_jet_package.Homepage;

public class TestExecution extends BaseClass{

	//DataProvider method having information about test datas in excel
		@DataProvider (name="SignUp function")
		public Object[][] signUpTestData() throws IOException {
			Object[][] datas = TestData.signUpTestDatas();
			return datas;
		}
		@DataProvider (name="SignIn with Phone No")
		public Object[] signInTestDataP() throws IOException {
			Object[] datas = TestData.SignInWithPhoneNo();
			return datas;
		}
		@DataProvider (name="SignIn with Email")
		public Object[][] signInTestDataE() throws IOException {
			Object[][] datas = TestData.SignInWithEmail();
			return datas;
		}
		@DataProvider (name="Booking Details")
		public Object[][] bookinDetailsInfo() throws IOException {
			Object[][] datas = TestData.bookingDetails();
			return datas;
		}
		
	//Validate SignUp function
	@Test(dataProvider = "SignUp function" , priority = 1)
	public void validateSignUpFunction 
	(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) throws InterruptedException {
		Homepage hPage = new Homepage(driver);
		System.out.println(s5+" "+s6+" "+s7);
		try{  
		hPage.getSignUpLink().getNameTitle(s1).getfName(s2).getlName(s3).getCountry(s4).getDob(s5, s6, s7).getPhNo(s8).getEmail(s9).getPassword(s10).getSubmitBtn();
	   } catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage() +" "+ e.getClass());
	}
	}
	//Validate SignUp function
	@Test(dataProvider = "SignUp function" , priority = 2)
	public void validateSignUpFunction2
	(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) throws InterruptedException{
		Homepage hPage = new Homepage(driver);
		try {
		hPage.getSignUpLink().getPassword(s10).getEmail(s9).getNameTitle(s1).getfName(s2).getlName(s3).getCountry(s4).getDob(s5, s6, s7).getPhNo(s8).getSubmitBtn();
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage() +" "+ e.getClass());
	}
	}
	//Positive Scenario Validate Sign In Function Using Phone no
	@Parameters({"phoneNoV","passwordV"})
	@Test(priority = 3)
	public void validateSignInFunctionUsingPhNoWithValidCredentials(String s1, String s2) {
		Homepage hPage = new Homepage(driver);
		try {
		hPage.getLoginLink().getPhNoBox(s1).getPassBox(s2).getLoginBtn();
		Assert.assertEquals(hPage.getLoginResult(), "Hi Hameed");
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage() +" "+ e.getClass());
	}
	}
	//Positive Scenario Validate Sign In Function Using Email
	@Parameters({"emailV","passwordV"})
	@Test(priority = 4)
	public void validateSignInFunctionUsingEmailWithValidCredentials(String s1, String s2) {
		Homepage hPage = new Homepage(driver);
		try {
		hPage.getLoginLink().getEmailCircle().getEmailBox(s1).getPassBox(s2).getLoginBtn();
		Assert.assertEquals(hPage.getLoginResult(), "Hi Hameed");
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage() +" "+ e.getClass());
	}
	}
	//Negative Scenario Validate Sign In Function Using Phone no
	@Parameters({"phoneNoIV","passwordIV"})
	@Test(priority = 5)
	public void validateSignInFunctionUsingPhNoWithInValidCredentials(String s1, String s2) {
		Homepage hPage = new Homepage(driver);
		try {
		hPage.getLoginLink().getPhNoBox(s1).getPassBox(s2).getLoginBtn();
		Assert.assertEquals(hPage.getLoginResult(), "Invalid Username/Password");
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage() +" "+ e.getClass());
	}
	}
	//Negative Scenario Validate Sign In Function Using Email
	@Parameters({"emailIV","passwordIV"})
	@Test(priority = 6)
	public void validateSignInFunctionUsingEmailWithInValidCredentials(String s1, String s2) {
		Homepage hPage = new Homepage(driver);
		try {
		hPage.getLoginLink().getEmailCircle().getEmailBox(s1).getPassBox(s2).getLoginBtn();
		Assert.assertEquals(hPage.getLoginResult(), "Invalid Username/Password");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
	}	
	//Validating Sign In function using decision table technique
	@Test(dataProvider = "SignIn with Phone No" ,priority = 7)
	public void validateSignInFunctionUsingPhNo(String s1, String s2, String s3) {
		Homepage hPage = new Homepage(driver);
		try {
		System.out.println(s1);
		hPage.getLoginLink().getPhNoBox(s2).getPassBox(s3).getLoginBtn().getLoginResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
	}
	@Test(dataProvider = "SignIn with Email" ,priority = 8)
	public void validateSignInFunctionUsingEmail(String s1, String s2, String s3) {
		Homepage hPage = new Homepage(driver);
		try {
		System.out.println(s1);
		hPage.getLoginLink().getEmailCircle().getEmailBox(s2).getPassBox(s3).getLoginBtn().getLoginResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
	}	
	// Validating the Check In , Flight status and manage booking fields are available
	@Test(priority = 9)
	public void validateFieldsAvailability() {
		Homepage hPage = new Homepage(driver);
		try {
		hPage.getCheckInLink().getFlightStausLink().getManageBooking();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
	}
	//Validating Flight search for one way trip
	@Test(priority = 10)
	public void validateSearchFlightforOnewayTrip() {
		Homepage hPage = new Homepage(driver);
		try {
		hPage.getFromBox().getToBox().getChooseDate("June" , 21).getSearchButton().getCurrentURL();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
	}
	//Validating Flight search for round trip
	@Test(priority = 11)
	public void validateSearchFlightforRoundTrip() {
		Homepage hPage = new Homepage(driver);
		try {
		hPage.getRoundTrip().getFromBox().getToBox().getChooseDate("June" , 21).getChooseDate("July" , 22).getSearchButton().getCurrentURL();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
	}
	//validating to choose a flight and proceed
	@Test(priority = 12)
	public void validateChooseFlight() throws InterruptedException {
		Homepage hPage = new Homepage(driver);
		try {
		hPage.getFromBox().getToBox().getChooseDate("June" , 21).getSearchButton().getChooseFlightFare().getContinueButton();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
	}
	@Test(dataProvider = "Booking Details" , priority = 13)
	public void registration
	(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, String s14) throws InterruptedException {
		Homepage hPage = new Homepage(driver);
		try {
		hPage.getFromBox().getToBox().getChooseDate("June" , 21).getSearchButton().getContinueButton().getContactFName(s1).getContactLName(s2)
		.getContactNo(s3).getEmailID(s4).getCityName(s5).getPassengerFName(s6).getPassengerLName(s7).getPassengerPhNo(s8).getContinueButton().getAddClose()
		.getPreferredSeat().getDoneBtn().getContinueBtn().getCardNo(s10, s11).getExpMonth(s12, s13).getCvvNo(s14).getProceedPayment();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
		//hPage.getRoundTrip().getFromBox().getToBox().getChooseDate("June" , 21).getChooseDate("July" , 25).getSearchButton().getContinueButton().getContactFName().getContactLName()
	    //.getContactNo().getEmailID().getCityName().getPassengerFName().getPassengerLName().getPassengerPhNo().getContinueButton().getAddClose()
		// .getPreferredSeat().getReturnSeat().getPreferredSeat().getDoneBtn().getContinueBtn().getCardNo().getExpMonth().getCvvNo().getProceedPayment();
	    //getSmealsBtn().getChickenDinner()
		//.getChooseFlightFare().getChooseFlightFare(2, 2).getChooseFlightFare(4, 3)
	}
	@Test(dataProvider = "Booking Details" , priority = 14)
	public void registration1
	(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, String s14) throws InterruptedException {
		Homepage hPage = new Homepage(driver);
		try {
		hPage.getRoundTrip().getFromBox().getToBox().getChooseDate("June" , 21).getChooseDate("July" , 25).getSearchButton().getContinueButton().getContactFName(s1).getContactLName(s2)
		.getContactNo(s3).getEmailID(s4).getCityName(s5).getPassengerFName(s6).getPassengerLName(s7).getPassengerPhNo(s8).getContinueButton().getAddClose()
		.getPreferredSeat().getReturnSeat().getPreferredSeat().getDoneBtn().getContinueBtn().getCardNo(s10, s11).getExpMonth(s12, s13).getCvvNo(s14).getProceedPayment();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
		//hPage.getRoundTrip().getFromBox().getToBox().getChooseDate("June" , 21).getChooseDate("July" , 25).getSearchButton().getContinueButton().getContactFName().getContactLName()
	    //.getContactNo().getEmailID().getCityName().getPassengerFName().getPassengerLName().getPassengerPhNo().getContinueButton().getAddClose()
		// .getPreferredSeat().getReturnSeat().getPreferredSeat().getDoneBtn().getContinueBtn().getCardNo().getExpMonth().getCvvNo().getProceedPayment();
	    //getSmealsBtn().getChickenDinner()
		//.getChooseFlightFare().getChooseFlightFare(2, 2).getChooseFlightFare(4, 3)
	}
}
