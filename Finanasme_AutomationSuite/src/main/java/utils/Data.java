package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * Author : Hemant Yadav
 *
 */

public class Data {

	private static Data data;

	//private static String env = System.getProperty("apnaparameter");
	private static String env = "stagingSheetId";

	static Map<Object, Object> emailDataMap;

	public static Data getInstance() {
		if (data == null) {
			// System.out.println("apnaparameter : " +
			// System.getProperty("apnaparameter"));
			data = new Data();
			emailDataMap = data.getDataFromSheets("", "Email");
			System.setProperty("EMAIL_LIST", changeDataToString(emailDataMap));
			System.out.println(System.getProperty("EMAIL_LIST"));
			String email_list = changeDataToString(emailDataMap);
			setEmail(email_list);
		}
		return data;
	}
	
	public static void setEmail(String email_list){
		try{
			System.out.println(email_list);
			Process proc = Runtime.getRuntime().exec(new String[]{"bash","-c" ,"export EMAIL_LIST="+ email_list  +""});
	        proc.waitFor();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

	        String line = reader.readLine();
		}
		catch(Exception Ex){
			System.out.println("fat gaya yeh");
		}
		
	}

	public static String method(String str) {
		if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ',') {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	public static String changeDataToString(Map<Object, Object> map) {
		String cont_str = "";

		Set<Object> listOfKeys = map.keySet();

		for (Object l : listOfKeys) {
			cont_str = cont_str + l.toString() + ",";
		}

		cont_str = method(cont_str);

		return cont_str;
	}

	static final ConcurrentHashMap<String, Map<Object, Object>> cache = new ConcurrentHashMap<>();

	GoogleSheetReader reader = GoogleSheetReader.getInstance();

	// Staging sheet
	public static String stagingSheetId = "1Lnq524qjzBo0a3Cmnc3JMzb5ZKcRxRydWg9Vcm9BdOc";
	// production Sheet
	public static String productionSheetId = "1AvlS_jOIvR7Svqppuwe5b6Z_Fl0sozFN5aWDLzPVUQo";

	public static String sheetId = getSheetId();

	private static String getSheetId() {
		if (env.equals("production")) {
			System.out.println("production: " + productionSheetId);
			return productionSheetId;
		} else {
			System.out.println("staging: " + stagingSheetId);
			return stagingSheetId;
		}
	}

	// 8291823582

	private static final Object o = new Object();

	private Map<Object, Object> getDataFromSheet(String sheetId, String sheetNameForElements) {
		if (cache.containsKey(sheetNameForElements)) {
			return cache.get(sheetNameForElements);
		}
		Map<Object, Object> elementMap = null;
		synchronized (o) {
			if (cache.containsKey(sheetNameForElements)) {
				return cache.get(sheetNameForElements);
			}
			System.out.println("Reading Data For : " + sheetNameForElements);
			elementMap = reader.getSheetMap(sheetId, sheetNameForElements);
			cache.put(sheetNameForElements, elementMap);
		}
		return elementMap;
	}

	/*
	 * Vivek's Method
	 */
	// static final ConcurrentHashMap<String, Object> locks = new
	// ConcurrentHashMap<>();
	//
	// private Map<Object, Object> getDataFromSheet(String sheetId, String
	// sheetNameForElements) {
	// if(cache.containsKey(sheetNameForElements)){
	// return cache.get(sheetNameForElements);
	// }
	//
	// Object lock = null;
	//
	// Object tmp = null;
	// if(locks.containsKey(sheetNameForElements)){
	// lock = locks.get(sheetNameForElements);
	// }else{
	// lock = new Object();
	// tmp = locks.putIfAbsent(sheetNameForElements, lock);
	// if(tmp != null){
	// lock = tmp;
	// }
	// }
	//
	// Map<Object, Object> elementMap = null;
	// synchronized (lock) {
	// if(cache.containsKey(sheetNameForElements)){
	// return cache.get(sheetNameForElements);
	// }
	// System.out.println("Reading Data For : " + sheetNameForElements);
	// elementMap = reader.getSheetMap(sheetId, sheetNameForElements);
	// cache.put(sheetNameForElements, elementMap);
	// }
	// return elementMap;
	// }

	private Data() {

	}

	public Map<Object, Object> getDataFromSheets(String dataType, String className) {
		Map<Object, Object> map;
		String sheetNameForElements = "";
		if (className.toLowerCase().equals("Helper".toLowerCase())) {
			sheetNameForElements = "Helper";
		} else if (className.toLowerCase().contains("DataBase".toLowerCase())) {
			sheetNameForElements = "DataBaseActions";
		} else if (className.toLowerCase().equals("TestCaseTransformer".toLowerCase())) {
			sheetNameForElements = "testCases";
		} else if (className.toLowerCase().equals("Email".toLowerCase())) {
			sheetNameForElements = "emailList";
		} else if (className.toLowerCase().contains("test".toLowerCase())) {
			className = className.replace("Test", "");
			sheetNameForElements = className.concat(dataType).trim();
		} else {
			sheetNameForElements = className.concat(dataType);
		}
		map = getDataFromSheet(sheetId, sheetNameForElements);
		return map;
	}
}
