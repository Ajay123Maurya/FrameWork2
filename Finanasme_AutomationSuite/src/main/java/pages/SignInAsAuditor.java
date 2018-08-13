package pages;

import java.util.Map;

import utils.ImageComparator;
import utils.dataType;

public class SignInAsAuditor extends HomePage
{
	
	private static SignInAsAuditor signInAsAuditor;

	Map<Object, Object> elementMap;
	Map<Object, Object> validatorDataMap;

	ImageComparator imageComparator = new ImageComparator();

	private SignInAsAuditor() {
		elementMap = data.getDataFromSheets(dataType.Elements.toString(), this.getClass().getSimpleName().toString());
		validatorDataMap = data.getDataFromSheets(dataType.Validator.toString(),
				this.getClass().getSimpleName().toString());
	}

	public static SignInAsAuditor getInstance() {
		if (signInAsAuditor == null) {
			signInAsAuditor = new SignInAsAuditor();
		}
		return signInAsAuditor;
	}

	
}