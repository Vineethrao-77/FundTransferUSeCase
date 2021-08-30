package com.learn.training.FundTransfer.Model;

import java.math.BigDecimal;
import java.util.List;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BankAccountInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private Long accountId;

	@NotNull(message = "Account Number isMandatory")
	private Integer accountNumber;

	@NotEmpty(message = "IFSC is Mandatory")
	private String ifsccode;

	@NotEmpty(message = "Please provide Branch Name")
	private String branchName;

	@NotNull(message = "Please Enter Balance")
	private BigDecimal availableBalance;

//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Customer customerinformation;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TransferBalanceRequest> transferbalancerequest;

	public BankAccountInfo(Long accountId, @NotNull(message = "Account Number isMandatory") Integer accountNumber,
			@NotEmpty(message = "IFSC is Mandatory") String ifsccode,
			@NotEmpty(message = "Please provide Branch Name") String branchName,
			@NotNull(message = "Please Enter Balance") BigDecimal availableBalance,
			Customer customerinformation, List<TransferBalanceRequest> transferbalancerequest) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.ifsccode = ifsccode;
		this.branchName = branchName;
		this.availableBalance = availableBalance;
		this.customerinformation = customerinformation;
		this.transferbalancerequest = transferbalancerequest;
	}

	public BankAccountInfo() {
		super();
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Customer getCustomerinformation() {
		return customerinformation;
	}

	public void setCustomerinformation(Customer customerinformation) {
		this.customerinformation = customerinformation;
	}

	public List<TransferBalanceRequest> getTransferbalancerequest() {
		return transferbalancerequest;
	}

	public void setTransferbalancerequest(List<TransferBalanceRequest> transferbalancerequest) {
		this.transferbalancerequest = transferbalancerequest;
	}

}
