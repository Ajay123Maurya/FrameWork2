package pages;

import java.util.Map;

import utils.ImageComparator;
import utils.dataType;

public class SignInAsScm extends HomePage
{
	
	private static SignInAsScm signInAsScm;

	Map<Object, Object> elementMap;
	Map<Object, Object> validatorDataMap;

	ImageComparator imageComparator = new ImageComparator();

	private SignInAsScm() {
		elementMap = data.getDataFromSheets(dataType.Elements.toString(), this.getClass().getSimpleName().toString());
		validatorDataMap = data.getDataFromSheets(dataType.Validator.toString(),
				this.getClass().getSimpleName().toString());
	}

	public static SignInAsScm getInstance() {
		if (signInAsScm == null) {
			signInAsScm = new SignInAsScm();
		}
		return signInAsScm;
	}
	
	/*
	public void signInForfeedback()
	{
		String elementName="accountSignEmailId";
		String locator=validatorDataMap.get(elementName).toString();
		helper.findElement(elementName, locator).sendKeys("scm");
		String elementName1="accountSignPasswordXpath";
		String locator1=validatorDataMap.get(elementName1).toString();
		helper.findElement(elementName1, locator1).sendKeys("password");
		String elementName2="dialogLoginButtonXpath";
		String locator2=validatorDataMap.get(elementName2).toString();
		helper.findElement(elementName2, locator2).click();
		
	}*/


}
