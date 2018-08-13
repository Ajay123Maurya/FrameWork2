package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Helper;
import utils.ImageComparator;
import utils.dataType;

public class SignInAsSales extends HomePage
{
	
	private static SignInAsSales signInAsSales;

	Map<Object, Object> elementMap;
	Map<Object, Object> validatorDataMap;

	ImageComparator imageComparator = new ImageComparator();

	private SignInAsSales() {
		elementMap = data.getDataFromSheets(dataType.Elements.toString(), this.getClass().getSimpleName().toString());
		validatorDataMap = data.getDataFromSheets(dataType.Validator.toString(),
				this.getClass().getSimpleName().toString());
	}

	public static SignInAsSales getInstance() {
		if (signInAsSales == null) {
			signInAsSales = new SignInAsSales();
		}
		return signInAsSales;
	}
	
	public void validateSignIn(String username) 
	{
		String elementName = "signInUserXpath";
		String locator = elementMap.get(elementName).toString();
		validateIsEqual(helper.findElement(elementName, locator).getText(), username);
	}
	
	public void searchSme()
	{
		String elementName="clickOnSearchSmeXpath";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	
	public void clickToInitiateLoan()
	{
		String elementName="clickToInitaiteLoanFrmScratchXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	
	public void enterPhNo(String phnNo)
	{
		String elementName= "phnNoId";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(phnNo);
	}
	public void selectAddress()
	{
		String elementName="selectAddXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	
	public void enterAddress(String address)
	{
		String elementName="enterAddressXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(address);
	}
	
	public void selectState(String state)
	{
		String elementName="selectStateXpath";
		String locator=elementMap.get(elementName).toString();
		helper.selectDropdownByXpath(locator, state);
	}
	
	public void selectCity(String city)
	{
		String elementName="selectCityXpath";
		String locator=elementMap.get(elementName).toString();
		helper.selectDropdownByXpath(locator, city);
	}
	
	public void enterPincode(String pincode)
	{
		String elementName="enterPincodeXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(pincode);
	}
	
	public void enterCompanyAddress(String compaddress)
	{
		
		String elementName="enterCompanyAddressXpath";
		String locator=elementMap.get(elementName).toString();
		//helper.findElement(elementName, locator).sendKeys(compaddress);
		List<WebElement> li=helper.findElements(elementName, locator);
		li.get(1).sendKeys(compaddress);
	}
	
	public void selectCompState(String state)
	{
		String elementName="selectCompStateXpath";
		String locator=elementMap.get(elementName).toString();
		//helper.selectDropdownByXpath(locator, state);
		List<WebElement> li=helper.findElements(elementName, locator);
		 WebElement wb=li.get(1);
		 
		 Select sel= new Select(wb);
			sel.selectByIndex(1);
		 //helper.selectDropdownByXpath(locator, state);
	}
	
	public void selectCompCity(String city)
	{
		String elementName="selectCompCityXpath";
		String locator=elementMap.get(elementName).toString();
		//helper.selectDropdownByXpath(locator, city);
		List<WebElement> li=helper.findElements(elementName, locator);
		WebElement wb=li.get(1);
		String loc=wb.getText().toString();
		Select sel= new Select(wb);
		sel.selectByIndex(1);
		//helper.selectDropdownByXpath(loc, data);
		 
	}
	
	public void enterCompPincode(String pincode)
	{
		String elementName="enterCompPincodeXpath";
		String locator=elementMap.get(elementName).toString();
		//helper.findElement(elementName, locator).sendKeys(pincode);
		List<WebElement> li=helper.findElements(elementName, locator);
		li.get(1).sendKeys(pincode);
		
	}
	
	public void saveAndContinue()
	{
		String elementName="saveAndContinueCss";
				String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	
	public void loanRequiredBySme(String loanamt)
	{
		String elementName="enterLoanAmntXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(loanamt);
	}
	public void loanSoughtBySme(String loanamnt)
	{
		String elementName="enterLoanOpAmntXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(loanamnt);
	}
	
	public void loanTenure(String loantenure)
	{
		String elementName="enterTenureXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(loantenure);
	}
	
	public void selUsageType(String usgtype)
	{
		String elementName="selectUsageTypeXpath";
		String locator=elementMap.get(elementName).toString();
		List<WebElement> li=helper.findElements(elementName, locator);
		 WebElement wb=li.get(0);
		 System.out.println(wb);
		 
		 Select sel= new Select(wb);
			sel.selectByIndex(1);
	}
	public void clickSaveNContinueBasicInfo()
	{
		String elementName="clickSave&ContinueBasicInfoXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
		
	}
	
	//Document Tab files upload
	
	public void uploadAadhar(String aadhar)
	{
		String elementName="uploadAadharXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(aadhar);
	}
	
	public void enterFrmDate()
			
	{
		String elementName="fromDateXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
		//helper.sleep(3000);
		String elementName1="fromDatevalXpath";
		String locator1=elementMap.get(elementName).toString();
		helper.findElement(elementName1, locator1).click();
		
	}
	public void enterToDate(String todate)
	{
		String elementName="toDateXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(todate);
	}
	public void selectBank(String selectbank)
	{
		String elementName="selectBankXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(selectbank);
	}
	public void uploadBankStatement(String bankstatment)
	{
		
		String elementName="uploadBankStatementXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(bankstatment);
		
	}
	
	public void clickSaveDocumentTab()
	{
		String elementName="clickSaveDocXpath";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).click();
	}
	
	public void validateFetchingAccountFrmCrm(String smename)
	{
		String elementName = "fetchSuiteCrmAccountXpath";
		String locator = elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(smename);
	}
	
	public void enterCompanyName(String companyName)
	{
		String elementName="enterCompanyNameId";
		String locator=elementMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys(companyName);
	}
	
	/* Enter KYC details */
	
	public void selectCompanyType(String companytype)
	{
		String elementName="selectCompanyTypeXpath";
		String locator=elementMap.get(elementName).toString();
		List<WebElement> li=helper.findElements(elementName, locator);
		 WebElement wb=li.get(0);
		 System.out.println(wb);
		 
		 Select sel= new Select(wb);
			sel.selectByIndex(1);
	}
	

}
