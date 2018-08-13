package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.SignInAsSales;
import utils.BrowserFactory;
import utils.ImageComparator;
import utils.dataType;

public class SignInAsSalesTest extends BrowserFactory {

	SignInAsSales signInAsSales = SignInAsSales.getInstance();
	HomePage homePage = HomePage.getInstance();
	Map<Object, Object> elementMap, validatorDataMap;
	ImageComparator imageComparator = new ImageComparator();

	SignInAsSalesTest() {
		elementMap = data.getDataFromSheets(dataType.Elements.toString(), this.getClass().getSimpleName().toString());
		validatorDataMap = data.getDataFromSheets(dataType.Validator.toString(),
				this.getClass().getSimpleName().toString());
		
	}
	
	
	@BeforeClass
	public void openURL() 
	{
		helper.openURL();	
	}	
	
	/*public void preOperations() 
	{
		signInAsSales.signIn();	
	}*/
	
	/*@AfterMethod
	public void logOut() {
		helper.openURL();
		homePage.logOut();
	}*/
	
	@Test(description = "verify the sign In flow as Sales", testName = "verifySignInAsSales", priority = 0)
	public void verifySignInAsSales() 
	{
		//preOperations();
		signInAsSales.signIn();	
	}
	
	@Test(description = "validate the signedIn user as Sales", testName = "verifySignedInUsername", priority = 2)
	public void verifySignedInUsername() 
	{
		signInAsSales.validateSignIn("KYC");
	}
	
	@Test(description="verify the fetching of account from Suite CRM", testName="verifyFetchingAccountFromCrm", priority = 3)
	public void verifyFetchingAccountFromCrm()
	{
		signInAsSales.validateFetchingAccountFrmCrm(validatorDataMap.get("smename").toString());
		signInAsSales.searchSme();
		//helper.waitForPresenceOfElement(By validatorDataMap.get("fetchAccountText").toString(), 10, elementName);
		helper.sleep(6000);
		signInAsSales.clickToInitiateLoan();
	}
	
	@Test(description="verify the account info page", testName="verifyAccountInfo", priority = 4)
	public void verifyAccountInfo()
	{
		signInAsSales.enterPhNo(validatorDataMap.get("phnNo").toString());
		helper.sleep(10000);
		helper.alertaccept();
		signInAsSales.enterAddress(validatorDataMap.get("address").toString());
		signInAsSales.enterPincode(validatorDataMap.get("pincode").toString());
		helper.sleep(5000);
		signInAsSales.enterCompanyName(validatorDataMap.get("companyName").toString());
		signInAsSales.enterCompanyAddress(validatorDataMap.get("address").toString());
		helper.sleep(5000);
		signInAsSales.enterCompPincode(validatorDataMap.get("pincode").toString());
		helper.sleep(3000);
		signInAsSales.saveAndContinue();
	}
	
	@Test(description="Enter the Basic Info details", priority=5)
	public void enterBasicInfo()
	{
		signInAsSales.loanRequiredBySme(validatorDataMap.get("loanamt").toString());
		signInAsSales.loanSoughtBySme(validatorDataMap.get("loanamnt").toString());
		signInAsSales.loanTenure(validatorDataMap.get("loantenure").toString());
		helper.sleep(4000);
		signInAsSales.selUsageType(validatorDataMap.get("usgtype").toString());
		helper.sleep(5000);
		signInAsSales.clickSaveNContinueBasicInfo();
		helper.sleep(4000);
		
		
	}
	@Test(description="Upload file under Document tab", priority=6)
	public void uploadDoc()
	{
		signInAsSales.uploadAadhar(validatorDataMap.get("aadhar").toString());
		helper.sleep(5000);
		signInAsSales.clickSaveDocumentTab();
		helper.sleep(5000);

	}
	
	@Test(description="Enter details under KYC ", priority=7)
	public void enterKYCInfo()
	{
		helper.sleep(4000);
		signInAsSales.selectCompanyType(validatorDataMap.get("companytype").toString());
	}
	
	
}
