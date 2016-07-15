package br.com.guardaqui.exception;

public class BusinessException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private int retCode;
	
	public BusinessException(int retCode, String message){
		super(message);
		this.retCode = retCode;
	}

	public int getRetCode() {
		return retCode;
	}

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	
}
