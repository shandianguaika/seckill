package org.common.utils;

/**
 *  封装返回信息
 * @author 小宇宙
 * @date 2018年10月31日
 * @param <T>
 */
public class Result<T> {

	private boolean success;
	
	private T data;
	
	private String error;
	
	private String code;
	
	public Result(boolean success, T data, String error, String code) {
		super();
		this.success = success;
		this.data = data;
		this.error = error;
		this.code = code;
	}


	public Result(boolean success, T data, String error) {
		super();
		this.success = success;
		this.data = data;
		this.error = error;
	}


	public Result(boolean success, String error) {
		super();
		this.success = success;
		this.error = error;
	}


	public Result(T data) {
		super();
		this.data = data;
	}


	public Result() {
		super();
	}


	public Result(boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}


	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
