package com.project.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * this class contains generic methods of java
 * @author sandeep
 *
 */
public final class JavaUtility {

	/**
	 * this method is used to get random number
	 * @return
	 */
	public int randomNumber(int bound) {
		return new Random().nextInt(bound);
	}

	/**
	 * this method is used to convert string datatype timeouts to long datatype
	 * @param timeouts
	 * @return
	 */
	public long convertToLong(String timeouts) {
		return Long.parseLong(timeouts);
	}

	/**
	 * this method is used to get the absolute path of the file
	 * @param pathOfFile
	 * @return
	 */
	public String absolutePath(String pathOfFile) {
		return System.getProperty("user.dir")+pathOfFile;
	}

	/**
	 * this method is used to split hte string according the strategy
	 * @param file
	 * @param strategy
	 * @return
	 */
	public String[] splittedString(String file,String strategy) {
		return  file.split(strategy);
	}

	public String getDate(String strategy) {
		return new SimpleDateFormat(strategy).format(new Date());

	}


	/**
	 * this method is used to get the class name along with the date
	 * @param objRef
	 * @return
	 */
	public String getClassNameWithDate(Object objRef,String strategy) {

		return objRef.getClass().getSimpleName()+getDate(strategy);
	}
	
	/**
	 * this method is used to convert string to int
	 * @param data
	 * @return
	 */
	public int stringToInt(String data) {
		return Integer.parseInt(data);
	}

}
