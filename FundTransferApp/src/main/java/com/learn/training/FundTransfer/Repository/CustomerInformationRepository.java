package com.learn.training.FundTransfer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.training.FundTransfer.Model.Customer;

public interface CustomerInformationRepository extends JpaRepository<Customer, Integer> {
	
	public Customer findByuserId (Integer userId);
	
	public Customer findByadharNumber(Long adharNumber);
	
	public Customer findBymobileNumber(Long mobileNumber);

}
