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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class TransferBalanceRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="transaction_id")
	private Long transactionId;
	private Integer FromAccountNumber;
	private Integer ToAcccountNumber;
	private BigDecimal amount;

	public Integer getFromAccountNumber() {
		return FromAccountNumber;
	}

	public void setFromAccountNumber(Integer fromAccountNumber) {
		FromAccountNumber = fromAccountNumber;
	}

	public Integer getToAcccountNumber() {
		return ToAcccountNumber;
	}

	public void setToAcccountNumber(Integer toAcccountNumber) {
		ToAcccountNumber = toAcccountNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private BankAccountInfo accountinfo;

	public TransferBalanceRequest(Integer fromAccountNumber, Integer toAcccountNumber, BigDecimal amount,
			BankAccountInfo accountinfo) {
		super();
		FromAccountNumber = fromAccountNumber;
		ToAcccountNumber = toAcccountNumber;
		this.amount = amount;
		this.accountinfo = accountinfo;
	}

	public TransferBalanceRequest() {
		super();
	}

	public BankAccountInfo getAccountinfo() {
		return accountinfo;
	}

	public void setAccountinfo(BankAccountInfo accountinfo) {
		this.accountinfo = accountinfo;
	}

}
