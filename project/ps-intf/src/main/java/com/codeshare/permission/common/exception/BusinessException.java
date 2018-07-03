package com.codeshare.permission.common.exception;


import com.codeshare.permission.common.ResponseConstant;

/**
 * 业务异常
 * @author Ivan Shen
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	/**异常对应的返回码*/
	private int code = ResponseConstant.FAILED.intValue();
	/**异常对应的描述信息*/
	private String msg = ResponseConstant.FAILED_MSG;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
		msg = message;
	}

	public BusinessException(int code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	

}
