package test;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;
import pages.Homepage;

public class TestExecution extends BaseClass{

	//All reporting variables made Instance
	ExtentSparkReporter crtreport;
	ExtentReports extent;
	ExtentTest snap;
	
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
		                                   //Constructor to invoke reporting activities
		              // We are asking report to track activities of all test and prepare a report with screenshots
		public TestExecution(String name) {
			long timeMillis = System.currentTimeMillis();
			String reportPath = "C:\\Users\\91936\\eclipse-workspace\\Spice_Jet\\target\\"+timeMillis+".html";
			crtreport = new ExtentSparkReporter(reportPath);
			crtreport.config().setReportName(name);
			crtreport.config().setDocumentTitle("Web Test Results");
			
			extent = new ExtentReports();
			extent.attachReporter(crtreport);
		}
		
	                                             //Validate SignUp function
	@Test(dataProvider = "SignUp function" , priority = 1)
	public void validateSignUpFunction 
	(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) throws InterruptedException, IOException {
		Homepage hPage = new Homepage(driver);
		TestExecution exe = new TestExecution("Validate Sign Up Function");
		snap = extent.createTest("ValidateSignUpFunction");
		try{  
		hPage.getSignUpLink().getNameTitle(s1).getfName(s2).getlName(s3).getCountry(s4).getDob(s5, s6, s7).getPhNo(s8).getEmail(s9).getPassword(s10).getSubmitBtn();
	   } catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage() +" "+ e.getClass());
	}
		snap.addScreenCaptureFromPath(captureScreenshot(), "ValidateSignUpFunction");
		snap.log(Status.PASS, "Validate Sign Up Function");
		extent.flush();
	}
	                                           //Validate SignUp function
	@Test(dataProvider = "SignUp function" , priority = 2)
	public void validateSignUpFunction2
	(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) throws InterruptedException, IOException{
		Homepage hPage = new Homepage(driver);
		TestExecution exe = new TestExecution("Validate Sign Up Function");
		snap = extent.createTest("ValidateSignUpFunction");
		try {
		hPage.getSignUpLink().getPassword(s10).getEmail(s9).getNameTitle(s1).getfName(s2).getlName(s3).getCountry(s4).getDob(s5, s6, s7).getPhNo(s8).getSubmitBtn();
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage() +" "+ e.getClass());
	}
		snap.addScreenCaptureFromPath(captureScreenshot(), "ValidateSignUpFunction");
		snap.log(Status.PASS, "Validate Sign Up Function");
		extent.flush();
	}
	                                          //Positive Scenario Validate Sign In Function Using Phone no
	@Parameters({"phoneNoV","passwordV"})
	@Test(priority = 3)
	public void validateSignInFunctionUsingPhNoWithValidCredentials(String s1, String s2) throws IOException {
		Homepage hPage = new Homepage(driver);
		TestExecution exe = new TestExecution("Validate Sign In Function");
		snap = extent.createTest("ValidateSignInFunctionUsingPhNoWithValidCredentials");
		String loginResult="";
		try {
		hPage.getLoginLink().getPhNoBox(s1).getPassBox(s2).getLoginBtn();
		loginResult = hPage.getLoginResult();
		Assert.assertEquals(loginResult, "Hi Hameed");
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage() +" "+ e.getClass());
	}
		snap.addScreenCaptureFromPath(captureScreenshot(), "ValidateSignInFunctionUsingPhNoWithValidCredentials");
		snap.log(Status.PASS, loginResult+" logged in successfully");
		extent.flush();
	}
	                                          //Positive Scenario Validate Sign In Function Using Email
	@Parameters({"emailV","passwordV"})
	@Test(priority = 4)
	public void validateSignInFunctionUsingEmailWithValidCredentials(String s1, String s2) throws IOException {
		Homepage hPage = new Homepage(driver);
		TestExecution exe = new TestExecution("Validate Sign In Function");
		snap = extent.createTest("ValidateSignInFunctionUsingEmailWithValidCredentials");
		String loginResult="";
		try {
		hPage.getLoginLink().getEmailCircle().getEmailBox(s1).getPassBox(s2).getLoginBtn();
		loginResult = hPage.getLoginResult();
		Assert.assertEquals(loginResult, "Hi Hameed");
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage() +" "+ e.getClass());
	}
		snap.addScreenCaptureFromPath(captureScreenshot(), "ValidateSignInFunctionUsingEmailWithValidCredentials");
		snap.log(Status.PASS, loginResult+" logged in successfully");
		extent.flush();
	}
	                              //Negative Scenario Validate Sign In Function Using Phone no
	@Parameters({"phoneNoIV","passwordIV"})
	@Test(priority = 5)
	public void validateSignInFunctionUsingPhNoWithInValidCredentials(String s1, String s2) throws IOException {
		Homepage hPage = new Homepage(driver);
		TestExecution exe = new TestExecution("Validate Sign In Function");
		snap = extent.createTest("ValidateSignInFunctionUsingPhNoWithInValidCredentials");
		String loginResult="";
		try {
		hPage.getLoginLink().getPhNoBox(s1).getPassBox(s2).getLoginBtn();
		loginResult = hPage.getLoginResult();
		Assert.assertEquals(loginResult, "Invalid Username/Password");
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage() +" "+ e.getClass());
	}
		snap.addScreenCaptureFromPath(captureScreenshot(), "ValidateSignInFunctionUsingPhNoWithInValidCredentials");
		snap.log(Status.PASS, loginResult);
		extent.flush();
	}
	                                    //Negative Scenario Validate Sign In Function Using Email
	@Parameters({"emailIV","passwordIV"})
	@Test(priority = 6)
	public void validateSignInFunctionUsingEmailWithInValidCredentials(String s1, String s2) throws IOException {
		Homepage hPage = new Homepage(driver);
		TestExecution exe = new TestExecution("Validate Sign In Function");
		snap = extent.createTest("ValidateSignInFunctionUsingEmailWithInValidCredentials");
		String loginResult="";
		try {
		hPage.getLoginLink().getEmailCircle().getEmailBox(s1).getPassBox(s2).getLoginBtn();
		loginResult = hPage.getLoginResult();
		Assert.assertEquals(loginResult, "Invalid Username/Password");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
		snap.addScreenCaptureFromPath(captureScreenshot(), "ValidateSignInFunctionUsingEmailWithInValidCredentials");
		snap.log(Status.PASS, loginResult);
		extent.flush();
	}	
	                                 //Validating Sign In function using decision table technique
	@Test(dataProvider = "SignIn with Phone No" ,priority = 7)
	public void validateSignInFunctionUsingPhNo(String s1, String s2, String s3) throws IOException {
		Homepage hPage = new Homepage(driver);
		TestExecution exe = new TestExecution("Validate Sign In Function");
		snap = extent.createTest("ValidateSignInFunctionUsingPhNo");
		String loginResult="";
		try {
		System.out.println(s1);
		hPage.getLoginLink().getPhNoBox(s2).getPassBox(s3).getLoginBtn();
		loginResult = hPage.getLoginResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
		snap.addScreenCaptureFromPath(captureScreenshot(), "ValidateSignInFunctionUsingPhNo");
		snap.log(Status.PASS, s1);
		snap.log(Status.PASS, loginResult);
		extent.flush();
	}
	@Test(dataProvider = "SignIn with Email" ,priority = 8)
	public void validateSignInFunctionUsingEmail(String s1, String s2, String s3) throws IOException {
		Homepage hPage = new Homepage(driver);
		TestExecution exe = new TestExecution("Validate Sign In Function");
		snap = extent.createTest("ValidateSignInFunctionUsingEmail");
		String loginResult="";
		try {
		System.out.println(s1);
		hPage.getLoginLink().getEmailCircle().getEmailBox(s2).getPassBox(s3).getLoginBtn();
		loginResult = hPage.getLoginResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
		snap.addScreenCaptureFromPath(captureScreenshot(), "ValidateSignInFunctionUsingEmail");
		snap.log(Status.PASS, s1);
		snap.log(Status.PASS, loginResult);
		extent.flush();
	}	
	
	                      // Validating the Check In , Flight status and manage booking fields are available
	@Test(priority = 9)
	public void validateFieldsAvailability() throws IOException {
		Homepage hPage = new Homepage(driver);
		TestExecution exe = new TestExecution("Validate fields availability");
		snap = extent.createTest("ValidateFieldsAvailability");
		try {
		hPage.getCheckInLink().getFlightStausLink().getManageBooking();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
		snap.addScreenCaptureFromPath(captureScreenshot(), "ValidateFieldsAvailability");
		snap.log(Status.PASS, "All Expected fields are available");
		extent.flush();
	}
	
	                                       //Validating Flight search for one way trip
	@Test(priority = 10)
	public void validateSearchFlightforOnewayTrip() throws IOException {
		Homepage hPage = new Homepage(driver);
		TestExecution exe = new TestExecution("Validate Search Flight for Oneway Trip");
		snap = extent.createTest("ValidateSearchFlightforOnewayTrip");
		try {
		hPage.getFromBox("Chennai").getToBox("Delhi").getChooseDate("June" , 21).getSearchButton().getCurrentURL();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
		snap.addScreenCaptureFromPath(captureScreenshot(), "ValidateSearchFlightforOnewayTrip");
		snap.log(Status.PASS, "Flight result page displayed");
		extent.flush();
	}
	
	                                //Validating Flight search for round trip
	@Test(priority = 11)
	public void validateSearchFlightforRoundTrip() throws IOException {
		Homepage hPage = new Homepage(driver);
		TestExecution exe = new TestExecution("Validate Search Flight for Round Trip");
		snap = extent.createTest("ValidateSearchFlightforRoundTrip");
		try {
		hPage.getRoundTrip().getFromBox("Chennai").getToBox("Delhi").getChooseDate("June" , 21).getChooseDate("July" , 22).getSearchButton().getCurrentURL();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
		snap.addScreenCaptureFromPath(captureScreenshot(), "ValidateSearchFlightforRoundTrip");
		snap.log(Status.PASS, "Flight result page displayed");
		extent.flush();
	}
	
	                                //validating to choose a flight and proceed
	@Test(priority = 12)
	public void validateChooseFlight() throws InterruptedException, IOException {
		Homepage hPage = new Homepage(driver);
		TestExecution exe = new TestExecution("Validate to choose a flight");
		snap = extent.createTest("ValidateChooseFlight");
		try {
		hPage.getFromBox("Chennai").getToBox("Delhi").getChooseDate("June" , 21).getSearchButton().getChooseFlightFareMax().getContinueButton();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
		snap.addScreenCaptureFromPath(captureScreenshot(), "ValidateChooseFlight");
		snap.log(Status.PASS, "Flight and max fare seat option selected");
		extent.flush();
	}
	
	                                      // Validate E2E Booking OneWay trip
	@Test(dataProvider = "Booking Details" , priority = 13)
	public void validateE2EBookingOneWay
	(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, String s14) throws InterruptedException, IOException {
		Homepage hPage = new Homepage(driver);
		TestExecution exe = new TestExecution("Validate E2E Booking OneWay");
		snap = extent.createTest("ValidateE2EBookingOneWay");
		try {
		hPage.getFromBox("Mumbai").getToBox("Kolkata").getChooseDate("June" , 21).getSearchButton().getChooseFlightFareSaver().getContinueButton().getContactFName(s1).getContactLName(s2)
		.getContactNo(s3).getEmailID(s4).getCountryName(s9).getCityName(s5).getPassengerFName(s6).getPassengerLName(s7).getPassengerPhNo(s8).getContinueButton().getAddClose1()
		.getPreferredSeat().getDoneBtn().getContinueBtn().getCardNo(s10, s11).getExpMonth(s12, s13).getCvvNo(s14).getProceedPayment();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
		snap.addScreenCaptureFromPath(captureScreenshot(), "ValidateE2EBookingOneWay");
		snap.log(Status.PASS, "E2E Booking succesfully completed for Oneway Trip");
		extent.flush();
	}
	
	                                      // Validate E2E Booking Round trip
	@Test(dataProvider = "Booking Details" , priority = 14)
	public void validateE2EBookingRoundTrip
	(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, String s14) throws InterruptedException, IOException {
		Homepage hPage = new Homepage(driver);
		TestExecution exe = new TestExecution("Validate E2E Booking Round Trip");
		snap = extent.createTest("ValidateE2EBookingRoundTrip");
		try {
		hPage.getRoundTrip().getFromBox("Chennai").getToBox("Delhi").getChooseDate("June" , 21).getChooseDate("July" , 25).getSearchButton().getChooseFlightFareFlex().getContinueButton().getContactFName(s1).getContactLName(s2)
		.getContactNo(s3).getEmailID(s4).getCityName(s5).getPassengerFName(s6).getPassengerLName(s7).getPassengerPhNo(s8).getContinueButton().getAddClose()
		.getPreferredSeat().getReturnSeat().getPreferredSeat().getDoneBtn().getContinueBtn().getCardNo(s10, s11).getExpMonth(s12, s13).getCvvNo(s14).getProceedPayment();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
		snap.addScreenCaptureFromPath(captureScreenshot(), "ValidateE2EBookingRoundTrip");
		snap.log(Status.PASS, "E2E Booking succesfully completed for Round Trip");
		extent.flush();
	}
}
