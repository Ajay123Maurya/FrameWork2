package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.BrowserFactory;
import utils.ImageComparator;
import utils.dataType;

/**
 * Author : Manmeet Kumar
 *
 */

public class HomePageTest extends BrowserFactory {

	HomePage homePage = HomePage.getInstance();
	Map<Object, Object> elementMap, validatorDataMap;
	ImageComparator imageComparator = new ImageComparator();

	HomePageTest() {
		elementMap = data.getDataFromSheets(dataType.Elements.toString(), this.getClass().getSimpleName().toString());
		validatorDataMap = data.getDataFromSheets(dataType.Validator.toString(),
				this.getClass().getSimpleName().toString());
		// ElementLocatorFactory factory = new MapElementLocatorFactory(driver);
		// PageFactory.initElements(factory,
		// this.getClass().getSimpleName().replace("Test", "").trim());
	}

	@BeforeMethod
	public void openURL() {
		helper.openURL();
	}

	@Test(description = "Verify the presence of UI elements mandatory on Home Page", testName = "verifyValidHomePage", priority = 1)
	public void verifyValidHomePage() 
	{
		homePage.isValid();
	}
	
	@Test(description="Verfiy the presence apply for new loan button and link", testName ="verifyApplyForLoan", priority=2)
	public void verifyApplyForLoan()
	{
		homePage.isApplyForNewLoanClickable();
	}
	/*
	@Test(description = "verify the sign In flow", testName = "verifySignInOnHomePage", priority = 4)
	public void verifySignInOnHomePage() {
	
		homePage.clickONSignInButton();
		homePage.fillSignDialog(validatorDataMap.get("username").toString(),
				validatorDataMap.get("password").toString());
		homePage.submitSignInDialog();
		//homePage.validateSignIn(validatorDataMap.get("dialogSignInSuccessMessageText").toString(),
			//	validatorDataMap.get("username").toString().split("\\.")[0]);
		//homePage.dismissErrorToastMessage();
		homePage.logOut();
	}*/

	@Test(description = "verify failure sign In flow", testName = "verifyIncorrectLogin", priority = 3)
	public void verifyIncorrectLogin() 
	{
		homePage.clickONSignInButton();
		homePage.fillSignDialog("as@as.as", "asdasfa");
		homePage.submitSignInDialog();
		homePage.validateSignIn(validatorDataMap.get("dialogSignInFailureMessageText").toString(),
				validatorDataMap.get("headerAccountText").toString());
		//homePage.dismissErrorToastMessage();
	}

	
	@Test(description="Verify Sign in Using finance login", testName="verifySignInAsFinance", priority= 5)
	
	public void verifySignInAsFinance()
	{
		
	}
	@Test(description = "verify the register button and link from my account", testName = "verifyRegisterButtonLink", priority = 10)
	public void verifyRegisterButtonLink() {
		homePage.clickOnMyAccount();
		homePage.validateRegisterbutton();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

	@Test(description = "Verify the sliding of Banners on Home Page", testName = "verifyAutoSlidingOfBanners", priority = 5)
	public void verifyAutoSlidingOfBanners() {
		AssertJUnit.assertTrue(homePage.verifyAutoSlidingImages());
	}

	@Test(description = "verify the images are same or not", testName = "verifyBannerImages", priority = 6)
	public void verifyBannerImages() throws Throwable {
		AssertJUnit.assertTrue(imageComparator.compareImages(
				homePage.getFilePathForBanner(helper.findElementById(elementMap.get("banner1Id").toString())),
				homePage.getFilePath("slider_banner_power_drills_final.jpg")));
		AssertJUnit.assertTrue(imageComparator.compareImages(
				homePage.getFilePathForBanner(helper.findElementById(elementMap.get("banner2Id").toString())),
				homePage.getFilePath("slider_banner_LED_final.jpg")));
		AssertJUnit.assertTrue(imageComparator.compareImages(
				homePage.getFilePathForBanner(helper.findElementById(elementMap.get("banner3Id").toString())),
				homePage.getFilePath("slider_banner_Machinig_n.jpg")));
		AssertJUnit.assertTrue(imageComparator.compareImages(
				homePage.getFilePathForBanner(helper.findElementById(elementMap.get("banner4Id").toString())),
				homePage.getFilePath("slider_banner_Handtools_final.jpg")));
		AssertJUnit.assertTrue(imageComparator.compareImages(
				homePage.getFilePathForBanner(helper.findElementById(elementMap.get("banner5Id").toString())),
				homePage.getFilePath("slider_banner_Cameras_final.jpg")));
	}

	@Test(description = "verify the presence and redirection of side banners", testName = "verifySideBanner", priority = 7)
	public void verifySideUpperBanner() {
		AssertJUnit.assertTrue(homePage.isSafetyShoesImageClickable());
		AssertJUnit.assertTrue(homePage.isSafetyGlovesImageClickable());
	}

	@Test(description = "verify the presence and functionality of request call", testName = "verifyRequestCallOnHomePage", priority = 5)
	public void verifyRequestCallOnHomePage() {
		AssertJUnit.assertTrue(homePage.requestCall());
	}

	@Test(description = "verify the presence and functionality of My Account", testName = "verifyMyAccountOnHomePage", priority = 6)
	public void verifyMyAccountOnHomePage() {
		homePage.validateMyAccount();
	}

	@Test(description = "verify track order for blank order ID", testName = "verifyTrackOrderForBlankOrderId", priority = 7)
	public void verifyTrackOrderForBlankOrderId() {
		homePage.clickOnMyAccount();
		homePage.validateTrackOrderFunctionality("");
		homePage.validateBlankOrderId();
	}
	
	/*

	@Test(description = "verify the sign In flow", testName = "verifySignInOnHomePage", priority = 8)
	public void verifySignInOnHomePage() {
		homePage.clickOnMyAccount();
		homePage.clickONSignInButton();
		homePage.fillSignDialog(validatorDataMap.get("username").toString(),
				validatorDataMap.get("password").toString());
		homePage.submitSignInDialog();
		homePage.validateSignIn(validatorDataMap.get("dialogSignInSuccessMessageText").toString(),
				validatorDataMap.get("username").toString().split("\\.")[0]);
		homePage.dismissErrorToastMessage();
		homePage.logOut();
	}

	@Test(description = "verify failure sign In flow", testName = "verifyIncorrectLogin", priority = 9)
	public void verifyIncorrectLogin() {
		homePage.clickOnMyAccount();
		homePage.clickONSignInButton();
		homePage.fillSignDialog("as@as.as", "asdasfa");
		homePage.submitSignInDialog();
		homePage.validateSignIn(validatorDataMap.get("dialogSignInFailureMessageText").toString(),
				validatorDataMap.get("headerAccountText").toString());
		homePage.dismissErrorToastMessage();
	}

	@Test(description = "verify the register button and link from my account", testName = "verifyRegisterButtonLink", priority = 10)
	public void verifyRegisterButtonLink() {
		homePage.clickOnMyAccount();
		homePage.validateRegisterbutton();
	}
*/
	@Test(description = "verify the quick watch functionality", testName = "verifyQuickViewOfProductOnHomePage", priority = 11)
	public void verifyQuickViewOfProductOnHomePage() {
		homePage.hoverOnProduct();
		homePage.clickOnQuickWatch();
		homePage.validateQuickWatch();
		homePage.closeQuickWatch();
	}

	@Test(description = "verify add to cart from quick Watch functionality", testName = "verifyAddToCartFromQuickView", priority = 12)
	public void verifyAddToCartFromQuickView() {
		homePage.hoverOnProduct();
		homePage.clickOnQuickWatch();
		homePage.validateQuickWatch();
		homePage.clickOnAddToCart();
		homePage.dismissErrorToastMessage();
		homePage.validateProductAddedToCart();
	}

	@Test(description = "verify the redirection of product page and back to home page", testName = "verifyProductRedirectionFromQuickView", priority = 13)
	public void verifyProductRedirectionFromQuickView() {
		homePage.clickOnProduct();
		homePage.validateIsProductPageOpen();
		helper.navigateBack();
	}

	@Test(description = "verify the redirection to product page from quick view of product", testName = "verifyViewDetailsRedirectionFromQuickView", priority = 14)
	public void verifyViewDetailsRedirectionFromQuickView() {
		homePage.hoverOnProduct();
		homePage.clickOnQuickWatch();
		homePage.validateQuickWatch();
		homePage.clickOnViewDetails();
		homePage.validateIsProductPageOpen();
		helper.navigateBack();
	}

}
