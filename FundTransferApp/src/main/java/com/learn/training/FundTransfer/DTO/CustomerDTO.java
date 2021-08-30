package com.learn.training.FundTransfer.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 3994192272098493497L;

	@NotEmpty(message = "provide user name for login")
	@Size(min = 5, max = 50)
	@Pattern(regexp = "[a-zA-Z0-9]+")
	private String userName;

	@NotNull(message = "provide mobile no ,only digits")
	@Pattern(regexp = "[0-9]{10}", message = "provide valid mobile no")
	private String mobileNo;

	@NotEmpty(message = "Provide email id")
	@Email
	private String emailId;

	@NotNull(message = "provide aadhaar number,only digits ")
	@Pattern(regexp = "[0-9]{12}", message = "provide valid aadhaar number")
	private String adharNumber;

	@NotEmpty(message = "Provide Customer Address1")
	@Size(min = 10, max = 100, message = "Address must be between 10 and 100 characters")
	private String address;

	@NotEmpty(message = "provide state")
	@Pattern(regexp = "[a-zA-Z]+", message = "provide valid state")
	private String state;

	public CustomerDTO(
			@NotEmpty(message = "provide user name for login") @Size(min = 5, max = 50) @Pattern(regexp = "[a-zA-Z0-9]+") String userName,
			@NotNull(message = "provide mobile no ,only digits") @Pattern(regexp = "[0-9]{10}", message = "provide valid mobile no") String mobileNo,
			@NotEmpty(message = "Provide email id") @Email String emailId,
			@NotNull(message = "provide aadhaar number,only digits ") @Pattern(regexp = "[0-9]{12}", message = "provide valid aadhaar number") String adharNumber,
			@NotEmpty(message = "Provide Customer Address1") @Size(min = 10, max = 100, message = "Address must be between 10 and 100 characters") String address,
			@NotEmpty(message = "provide state") @Pattern(regexp = "[a-zA-Z]+", message = "provide valid state") String state) {
		super();
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.adharNumber = adharNumber;
		this.address = address;
		this.state = state;
	}

	public CustomerDTO() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
