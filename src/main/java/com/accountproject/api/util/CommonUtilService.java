package com.accountproject.api.util;

public class CommonUtilService {
	
	public static String maskNullValue(String value) {
		if (value == null || value.equalsIgnoreCase("")) {
			value = "";
		}
		return value;
	}

}
