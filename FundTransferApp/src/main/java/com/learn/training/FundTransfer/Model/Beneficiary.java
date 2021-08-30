package com.learn.training.FundTransfer.Model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Beneficiary {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="beneficiary_id")
	 private Integer beneficiaryId;
	
	private Integer accountNumber;

	private String AccountOwner;

	private String IFSCCode;

	private String branchName;

	private BigDecimal currentBalance;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Customer customerinformation;

	public Integer getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountOwner() {
		return AccountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		AccountOwner = accountOwner;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Customer getCustomerinformation() {
		return customerinformation;
	}

	public void setCustomerinformation(Customer customerinformation) {
		this.customerinformation = customerinformation;
	}

	public Beneficiary(Integer beneficiaryId, Integer accountNumber, String accountOwner, String iFSCCode,
			String branchName, BigDecimal currentBalance, Customer customerinformation) {
		super();
		this.beneficiaryId = beneficiaryId;
		this.accountNumber = accountNumber;
		AccountOwner = accountOwner;
		IFSCCode = iFSCCode;
		this.branchName = branchName;
		this.currentBalance = currentBalance;
		this.customerinformation = customerinformation;
	}

	public Beneficiary() {
		super();
	}

	
	
}
