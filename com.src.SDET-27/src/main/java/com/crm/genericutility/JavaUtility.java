package com.crm.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * @author Abhishek
 */

public class JavaUtility {
	/**
	 * its use to generate the random number
	 * 
	 * @return int data
	 */
	public int getRanDomNumber() {
		Random random = new Random();
		int intRandom = random.nextInt(10000);
		return intRandom;

	}

	/**
	 * use to get asystem date And time in IST format
	 * 
	 * @return
	 */
	public String getSystemDateAndTime() {

		Date date = new Date();
		return date.toString();

	}

	/**
	 * Used to get SystemDate in YYYY-MM-DD Fromat
	 * 
	 * @return
	 */
	public String getSystemDateWithFormate() {

		Date date = new Date();
		String dateAndTime = date.toString();

		String YYYY = dateAndTime.split("    ")[5];
		String DD = dateAndTime.split("  ")[2];
		int MM = date.getMonth() + 1;

		String finalFormat = YYYY + "-" + MM + "-" + DD;
		return finalFormat;
	}
}
