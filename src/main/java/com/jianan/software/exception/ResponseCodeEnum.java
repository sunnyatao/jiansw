package com.jianan.software.exception;

public enum ResponseCodeEnum {
	
	SuccessCode(1,"Success"),
	FailureCode(2,"系统繁忙，请稍后重试！"),
	ServerApiFailureCode(2,"服务异常"),
	PasswordErrorcode(3, "密码错误"),
	InvalidParameter(5,"非法的参数");
	
	 private final int code;
	 private final String reason;
	 
	 private ResponseCodeEnum(int code,String reason) {
	    this.code = code;
	    this.reason= reason;
	 }
	 
	 public int getCode(){
		 return this.code;
	 }
	 public String getReason(){
		 return this.reason;
	 }
}
