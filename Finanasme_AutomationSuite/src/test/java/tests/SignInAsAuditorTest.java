package tests;

import org.testng.annotations.Test;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.SignInAsAuditor;
import utils.BrowserFactory;
import utils.ImageComparator;
import utils.dataType;

public class SignInAsAuditorTest extends BrowserFactory {

	SignInAsAuditor signInAsAuditor = SignInAsAuditor.getInstance();
	HomePage homePage = HomePage.getInstance();
	Map<Object, Object> elementMap, validatorDataMap;
	ImageComparator imageComparator = new ImageComparator();

	SignInAsAuditorTest() {
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
		signInAsAuditor.signIn();	
	}
	
	/*@AfterMethod
	public void logOut() {
		helper.openURL();
		homePage.logOut();
	}*/
	
	@Test(description = "verify the sign In flow as Finance", testName = "verifySignInAsAuditor", priority = 1)
	public void verifySignInAsAuditor() 
	{
		preOperations();
	}


}
