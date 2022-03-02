package restassuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John" + generatedString);
	}
	
	public static String getJob() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Leader" + generatedString);
	}
	
	public static String empName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John" + generatedString);
	}
	
	public static String empSalary() {
		String generatedString = RandomStringUtils.randomNumeric(1);
		return (generatedString);
	}
	
	public static String empAge() {
		String generatedString = RandomStringUtils.randomNumeric(1);
		return (generatedString);
	}
}