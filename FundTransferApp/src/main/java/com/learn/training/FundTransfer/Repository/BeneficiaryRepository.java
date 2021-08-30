package com.learn.training.FundTransfer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.training.FundTransfer.Model.Beneficiary;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer>{
	
	public Beneficiary findByaccountNumber(Integer accountNumber);

}
