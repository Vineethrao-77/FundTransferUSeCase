package com.learn.training.FundTransfer.Model;

public class Response {

	private Integer statusCode;

	private String successMessage;

	private Integer accountNumber;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getSuccMsg() {
		return successMessage;
	}

	public void setSuccMsg(String succMsg) {
		this.successMessage = succMsg;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Response(Integer statusCode, String succMsg, Integer accountNumber, Integer password) {
		super();
		this.statusCode = statusCode;
		this.successMessage = succMsg;

		this.accountNumber = accountNumber;
	}

	public Response() {
		super();
	}

}
