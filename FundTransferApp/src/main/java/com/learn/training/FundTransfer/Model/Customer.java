package com.learn.training.FundTransfer.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer userId;

	@NotEmpty(message = "Name can not be Blank")
	private String userName;

	@NotNull(message = "Please Enter Your Mobile Number")
	private Long mobileNumber;

	@Email(message = "Enter the valid mailid")
	private String emailId;

	@NotEmpty(message = "Please Enter your Adress")
	private String address;

	@NotNull(message = "Please Enter Your Adhar Number")
	private Long adharNumber;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private List<BankAccountInfo> bankaccounts;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private List<Beneficiary> beneficiaryDetails;

	public Customer(Integer userId, @NotEmpty(message = "Name can not be Blank") String userName,
			@NotNull(message = "Please Enter Your Mobile Number") Long mobileNumber,
			@Email(message = "Enter the valid mailid") String emailId,
			@NotEmpty(message = "Please Enter your Adress") String address,
			@NotNull(message = "Please Enter Your Adhar Number") Long adharNumber, List<BankAccountInfo> bankaccounts,
			List<Beneficiary> beneficiaryDetails) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.address = address;
		this.adharNumber = adharNumber;
		this.bankaccounts = bankaccounts;
		this.beneficiaryDetails = beneficiaryDetails;
	}

	public Customer() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(Long adharNumber) {
		this.adharNumber = adharNumber;
	}

	public List<BankAccountInfo> getBankaccounts() {
		return bankaccounts;
	}

	public void setBankaccounts(List<BankAccountInfo> bankaccounts) {
		this.bankaccounts = bankaccounts;
	}
	
	
	public List<Beneficiary> getBeneficiaryDetails() {
		return beneficiaryDetails;
	}

	public void setBeneficiaryDetails(List<Beneficiary> beneficiaryDetails) {
		this.beneficiaryDetails = beneficiaryDetails;
	}

}
