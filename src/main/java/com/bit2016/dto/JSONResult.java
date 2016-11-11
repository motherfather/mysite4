package com.bit2016.dto;

//@SuppressWarnings("unused") 전구모양뜨는거 보기 싫을 때
public class JSONResult {
	private String result; // "success" or "fail"
	private String message; // result가 "fail"일 때의 원인
	private Object data; // result가 "success"일 때 전달해야 할 데이터 객체
	
	public String getResult() {
		return result;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
	
	public static JSONResult success(Object data) {
		return new JSONResult(true, data, null);
	}
	
	public static JSONResult error(String message) {
		return new JSONResult(false, null, message);
	}
	
	private JSONResult() {
	}

	private JSONResult(boolean isSuccess, Object data, String message) {
		result = isSuccess ? "success" : "fail";
		this.data = data;
		this.message = message;
	}
}
