package pages;

import java.util.Map;

import org.openqa.selenium.WebElement;

import utils.ImageComparator;
import utils.dataType;

public class SignInAsFinance extends HomePage
{
	
	private static SignInAsFinance signInAsFinance;

	Map<Object, Object> elementMap;
	Map<Object, Object> validatorDataMap;

	ImageComparator imageComparator = new ImageComparator();

	private SignInAsFinance() {
		elementMap = data.getDataFromSheets(dataType.Elements.toString(), this.getClass().getSimpleName().toString());
		validatorDataMap = data.getDataFromSheets(dataType.Validator.toString(),
				this.getClass().getSimpleName().toString());
	}

	public static SignInAsFinance getInstance() {
		if (signInAsFinance == null) {
			signInAsFinance = new SignInAsFinance();
		}
		return signInAsFinance;
	}

	
	public void validateSignIn(String username) 
	{
		String elementName = "signInUserXpath";
		String locator = elementMap.get(elementName).toString();
		validateIsEqual(helper.findElement(elementName, locator).getText(), username);
	}
	
	public void processAppliedCurrentLoan()
	{
		String elementName= "currentProcessLoanXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	
	public void continueOnAccountInfoPage()
	{
		String elementName= "continueOnAccountInfoXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	public void continueOnBasicInfoPage()
	{
		String elementName= "continueOnBasicInfoXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	
	public void saveAndContinueOnFinancialInfoPage()
	{
		String elementName= "saveAndContinueOnFinancialInfoXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();	
	}
	
	public void fillAccountNo(String data) throws InterruptedException
	{
		helper.sleep(3000);
		String elementName= "accountNumberXpath";
		String locator=elementMap.get(elementName).toString();	
		helper.findElement(elementName, locator).sendKeys(data);
	}
	public void selectBank(String data)throws InterruptedException
	{
		helper.waitForJSandJQueryToLoad();
		String elementName= "selectBankXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(data);
	}
	
	public void selectFromMonth(String data)throws InterruptedException
	{
		helper.sleep(3000);
		String elementName= "selectFromMonthXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(data);
	}
	
	public void selectFromYear(String data)throws InterruptedException
	{
		helper.sleep(3000);
		String elementName= "selectFromYearXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(data);
	}
	
	public void selectToMonth(String data)throws InterruptedException
	{
		helper.sleep(3000);
		String elementName= "selectToMonthXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(data);
	}
	
	public void selectToYear(String data)throws InterruptedException
	{
		helper.sleep(3000);
		String elementName= "selectToYearXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(data);
		
	}
	
	public void clickGenerateBankStatement()
	{
		helper.sleep(3000);
		String elementName= "generateBankStatementXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	
	public void countOfInstrumentIssued(String data)
	{
		String elementName="countOfInstrumentIssuedXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(data);
	}
	public void noOfBounceChequeIssued(String data)
	{
		String elementName="noOfBounceChequeIssuedXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(data);
	}
	public void countOfInstrumentReceived(String data)
	{
		String elementName="countOfInstrumentReceivedXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(data);
	}
	public void noOfBouncechequeReceived(String data)
	{
		String elementName="noOfBounceChequeReceivedXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(data);
	}
	public void saveBankStatement()
	{
		String elementName="saveBankStatementXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	public void fillHighestTransactionValue(String data)
	{
		String elementName="highestTransactionValueId";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(data);
	}
	public void isEnoughChurnAvailable()
	{
		String elementName="enoughChurnXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	public void submitBankStatement()
	{
		String elementName="submitBankStatementId" ;		
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
		helper.sleep(5000);
	}
	
	public void fetchProbe()
	{
		
		String elementName="fetchProbeDataXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
		helper.sleep(4000);
		helper.alertaccept();
		String elementName1="requestFromMcaXpath";
		WebElement elementName2= helper.findElement(elementName1, locator);
		helper.waitForElementVisiblisty(elementName2, 120);
		helper.sleep(10000);
	}
	public void saveFinalData()
	{
		String elementName="saveFinalDataId";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
		helper.sleep(5000);
	}
	
	public void saveAndContinueOnTransactionHistory()
	{
		String elementName="saveAndContinueOnTransactionHistoryXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	public void hoverlogout()
	{
		String elementName="logoutHoverXpath";
		String locator=elementMap.get(elementName).toString();
		WebElement ele=helper.findElement(elementName, locator);
		helper.hoverOnElement(ele);
	}
	public void logout()
	{
		String elementName="logoutXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	
	}
	
	
	
}
