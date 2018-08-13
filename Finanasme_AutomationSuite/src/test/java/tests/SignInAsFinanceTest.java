package tests;

import org.testng.annotations.Test;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.SignInAsFinance;
import pages.SignInAsScm;
import utils.BrowserFactory;
import utils.ImageComparator;
import utils.dataType;

public class SignInAsFinanceTest extends BrowserFactory {

	SignInAsFinance signInAsFinance = SignInAsFinance.getInstance();
	SignInAsScm signInAsScm = SignInAsScm.getInstance();
	HomePage homePage = HomePage.getInstance();
	Map<Object, Object> elementMap, validatorDataMap;
	ImageComparator imageComparator = new ImageComparator();

	SignInAsFinanceTest() {
		elementMap = data.getDataFromSheets(dataType.Elements.toString(), this.getClass().getSimpleName().toString());
		validatorDataMap = data.getDataFromSheets(dataType.Validator.toString(),
				this.getClass().getSimpleName().toString());
		
	}
	
	@BeforeClass
	public void openURL() 
	{
		helper.openURL();	
	}	
	/*
	public void preOperations() 
	{
		signInAsFinance.signIn();	
	}*/
	
	/*@AfterMethod
	public void logOut() {
		helper.openURL();
		homePage.logOut();
	}*/
	
	@Test(description = "verify the sign In flow as Finance", testName = "verifySignInAsFinance", priority = 1)
	public void verifySignInAsFinance() 
	{
		signInAsFinance.signIn();	
	}
	
	@Test(description = "validate the signedIn user as Finance", testName = "verifySignedInUsername", priority = 2)
	public void verifySignedInUsername() 
	{
		signInAsFinance.validateSignIn("FINANCE");
	}
	
	@Test(description="Process applied loan", testName="processAppliedLoan", priority=3)
	public void processAppliedLoan()
	{
		signInAsFinance.processAppliedCurrentLoan();
	}
	
	@Test(description="validate the Account Info tab", testName="verifyContinueOnAccountInfoPage", priority=4)
	public void verifyContinueOnAccountInfoPage()
	{
		signInAsFinance.continueOnAccountInfoPage();
	}
	
	@Test(description="validate the Basic Info tab", testName="verifyContinueOnBasicInfoPage", priority=5)
	public void verifyContinueOnBasicsInfoPage()
	{
		signInAsFinance.continueOnBasicInfoPage();
	}
	
	@Test(description="validate the Finacial Info tab", testName="verifySaveAndContinueOnFinancialInfoPage", priority=6)
	public void verifySaveAndContinueOnFinancialInfoPage()
	{
		signInAsFinance.saveAndContinueOnFinancialInfoPage();		
	}
	
	@Test(description="enter the Account number under Bank Statement tab", testName="enterAccountNoUnderBankStatement", priority=7)
	public void enterAccountNoUnderBankStatement() throws InterruptedException
	{
		signInAsFinance.fillAccountNo(validatorDataMap.get("accountNo").toString());
	}
	
	@Test(description="select bank under Bank Statement", testName="selectBankName", priority=8)
	public void selectBankName()throws InterruptedException
	{	
		signInAsFinance.selectBank(validatorDataMap.get("bankName").toString());
	}
	
	@Test(description="select from month under Bank Statement", testName="selectMonth", priority=9)
	public void selectMonth()throws InterruptedException
	{
		signInAsFinance.selectFromMonth(validatorDataMap.get("fromMonth").toString());	
	}
	
	@Test(description="select from year under Bank Statement", testName="selectYear", priority=10)
	public void selectYear()throws InterruptedException
	{
		signInAsFinance.selectFromYear(validatorDataMap.get("fromYear").toString());	
	}
	
	@Test(description="select to month under Bank Statement", testName="selectToMonth", priority=11)
	public void selectToMonth()throws InterruptedException
	{
		signInAsFinance.selectToMonth(validatorDataMap.get("toMonth").toString());	
	}
	
	@Test(description="select to year under Bank Statement", testName="selectToYear", priority=12)
	public void selectToYear()throws InterruptedException
	{
		signInAsFinance.selectToYear(validatorDataMap.get("toYear").toString());	
	}
	
	@Test(description="click on generate bank statement",testName="clickOnGenerateBankStatement", priority=13)
	public void clickOnGenerateBankStatement()
	{
		signInAsFinance.clickGenerateBankStatement();
	}
	
	@Test(description="save bank statement", testName="saveBankStatement", priority=14)
	public void saveBankStatement()
	{
		signInAsFinance.countOfInstrumentIssued(validatorDataMap.get("countOfInstrumentIssued").toString());
		signInAsFinance.noOfBounceChequeIssued(validatorDataMap.get("noOfBouncecehqueIssued").toString());
		signInAsFinance.countOfInstrumentReceived(validatorDataMap.get("countOfInstrumentReceived").toString());
		signInAsFinance.noOfBouncechequeReceived(validatorDataMap.get("noOfBouncecehqueReceived").toString());
		signInAsFinance.saveBankStatement();
	}
	
	@Test(description="submit bank statement", testName="submitBankStatement", priority=15)
	public void submitBankStatement()
	{
		signInAsFinance.fillHighestTransactionValue(validatorDataMap.get("highestTransactionValue").toString());
		signInAsFinance.isEnoughChurnAvailable();
		signInAsFinance.submitBankStatement();
	}
	
	@Test(description="fetch probe data", testName="fetchprobeData",priority=16)
	public void fetchprobeData()
	{
		signInAsFinance.fetchProbe();
		signInAsFinance.saveFinalData();
		signInAsFinance.saveAndContinueOnTransactionHistory();
		signInAsFinance.hoverlogout();
		signInAsFinance.logOut();
		openURL();
		
	}
	@Test(description="login as scm to provide feedback", testName="loginAsScm", priority=17)
	public void loginAsScm()
	{
		
		signInAsScm.signIn();
		
	}
	
}
