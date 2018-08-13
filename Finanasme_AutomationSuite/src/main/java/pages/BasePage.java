package pages;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.Data;
import utils.Helper;
import utils.dataType;

/**
 * 
 * Author : Manmeet Kumar
 *
 */
abstract class BasePage {

	protected Helper helper = new Helper();

	Data data = Data.getInstance();

	public abstract void isValid();

	
	
	public void validateHeader(String className) {
		Map<Object, Object> elementMap, validatorDataMap;
		elementMap = data.getDataFromSheets(dataType.Elements.toString(), className);
		validatorDataMap = data.getDataFromSheets(dataType.Validator.toString(), className);

		/*
		 * validate SMESHOPS logo is displayed or not
		 */
		validateLogo(elementMap.get("headerLogoClass").toString(), validatorDataMap.get("logoAltMessage").toString());

		/*
		 * validate Bulk inquiry label is viewed or not
		 */
		validateBulkEnquiry(elementMap.get("headerBulkEnqClass").toString(),
				validatorDataMap.get("bulkEnquiryText").toString());

		/*
		 * validate request call icon is displayed or not
		 */
		validateIsDisplayed(helper.findElementById(elementMap.get("headerRequestCallId").toString()));

		/*
		 * validate My Account icon is displayed or not
		 */
		validateMyAccount(elementMap.get("headerMyAccountClass").toString(),
				validatorDataMap.get("headerAccountText").toString());

		/*
		 * validate cart icon is displayed or not
		 */
		validateCartIcon(elementMap.get("headerEmptyCartClass").toString(),
				validatorDataMap.get("headerEmptyCartText").toString());
	}

	public void validateFooter(String className) {
		Map<Object, Object> elementMap, validatorDataMap;
		elementMap = data.getDataFromSheets(dataType.Elements.toString(), className);
		validatorDataMap = data.getDataFromSheets(dataType.Validator.toString(), className);

		/*
		 * calling function to validate if the slick slider is displayed or not
		 */
		validateIsDisplayed(helper.findElementByClassName(elementMap.get("footerSlickClass").toString()));
		Assert.assertTrue(
				helper.findElementByClassName(elementMap.get("footerStayConnectedClass").toString()).isDisplayed());

		/*
		 * calling function to validate if the subscribe is displayed or not
		 */
		WebElement subscribe = validateSubscribeBox(elementMap.get("footerSubscribeEmailName").toString(),
				validatorDataMap.get("subscribeEmail").toString());

		/*
		 * Enter the email of the subscriber in input box
		 */
		enterSubscribeEmail(subscribe, validatorDataMap.get("subscribeEmail").toString());

		/*
		 * validates the toast message text coming post entering subscribe email
		 */
		validateToastMessage(elementMap.get("toastMessageClass").toString(),
				validatorDataMap.get("successfulSubscriptionToastMessage").toString());

		/*
		 * validate social Media div
		 */
		validateSocialMediaLinks(elementMap, validatorDataMap);

		/*
		 * validate User Account footer displayed and URLs
		 */
		validateFooterUserAccountSection(elementMap, validatorDataMap);

		/*
		 * validate Customer section in footer
		 */
		validateCustomerServiceSection(elementMap, validatorDataMap);

		/*
		 * validate About us in footer
		 */
		validateAboutUS(elementMap, validatorDataMap);

		/*
		 * validate free shipping is displayed
		 */
		validateIsDisplayed(helper.findElementByXpath(elementMap.get("footerFreeShippingXpath").toString()));
	}

	public void closeToastMessage(String elementName) {
		helper.findElementByXpath(elementName).click();
	}

	public void validateAboutUS(Map<Object, Object> elementMap, Map<Object, Object> validatorDataMap) {
		/*
		 * validate About us section is displayed or not
		 */
		validateIsDisplayed(elementMap.get("footerCompanyXpath").toString());
		validateIsDisplayed(elementMap.get("footerOurTeamXpath").toString());
		validateIsDisplayed(elementMap.get("footerPrivacyPolicyXpath").toString());
		validateIsDisplayed(elementMap.get("footerTermsOfSaleXpath").toString());
		validateIsDisplayed(elementMap.get("footerTermsOfUseXpath").toString());

		/*
		 * validate About us section redirection URLs
		 */

		validateLinkURL(elementMap.get("footerCompanyXpath").toString() + "/a",
				helper.URL + validatorDataMap.get("footerCompanyURLText").toString());
		validateLinkURL(elementMap.get("footerOurTeamXpath").toString() + "/a",
				helper.URL + validatorDataMap.get("footerOurTeamURLText").toString());
		validateLinkURL(elementMap.get("footerPrivacyPolicyXpath").toString() + "/a",
				helper.URL + validatorDataMap.get("footerPrivacyPolicyURLText").toString());
		validateLinkURL(elementMap.get("footerTermsOfSaleXpath").toString() + "/a",
				helper.URL + validatorDataMap.get("footerTermsOfSaleURLText").toString());
		validateLinkURL(elementMap.get("footerTermsOfUseXpath").toString() + "/a",
				helper.URL + validatorDataMap.get("footerTermsOfUseURLText").toString());
	}

	public void validateSocialMediaLinks(Map<Object, Object> elementMap, Map<Object, Object> validatorDataMap) {
		/*
		 * validates if facebook icon is visible or not
		 */
		validateIsDisplayed(helper.findElementByClassName(elementMap.get("footerFacebookClass").toString()));

		/*
		 * validates if twitter icons is visible or not
		 */
		validateIsDisplayed(helper.findElementByClassName(elementMap.get("footerTwitterClass").toString()));

		/*
		 * validate the href URL of social icons
		 */
		validateLinkURL(elementMap.get("footerFacebookLinkXpath").toString(),
				validatorDataMap.get("facebookLink").toString());
		validateLinkURL(elementMap.get("footerTwitterLinkXpath").toString(),
				validatorDataMap.get("twitterLink").toString());
	}

	public void validateFooterUserAccountSection(Map<Object, Object> elementMap, Map<Object, Object> validatorDataMap) {

		/*
		 * validate the user account related things
		 */
		validateIsDisplayed(elementMap.get("footerSignInXPath").toString());
		validateIsDisplayed(elementMap.get("footerCreateAccountXpath").toString());

		/*
		 * validate the href URL of User Account
		 */
		validateLinkURL(elementMap.get("footerSignInXPath").toString(),
				helper.URL + validatorDataMap.get("footerSignInURLText").toString());
		validateLinkURL(elementMap.get("footerCreateAccountXpath").toString(),
				helper.URL + validatorDataMap.get("footercreateAccountURLText").toString());
	}

	public void validateCustomerServiceSection(Map<Object, Object> elementMap, Map<Object, Object> validatorDataMap) {

		/*
		 * validate customer service section is displayed or not
		 */
		validateIsDisplayed(elementMap.get("footerCustomerServiceListXpath").toString());
		validateIsDisplayed(elementMap.get("footerWishListXpath").toString());
		validateIsDisplayed(elementMap.get("footerCancellationPolicyXpath").toString());
		validateIsDisplayed(elementMap.get("footerFaqsXpath").toString());
		validateIsDisplayed(elementMap.get("footerContactUsXpath").toString());

		/*
		 * validate customer service section redirection URLs
		 */
		validateLinkURL(elementMap.get("footerCustomerServiceListXpath").toString() + "/a",
				helper.URL + validatorDataMap.get("footerAboutYourOrderURLText").toString());
		validateLinkURL(elementMap.get("footerWishListXpath").toString() + "/a",
				helper.URL + validatorDataMap.get("footerWishListURLText").toString());
		validateLinkURL(elementMap.get("footerCancellationPolicyXpath").toString() + "/a",
				helper.URL + validatorDataMap.get("footerCancellationPolicyURLText").toString());
		validateLinkURL(elementMap.get("footerFaqsXpath").toString() + "/a",
				helper.URL + validatorDataMap.get("footerFAQsURLText").toString());
		validateLinkURL(elementMap.get("footerContactUsXpath").toString() + "/a",
				helper.URL + validatorDataMap.get("footerContactUsTextURL").toString());
	}

	public void validateIsDisplayed(String elementName) {
		Assert.assertTrue(helper.findElementByXpath(elementName).isDisplayed());
	}

	public void validateIsDisplayed(WebElement ele) {
		Assert.assertTrue(ele.isDisplayed());
	}

	public void validateIsEqual(String elementText, String ValidText) {
		Assert.assertEquals(elementText.replaceAll("\\s+", " ").replace("\n", "").replace("\r", "").toLowerCase(),
				ValidText.toLowerCase());
	}

	public void validateLinkURL(String elementName, String validData) {
		Assert.assertEquals(helper.findElementByXpath(elementName).getAttribute("href").toString().toLowerCase(),
				validData.toLowerCase());
	}

	public void validateToastMessage(String elementName, String validData) {
		System.out.println(helper.findElementByClassName(elementName).getText());
		validateIsEqual(helper.findElementByClassName(elementName).getText(), validData);
	}

	public WebElement validateSubscribeBox(String elementName, String validData) {
		WebElement subscribe = helper.findElementByName(elementName);
		validateIsDisplayed(subscribe);
		return subscribe;
	}

	public void enterSubscribeEmail(WebElement ele, String validData) {
		ele.sendKeys(validData + Keys.ENTER);
		helper.switchToActive();
	}

	public void validateCartIsEmpty(String elementName, String validData) {
		validateIsEqual(helper.findElementByClassName(elementName).getText(), validData);
	}

	public boolean validateCartNotEmpty(String elementName, String validData) {
		return helper.findElementByClassName(elementName).getText().toString().equals(validData.toString());
	}

	public void validateNotEqual(String elementText, String validText) {
		Assert.assertNotEquals(elementText.replaceAll("\\s+", " ").replace("\n", "").replace("\r", "").toLowerCase(),
				validText.toLowerCase());
	}

	public void validateCartIcon(String elementName, String validData) {
		WebElement cart = helper.findElementByClassName(elementName);
		validateIsDisplayed(cart);
		validateIsEqual(cart.getText(), validData);
	}

	public void validateMyAccount(String elementClass, String validData) {
		WebElement account = helper.findElementByClassName(elementClass);
		validateIsDisplayed(account);
		validateIsEqual(account.getText(), validData);
	}

	public void validateBulkEnquiry(String elementClass, String validData) {
		WebElement enq = helper.findElementByClassName(elementClass);
		validateIsDisplayed(enq);
		validateIsEqual(enq.getText(), validData);
	}

	public void validateLogo(String elementClass, String validData) {
		WebElement logo = helper.findElementByClassName(elementClass);
		validateIsDisplayed(logo);
		validateIsEqual(logo.getAttribute("alt").toString(), validData);
	}
}