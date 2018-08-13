package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import utils.Data;

/**
 * 
 * Author : Hemant Yadav
 *
 */

public class TestCaseTransformer implements IAnnotationTransformer {

	Data data = Data.getInstance();
	Map<Object, Object> mapper;

	@Override
	public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor,
			Method testMethod) {

		mapper = data.getDataFromSheets("", this.getClass().getSimpleName().toString());
		String testname = testannotation.getTestName();
		if (disableMe(testname) == true) {
			testannotation.setEnabled(true);
		} else {
			testannotation.setEnabled(false);
		}

		// IRetryAnalyzer retry = testannotation.getRetryAnalyzer();
		//
		// if (retry == null) {
		// testannotation.setRetryAnalyzer(Retry.class);
		// }

	}

	private boolean disableMe(String testname) {
		if (mapper.get(testname) == null || ((String) mapper.get(testname)).toLowerCase().equals("")) {
			return true;
		}
		if (((String) mapper.get(testname)).toLowerCase().equals("true")) {
			return true;
		} else
			return false;
	}

}
