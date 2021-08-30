package com.learn.training.FundTransfer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.learn.training.FundTransfer.Model.BankAccountInfo;

public interface BankRepository extends JpaRepository<BankAccountInfo, Long> {
	
	public BankAccountInfo findByaccountNumber(Integer accountNumber);

	public void save(Float currentSourceAmount);
	
	

//public Integer updateByaccountNumber(@Param("amount") Float amount, @Param("accountNumber") Integer accountNumber);
}
