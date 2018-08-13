package tests;

import org.testng.annotations.Test;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.SignInAsNbfcManager;
import utils.BrowserFactory;
import utils.ImageComparator;
import utils.dataType;

public class SignInAsNbfcMangerTest extends BrowserFactory {

	SignInAsNbfcManager signInAsNbfcManager = SignInAsNbfcManager.getInstance();
	HomePage homePage = HomePage.getInstance();
	Map<Object, Object> elementMap, validatorDataMap;
	ImageComparator imageComparator = new ImageComparator();

	SignInAsNbfcMangerTest() {
		elementMap = data.getDataFromSheets(dataType.Elements.toString(), this.getClass().getSimpleName().toString());
		validatorDataMap = data.getDataFromSheets(dataType.Validator.toString(),
				this.getClass().getSimpleName().toString());
		
	}
	
	@BeforeMethod
	public void openURL() 
	{
		helper.openURL();	
	}	
	
	public void preOperations() 
	{
		signInAsNbfcManager.signIn();	
	}
	
	/*@AfterMethod
	public void logOut() {
		helper.openURL();
		homePage.logOut();
	}*/
	
	@Test(description = "verify the sign In flow as NbfcManager", testName = "verifySignInAsNbfcManager", priority = 1)
	public void verifySignInAsNbfcManager() 
	{
		preOperations();
	}


}
