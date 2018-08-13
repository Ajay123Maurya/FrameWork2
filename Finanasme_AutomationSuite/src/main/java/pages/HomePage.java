package pages;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.ImageComparator;
import utils.dataType;

/**
 * 
 * Author : Manmeet Kumar
 *
 */

public class HomePage extends BasePage {

	private static HomePage homePage;

	Map<Object, Object> elementMap;
	Map<Object, Object> validatorDataMap;

	ImageComparator imageComparator = new ImageComparator();

	HomePage() {
		elementMap = data.getDataFromSheets(dataType.Elements.toString(), this.getClass().getSimpleName().toString());
		validatorDataMap = data.getDataFromSheets(dataType.Validator.toString(),
				this.getClass().getSimpleName().toString());
	}

	public static HomePage getInstance() {
		if (homePage == null) {
			homePage = new HomePage();
		}
		return homePage;
	}
	
	public void clickOnRegister(){
		String elementName = "accountRegisterButtonXpath";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	
	public void signIn(){
		//clickOnMyAccount();
		clickONSignInButton();
		
		fillSignDialog(validatorDataMap.get("username").toString(),
				validatorDataMap.get("password").toString());
		submitSignInDialog();
		//validateSignedInUserName();
		//dismissErrorToastMessage();
	}

	public void validateSignedInUserName()
	{
		validateSignIn(validatorDataMap.get("dialogSignInSuccessMessageText").toString(),
				validatorDataMap.get("username").toString().split("\\.")[0]);
	}
	
	@Override
	public void isValid() 
	{
		//validateHeader(this.getClass().getSimpleName().toString());
		validteTitle(validatorDataMap.get("pageTitle").toString().toLowerCase());
		//validateFooter(this.getClass().getSimpleName().toString());

	 }

	public void validteTitle(String title) {
		Assert.assertEquals(title, helper.getTitle().toLowerCase());
	}
	
	public boolean isApplyForNewLoanClickable() 
	{
		String elementName = "homePageApplyForLoanXpath";
		String locator = elementMap.get(elementName).toString();
		return helper.findElement(elementName, locator).isEnabled();
	}
	
	public void clickONSignInButton() {
		String elementName = "homePageSignInXpath";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	public void fillSignDialog(String email, String password) {
		String emailElementName = "accountSignEmailId";
		String emailLocator = elementMap.get(emailElementName).toString();
		helper.findElement(emailElementName, emailLocator).sendKeys(email);

		String passwordElementName = "accountSignPasswordXpath";
		String passwordLocator = elementMap.get(passwordElementName).toString();
		helper.findElement(passwordElementName, passwordLocator).sendKeys(password);
	}
	
	public void submitSignInDialog() 
	{
		String elementName = "dialogLoginButtonXpath";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	public void validateSignIn(String signInToastMessage, String user) 
	{
		validateToastMessage(elementMap.get("toastMessageClass").toString(), signInToastMessage);

		String elementName = "headerMyAccountClass";
		String locator = elementMap.get(elementName).toString();
		validateIsEqual(helper.findElement(elementName, locator).getText(), user);
		//dismissErrorToastMessage();
	}
	

	public void logOut() 
	{
		//clickOnMyAccount();
		String elementName = "accountSignOutButtonXpath";
		String locator = elementMap.get(elementName).toString();
		
		//List<WebElement> listOfQuickWatchDivs = helper.findElements(elementName, locator);
		//WebElement quickView = listOfQuickWatchDivs.get(1);
		WebElement ele=helper.findElement(elementName, locator);
		helper.clickOnHoverElement(ele);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String getFilePathForBanner(WebElement ele) {
		return ele.findElement(By.xpath(".//img")).getAttribute("src");
	}

	public String getFilePath(String fileName) {
		return System.getProperty("user.dir") + File.separator + "src" + File.separator + "resources" + File.separator
				+ "TestImages" + File.separator + fileName;
	}

	public boolean verifyAutoSlidingImages() {
		String listElementName = "bannersUlListXpath";
		String locator = elementMap.get(listElementName).toString();
		WebElement activeElements = helper.findElement(listElementName, locator);
		WebElement activeElement = activeElements.findElement(By.className("active"));
		String bannerType = activeElement.getAttribute("data-id");

		if (bannerType.equals("banner1")) {
			String elementName = "banner1Id";
			String locatoIF = elementMap.get(elementName).toString();
			return imageComparator.compareImages(getFilePathForBanner(helper.findElement(elementName, locatoIF)),
					getFilePath("slider_banner_power_drills_final.jpg"));
		} else if (bannerType.equals("banner2")) {
			String elementName = "banner2Id";
			String locatoIF = elementMap.get(elementName).toString();
			return imageComparator.compareImages(getFilePathForBanner(helper.findElement(elementName, locatoIF)),
					getFilePath("slider_banner_LED_final.jpg"));
		} else if (bannerType.equals("banner3")) {
			String elementName = "banner3Id";
			String locatoIF = elementMap.get(elementName).toString();
			return imageComparator.compareImages(getFilePathForBanner(helper.findElement(elementName, locatoIF)),
					getFilePath("slider_banner_Machinig_n.jpg"));
		} else if (bannerType.equals("banner4")) {
			String elementName = "banner4Id";
			String locatoIF = elementMap.get(elementName).toString();
			return imageComparator.compareImages(getFilePathForBanner(helper.findElement(elementName, locatoIF)),
					getFilePath("slider_banner_Handtools_final.jpg"));
		} else if (bannerType.equals("banner5")) {
			String elementName = "banner5Id";
			String locatoIF = elementMap.get(elementName).toString();
			return imageComparator.compareImages(getFilePathForBanner(helper.findElement(elementName, locatoIF)),
					getFilePath("slider_banner_Cameras_final.jpg"));
		}
		return false;
	}

	public boolean isSafetyShoesImageClickable() 
	{
		String elementName = "sideBannerSafetyShoesXpath";
		String locator = elementMap.get(elementName).toString();
		return helper.findElement(elementName, locator).isEnabled();
	}

	public boolean isSafetyGlovesImageClickable() {
		String elementName = "sideBannerSafetyShoesXpath";
		String locator = elementMap.get(elementName).toString();
		return helper.findElement(elementName, locator).isEnabled();
	}

	public boolean requestCall() {
		String elementName = "headerRequestCallId";
		String locator = elementMap.get(elementName).toString();
		clickOnRequestCall(locator);

		String elementNameDialog = "dialogClass";
		String locatorDialog = elementMap.get(elementNameDialog).toString();
		validateIsDisplayed(helper.findElement(elementNameDialog, locatorDialog));
		fillRequestCallForm();
		return true;
	}

	public void fillRequestCallForm() {
		enterPhoneInDialog();
		enterEmailInDialog();
		enterMessageInDialog();
		enterCaptchaInDialog();
		clickOnDialogSubmitButton();
	}

	public void enterPhoneInDialog() {
		String elementName = "dialogPhoneId";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(validatorDataMap.get("phone").toString());
	}

	public void enterEmailInDialog() {
		String elementName = "dialogEmailId";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(validatorDataMap.get("email").toString());
	}

	public void enterMessageInDialog() {
		String elementName = "dialogMessageId";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(validatorDataMap.get("logoAltMessage").toString());
	}

	public void enterCaptchaInDialog() {
		String elementName = "dialogCaptchaName";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys("12345");
	}

	public void clickOnDialogSubmitButton() {
		String elementName = "dialogSubmitButtonClass";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}

	public void clickOnRequestCall(String elementName) {
		helper.findElementById(elementName).click();
	}

	public void validateMyAccount() {
		validateMyAccount(elementMap.get("headerMyAccountClass").toString(),
				validatorDataMap.get("headerAccountText").toString());
		clickOnMyAccount();
		validateDropDown(elementMap.get("accountInfoDropDownId").toString());
		validateDropDownList();
		validateTrackOrder();
	}

	public void validateSignInFromMyAccount() {
		clickOnMyAccount();
		validateSignInDialog();
		clickONSignInButton();
		fillSignDialog(validatorDataMap.get("username").toString(), validatorDataMap.get("password").toString());
		submitSignInDialog();
		validateSignIn(validatorDataMap.get("dialogSignInSuccessMessageText").toString(),
				validatorDataMap.get("username").toString().split("\\.")[0]);
	}
	/*

	public void validateSignIn(String signInToastMessage, String user) {
		validateToastMessage(elementMap.get("toastMessageClass").toString(), signInToastMessage);

		String elementName = "headerMyAccountClass";
		String locator = elementMap.get(elementName).toString();
		validateIsEqual(helper.findElement(elementName, locator).getText(), user);
		dismissErrorToastMessage();
	}
	*/
/*
	public void clickONSignInButton() {
		String elementName = "accountSignInButtonXpath";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}*/
/*
	public void logOut() {
		//clickOnMyAccount();
		String elementName = "accountSignOutButtonXpath";
		String locator = elementMap.get(elementName).toString();
		
		List<WebElement> listOfQuickWatchDivs = helper.findElements(elementName, locator);
		WebElement quickView = listOfQuickWatchDivs.get(1);
		helper.clickOnHoverElement(quickView);
		
	}
	*/
/*
	public void submitSignInDialog() {
		String elementName = "dialogLoginButtonClass";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	*/
/*
	public void fillSignDialog(String email, String password) {
		String emailElementName = "accountSignEmailId";
		String emailLocator = elementMap.get(emailElementName).toString();
		helper.findElement(emailElementName, emailLocator).sendKeys(email);

		String passwordElementName = "accountSignPasswordId";
		String passwordLocator = elementMap.get(passwordElementName).toString();
		helper.findElement(passwordElementName, passwordLocator).sendKeys(password);
	}
	
	*/

	public void validateSignInDialog() {
		validateIsDisplayed(helper.findElementByClassName(elementMap.get("dialogClass").toString()));
		validateIsEqual(helper.findElementByClassName(elementMap.get("dialogTitleClass").toString()).getText(),
				validatorDataMap.get("accountSignInDialogTitleText").toString());
	}

	public void validateRegisterbutton() {
		String elementName = "accountRegisterButtonXpath";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).isDisplayed();
		validateIsEqual(helper.findElement(elementName, locator).getText(), "Register");
		validateLinkURL(elementMap.get("accountRegisterButtonXpath").toString(),
				helper.URL + validatorDataMap.get("footercreateAccountURLText").toString());
	}

	public void validateTrackOrder() {
		String elementName = "accountTrackOrderDivId";
		String locator = elementMap.get(elementName).toString();
		validateIsDisplayed(helper.findElement(elementName, locator));

		elementName = "accountTrackOrderClass";
		locator = elementMap.get(elementName).toString();
		validateIsEqual(helper.findElement(elementName, locator).getText(),
				validatorDataMap.get("accountTrackOrderTitleText").toString());

		validateTrackOrderFunctionality(validatorDataMap.get("correctOrderId").toString());

		validateToastMessage(elementMap.get("toastMessageClass").toString(),
				validatorDataMap.get("trackOrderMessageUnknownUserMessage").toString());

		dismissErrorToastMessage();
	}

	public void validateBlankOrderId() {
		String elementName = "accountBlankOrderErrorId";
		String locator = elementMap.get(elementName).toString();
		String message = helper.findElement(elementName, locator).getText();
		validateIsEqual(message, validatorDataMap.get("trackOrderErrorMessage").toString());
	}

	public void validateTrackOrderFunctionality(String orderId) {
		String elementName = "accountTrackOrderId";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(orderId + Keys.ENTER);
	}

	public void validateDropDown(String elementName) {
		Assert.assertTrue(helper.findElementById(elementName).isDisplayed());
	}

	public void clickOnMyAccount() {
		String elementName = "headerMyAccountClass";
		String locator = elementMap.get(elementName).toString();
		helper.sleep(4000);
		helper.findElement(elementName, locator).click();
		// helper.sleep(4000);
	}

	public void validateDropDownList() {
		/*
		 * validate Drop Down List section is displayed or not
		 */
		validateIsDisplayed(elementMap.get("accountOrdersXpath").toString());
		//validateIsDisplayed(elementMap.get("accountCompareListXpath").toString());
		//validateIsDisplayed(elementMap.get("accountReturnRequestXpath").toString());
		validateIsDisplayed(elementMap.get("footerTermsOfSaleXpath").toString());

		/*
		 * validate Drop Down List section redirection URLs
		 */

		validateLinkURL(elementMap.get("accountOrdersXpath").toString() + "/a",
				helper.URL + validatorDataMap.get("accountOrdersURLText").toString());
		validateLinkURL(elementMap.get("accountCompareListXpath").toString() + "/a",
				helper.URL + validatorDataMap.get("accountCompareListURLText").toString());
//		validateLinkURL(elementMap.get("accountReturnRequestXpath").toString() + "/a",
//				helper.URL + validatorDataMap.get("accountReturnRequestURLText").toString());
//		validateLinkURL(elementMap.get("accountWishListXpath").toString() + "/a",
//				helper.URL + validatorDataMap.get("accountWishListXURLText").toString());
	}

	public void hoverOnProduct() {
		String elementName = "homePageProductListXpath";
		String locator = elementMap.get(elementName).toString();
		List<WebElement> listOfProdcuts = helper.findElements(elementName, locator);
		WebElement product = listOfProdcuts.get(1);
		helper.hoverOnElement(product);
	}

	public void clickOnQuickWatch() {
		String elementName = "homePageQuickViewListXpath";
		String locator = elementMap.get(elementName).toString();
		List<WebElement> listOfQuickWatchDivs = helper.findElements(elementName, locator);
		WebElement quickView = listOfQuickWatchDivs.get(1);
		helper.clickOnHoverElement(quickView);
	}

	public void validateQuickWatch() {
		String elementName = "dialogTitleClass";
		String locator = elementMap.get(elementName).toString();
		validateIsDisplayed(helper.findElement(elementName, locator));
		validateIsEqual(helper.findElement(elementName, locator).getText(),
				validatorDataMap.get("quickViewerTitleText").toString());
	}

	public void closeQuickWatch() {
		String elementName = "homePageQuickViewCloseClass";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}

	public void clickOnProduct() {
		String elementName = "homePageProductNameListXpath";
		String locator = elementMap.get(elementName).toString();
		List<WebElement> listOfProdcuts = helper.findElements(elementName, locator);
		WebElement product = listOfProdcuts.get(1);
		product.click();
	}

	public void dismissErrorToastMessage() {
		closeToastMessage(elementMap.get("headerCloseNotificationXpath").toString());
	}

	public void clickOnAddToCart() {
		helper.switchToActive();
		String elementName = "quickViewAddToCartPLText";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(Keys.ENTER);
		//helper.clickOnHoverElement(helper.findElement(elementName, locator));
		
	}

	public void validateProductAddedToCart() {
		String elementName = "headerCartCounterClass";
		String locator = elementMap.get(elementName).toString();
		helper.waitForElementVisiblisty(helper.findElement(elementName, locator), 100);
		String text = helper.findElement(elementName, locator).getText();
		Assert.assertNotEquals(text, validatorDataMap.get("emptyCartCounter").toString());
	}

	public void validateIsProductPageOpen() {
		String elementName = "productPageWishListClass";
		String locator = elementMap.get(elementName).toString();
		Assert.assertTrue(helper.findElement(elementName, locator).isDisplayed());
	}

	public void clickOnViewDetails() {
		String elementName = "quickViewViewDetailsClass";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
}
