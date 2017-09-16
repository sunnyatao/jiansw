package com.jianan.software.util;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


public class DataUtil {

	public static Map<String, String> small2big = new HashMap<String, String>();
	
	static {
		small2big.put("0", "零");
		small2big.put("1", "壹");
		small2big.put("2", "贰");
		small2big.put("3", "叁");
		small2big.put("4", "肆");
		small2big.put("5", "伍");
		small2big.put("6", "陆");
		small2big.put("7", "柒");
		small2big.put("8", "捌");
		small2big.put("9", "久");
	}
	
	
	/**
	 * 将数值转换成大写:
	 * 100: 壹佰整
	 * 1300.05元，大写换算为壹仟叁佰圆零伍分。
	 * @param data
	 * @return
	 */
	public static String chang2Big(double data) {
		String vdata = String.valueOf(data);
		StringBuilder bdbuilder = new StringBuilder();
		for (int i = 0; i < vdata.length(); i++) {
			String cbigData = small2big.get(String.valueOf(vdata.charAt(i)));
			if (".".equals(cbigData)) {
				continue;
			}
			bdbuilder.append(cbigData);
		}
		return bdbuilder.toString();
	}
	
	public static String hangeToBig(double value) {  
        char[] hunit = { '拾', '佰', '仟' }; // 段内位置表示  
        char[] vunit = { '万', '亿' }; // 段名表示  
        char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' }; // 数字表示  
        long midVal = (long) (value * 100); // 转化成整形  
        String valStr = String.valueOf(midVal); // 转化成字符串  
  
        String head = valStr.substring(0, valStr.length() - 2); // 取整数部分  
        String rail = valStr.substring(valStr.length() - 2); // 取小数部分  
  
        String prefix = ""; // 整数部分转化的结果  
        String suffix = ""; // 小数部分转化的结果  
        // 处理小数点后面的数  
        if (rail.equals("00")) { // 如果小数部分为0  
            suffix = "整";  
        } else {
        	if (rail.charAt(0) == '0') {
        		suffix = digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来  
        	} else {
        		suffix = digit[rail.charAt(0) - '0'] + "角" + digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
        	}
        }  
        // 处理小数点前面的数  
        char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组  
        char zero = '0'; // 标志'0'表示出现过0  
        byte zeroSerNum = 0; // 连续出现0的次数  
        for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字  
            int idx = (chDig.length - i - 1) % 4; // 取段内位置  
            int vidx = (chDig.length - i - 1) / 4; // 取段位置  
            if (chDig[i] == '0') { // 如果当前字符是0  
                zeroSerNum++; // 连续0次数递增  
                if (zero == '0') { // 标志  
                    zero = digit[0];  
                } else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {  
                    prefix += vunit[vidx - 1];  
                    zero = '0';  
                }  
                continue;  
            }  
            zeroSerNum = 0; // 连续0次数清零  
            if (zero != '0') { // 如果标志不为0,则加上,例如万,亿什么的  
                prefix += zero;  
                zero = '0';  
            }  
            prefix += digit[chDig[i] - '0']; // 转化该数字表示  
            if (idx > 0)  
                prefix += hunit[idx - 1];  
            if (idx == 0 && vidx > 0) {  
                prefix += vunit[vidx - 1]; // 段结束位置应该加上段名如万,亿  
            }  
        }  
  
        if (prefix.length() > 0)  
            prefix += '圆'; // 如果整数部分存在,则有圆的字样  
        return prefix + suffix; // 返回正确表示  
    }  
	
	public static String toChineseCurrency(Number o) {
        String s = new DecimalFormat("#.00").format(o);  
        System.out.println(s);  
        s = s.replaceAll("\\.", "");  
        char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };  
        String unit = "仟佰拾兆仟佰拾亿仟佰拾万仟佰拾元角分";  
        int l = unit.length();  
        StringBuffer sb = new StringBuffer(unit);  
        for (int i = s.length() - 1; i >= 0; i--)  
            sb = sb.insert(l - s.length() + i, digit[(s.charAt(i) - 0x30)]);  
        s = sb.substring(l - s.length(), l + s.length());  
        s = s.replaceAll("零[拾佰仟]", "零").replaceAll("零{2,}", "零").replaceAll("零([兆万元])", "$1").replaceAll("零[角分]", "");  
        if (s.endsWith("角"))  
            s += "零分";  
        if (!s.contains("角") && !s.contains("分") && s.contains("元"))  
            s += "整";  
        if (s.contains("分") && !s.contains("整") && !s.contains("角"))  
            s = s.replace("元", "元零");  
        return s;  
    }  
	
	public static String changeZF(double value) {
		String sValue = String.valueOf(value);
		if (sValue.endsWith(".00") || sValue.endsWith(".0")) {
			return sValue.split("\\.")[0];
		}
		return sValue;
	}
	
	public static void main(String[] args) {
		//System.out.println(hangeToBig(1300.05));
		//System.out.println(hangeToBig(100000));
		System.out.println(toChineseCurrency(100000));
		System.out.println(toChineseCurrency(1300.05));
		
		System.out.println(changeZF(12.00));
		System.out.println(changeZF(12.0));
		System.out.println(changeZF(12.01));
		
		System.out.println(Integer.parseInt("0011"));
	}
}
