package com.jianan.software.util;


public class SerialUtil {

	public static String generateSerialNo(String prefix, String preSerialNo) {
		if (preSerialNo == null) {
			String year = DateUtil.getYear();
			return prefix + year + "0001";
		}
		String year = preSerialNo.substring(1, 5);
		if (year.equals(DateUtil.getYear())) {
			int num = Integer.parseInt(preSerialNo.substring(5, 9)) + 1;
			String serial = String.valueOf(num);
			if (serial.length() == 1) {
				serial = "000" + serial;
			} else if (serial.length() == 2) {
				serial = "00" + serial;
			} else if (serial.length() == 3) {
				serial = "0" + serial;
			}
			return prefix + year + serial;
		} else {
			return prefix + DateUtil.getYear() + "0001";
		}
	}
	
	public static String nextTaxNumber(String currentTaxNum) {
		if (currentTaxNum == null || "".equals(currentTaxNum)) {
			return "001";
		}
		
		int value = Integer.parseInt(currentTaxNum) + 1;
		if (value < 10) {
			return "00" + value;
		} else if (value >= 10 && value < 100) {
			return "0" + value;
		} else {
			return String.valueOf(value);
		}
	}
	
	public static String nextTaxNumber(int currentTaxNo) {
		int value = currentTaxNo + 1;
		if (value < 10) {
			return "00" + value;
		} else if (value >= 10 && value < 100) {
			return "0" + value;
		} else {
			return String.valueOf(value);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(nextTaxNumber(99));
	}
}
