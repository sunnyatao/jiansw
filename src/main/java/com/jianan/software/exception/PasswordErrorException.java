package com.jianan.software.exception;

public class PasswordErrorException extends ServerBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PasswordErrorException(ResponseCodeEnum resCode, String verboseMsg) {
		super(ResponseCodeEnum.PasswordErrorcode, verboseMsg);
	}

}
