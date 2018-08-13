package pages;

import java.util.Map;

import utils.ImageComparator;
import utils.dataType;

public class SignInAsNbfcManager extends HomePage
{
	
	private static SignInAsNbfcManager signInAsNbfcManager;

	Map<Object, Object> elementMap;
	Map<Object, Object> validatorDataMap;

	ImageComparator imageComparator = new ImageComparator();

	private SignInAsNbfcManager() {
		elementMap = data.getDataFromSheets(dataType.Elements.toString(), this.getClass().getSimpleName().toString());
		validatorDataMap = data.getDataFromSheets(dataType.Validator.toString(),
				this.getClass().getSimpleName().toString());
	}

	public static SignInAsNbfcManager getInstance() {
		if (signInAsNbfcManager == null) {
			signInAsNbfcManager = new SignInAsNbfcManager();
		}
		return signInAsNbfcManager;
	}


}
