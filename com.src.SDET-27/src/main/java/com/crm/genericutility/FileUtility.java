package com.crm.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Abhishek
 */
public class FileUtility {

	public String getPropertyKeyValue(String key) throws Throwable {

		FileInputStream fis = new FileInputStream("./data/commonData.Properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

}
