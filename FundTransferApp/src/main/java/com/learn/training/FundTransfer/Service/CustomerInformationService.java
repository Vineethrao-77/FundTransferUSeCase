package com.learn.training.FundTransfer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.training.FundTransfer.DTO.CustomerDTO;
import com.learn.training.FundTransfer.Model.Customer;
import com.learn.training.FundTransfer.Repository.CustomerInformationRepository;

@Service
public class CustomerInformationService {
	@Autowired
	CustomerInformationRepository repo;

	public Customer getByuserId(Integer userId) {
//		if (Optional.ofNullable(repo.findByUserName(userI.getUserName())).isPresent())
//			throw new UserNameAlreadyExistsException("User Name already exists.Please try with another user name");

		return repo.findByuserId(userId);
	}

	public Customer getByAdharNumber(Long adharNumber) {
		return repo.findByadharNumber(adharNumber);
	}

	public Customer getByMobileNumber(Long mobileNumber) {
		return repo.findBymobileNumber(mobileNumber);
	}

	public Customer CreateCustomerInfo(Customer CustomerRegistrationInfo) {

		return repo.save(CustomerRegistrationInfo);
	}

	public List<Customer> GetAllCustomers() {
		return repo.findAll();
	}

	public Customer UpdateCustomerInfo(Customer CustomerRegistrationInfo) {
		return repo.save(CustomerRegistrationInfo);
	}

	public void DeleteCustomerInfo(Integer userId) {
		repo.deleteById(userId);
	}

	public CustomerDTO CreateCustomerInfo(CustomerDTO customerdto) {
		// TODO Auto-generated method stub
		return repo.save(customerdto);
	}

	
	

}
