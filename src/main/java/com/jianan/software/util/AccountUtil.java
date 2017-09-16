package com.jianan.software.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AccountUtil {
	private static final Logger logger = LoggerFactory.getLogger(AccountUtil.class);
	public static final int AccountTyeMobile =1;
	public static final int AccountTyeEmail =2;
	public static final int AccountTyeUserName=4;
	public static final String PWDMD5="1";
	public static final String PWDPRESALT="2";
	public static final String PWD_SUF_SALT="3";
	
	
	public static void verifyValidPassword(String password){
		//只能是26字母或者数字加_
		Pattern pattern =  Pattern.compile("^[_a-zA-Z0-9]+$");
		Matcher matches = pattern.matcher(password);
		boolean matche = matches.matches();
		if (!matche) {
			try {
				throw new Exception("password "+password+" Illegal  Character！");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*
	 * 编译密码函数
	 * md5password 加密密码
	 * ecSalt             默认md5加密后置验证串
	 */
	public static String  compilePassword(String md5password,String ecSalt){
		 if( ecSalt ==null  || "".equals(ecSalt) || ecSalt.equals("0") ){
			 return md5password;
        }
		
    	try {
       		return MD5Utils.md5Encode(md5password+ecSalt);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(compilePassword("123456", "1"));
	}
	/*
	 * 编译密码函数
	 * md5password 加密密码
	 * salt                 验证串加密方式
	 */
	public static String  compilePayPassword(String md5password,String salt){
		 if(salt==null || "".equals(salt) || salt.equals("0")) {
			 return md5password;
        }
		 
		try {
       		return MD5Utils.md5Encode(md5password+salt);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void verifyValidUserName(String userName){
		
		//只能是26字母或者汉字加_
		Pattern pattern =  Pattern.compile("^[\u4e00-\u9fa5_a-zA-Z0-9]+$");
		Matcher matches = pattern.matcher(userName);
		boolean matche = matches.matches();
		if (!matche) {
			try {
				throw new Exception("userName "+userName+" Illegal  Character！");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
