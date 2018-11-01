package org.common.utils;

public class StringHelper {
	
	public static boolean isNullOrEmpty(String str) {
		if(str == null || str.trim().equals("")) {
			return true;
		}
		return false;
	}
	
	public static boolean isNotNullOrEmpty(String str) {
		if(str == null || str.trim().equals("")) {
			return false;
		}
		return true;
	}

}
