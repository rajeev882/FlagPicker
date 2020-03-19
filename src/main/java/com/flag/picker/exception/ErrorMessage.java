package com.flag.picker.exception;

public class ErrorMessage {
	private String moduleName;
	private String errorStack;
	private String errorMessage;
	
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorStack() {
		return errorStack;
	}
	public void setErrorStack(String errorStack) {
		this.errorStack = errorStack;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	
	
}
