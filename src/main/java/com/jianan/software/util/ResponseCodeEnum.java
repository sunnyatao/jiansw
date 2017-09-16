package com.jianan.software.util;


public enum ResponseCodeEnum {
	
	SuccessCode(1,"Success"),
	FailureCode(2,"系统繁忙，请稍后重试！"),
	ServerApiFailureCode(2,"ServerApiFailureCode"),
	InvalidParameter(5,"InvalidParameter"),
	
	UserNotLoginError(10,"UserNotLoginError"),
	ThisTagNameHasUsedError(1000, "改标签名称已经被使用了"),
	NoServiceUriAvailable(21,"NoServiceUriAvailable"),
	
	SystemErrorLoginException(200,"系统繁忙，请稍后重试！"),
	SystemErrorNameOrPassException(201,"账号或者密码错误！"),
	ShopShowIsExpiredException(201,"快递参数异常：该单号不存在或者已经过期.."),
	
	SystemErrorLoginTypeException(202,"登录的账号类型错误！"),
	
	RegisterCheckCodeErrorException(146,"验证码验证失败！"),
	RegisterUserIsExistErrorException(204,"用户已经存在！"),
	EmailFormatErrorException(205,"邮件格式不正确！"),
	EmailIsValidErrorException(206,"邮箱认证失败！"),
	RenewPassUserIsExistErrorException(207,"用户不存在！"),
	OldPasswordErrorException(146,"old password error！"),
	GoodsIsExitsError(147,"goods is exits error！"),
	
	
	MD5EncodeError(101,"MD5EncodeError"),
	IllegalCharacter(102,"IllegalCharacter"),
	OutOfLength(103,"OutOfLength"), 
	ErrorAccountFormat(104,"ErrorAccountFormat"),
	GenSessionTokenError(105,"GenSessionTokenError"), 
	CryptographicError(110,"CryptographicError"),
	BounsValIsNotValid(111,"红包序列不正确"), 
	BonusCantUse(112, "该红包对于该订单不可用"), 
	AdminNotLogin(113, "您的登录过期了或者还未登录请重新登录"),
	OpenIdKeyNotfound(114,"openIdKey不存在"),
	OpenIdNotfound(115,"openId不存在"),
	ActivityIsOver(116,"活动已经结束"),
	BonusGrantFail(117,"兑换券发放失败"),
	ActivityOverdue(118,"活动已经失效"),
	ExistVersionCode(120,"code已经存在"),
	NotMaxVersionCode(121,"code不是最大值"),
	CardisUsedError(1503, "该卡已经被使用了，请核对后重试或联系客服"),
	CheckCodeNumberError(169, "发送短信24小时不能超过5条"),
	EmptyCartError(401, "购物车中未找到所选商品"),
	Network404(404, "找不到目标地址"),
	Network500(500, "服务器内部错误"),
	AbnormalUserException(1507, "用户异常, 请联系客服(400-016-0022)"), 
	ClientRequestTimeOutError(1508, "请求时间超过了服务器允许的误差时间");
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
