package com.learn.training.FundTransfer.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.training.FundTransfer.DTO.CustomerDTO;
import com.learn.training.FundTransfer.Exceptions.AdharNotFoundException;
import com.learn.training.FundTransfer.Exceptions.IdNotFoundException;
import com.learn.training.FundTransfer.Exceptions.UnableToCreateCustomer;
import com.learn.training.FundTransfer.Model.Customer;
import com.learn.training.FundTransfer.Model.Response;
import com.learn.training.FundTransfer.Service.CustomerInformationService;

@RestController
public class CustomRegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(CustomRegistrationController.class);
	@Autowired
	CustomerInformationService service;

	@RequestMapping(value = "/getcustomerBy/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Customer> GetByUserId(@PathVariable Integer userId) throws IdNotFoundException {
		Customer customerinfo = service.getByuserId(userId);
		if (customerinfo == null)
			throw new IdNotFoundException("Customer Id Not Found with " + userId);
		logger.info("inside the GetByUserId method");
		return ResponseEntity.status(HttpStatus.OK).body(customerinfo);

	}

	@RequestMapping(value = "/getcustomerByUidai/{adharNumber}", method = RequestMethod.GET)
	public ResponseEntity<Customer> GetByAdharNumber(@PathVariable Long adharNumber) throws AdharNotFoundException {

		Customer customerinfo = service.getByAdharNumber(adharNumber);
		if (customerinfo == null)
			throw new AdharNotFoundException("Adhar number not found with the " + adharNumber);
		logger.info("inside the GetByAdharNumber method");
		return ResponseEntity.status(HttpStatus.OK).body(customerinfo);

	}

	@RequestMapping(value = "/createcustomer", method = RequestMethod.POST)
	public ResponseEntity<Customer> CreateCustomerInfo(@Valid @RequestBody Customer customerregistartioninfo) {
		Response response = null;
		Customer customerinfo = service.CreateCustomerInfo(customerregistartioninfo);
		if (customerinfo != null) {

			response = new Response();
			response.setSuccMsg("Successfully created user");
			response.setStatusCode(200);
		} else {
			throw new UnableToCreateCustomer("Unable to create customer please check the details");
		}
		logger.info("inside the CreateCustomer method");
		return ResponseEntity.status(HttpStatus.CREATED).body(customerinfo);

	}

	@RequestMapping(value = "/getallcustomersInfo", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> GetAllCutomers() {
		List<Customer> customerinfo = service.GetAllCustomers();
		logger.info("inside the GetAllCustomers method");
		return ResponseEntity.status(HttpStatus.OK).body(customerinfo);

	}

	@PutMapping("/updatecustomeruserinfo/{userId}")
	public ResponseEntity<String> UpdateCustomerInfo(@PathVariable Integer userId, @RequestBody Customer user)
			throws IdNotFoundException {

		Customer customerinfo = service.getByuserId(userId);
		if (customerinfo.getUserId() == null)
			throw new IdNotFoundException("Id not found with the userid" + userId);

		customerinfo.setAddress(user.getAddress());
		customerinfo.setAdharNumber(user.getAdharNumber());
		customerinfo.setEmailId(user.getEmailId());
		customerinfo.setMobileNumber(user.getMobileNumber());
		customerinfo.setUserName(user.getUserName());
		Customer updatedetails = service.UpdateCustomerInfo(customerinfo);
		return new ResponseEntity<String>(HttpStatus.OK);

	}

	@DeleteMapping("/deletecustomerinfo/{userId}")
	public HttpStatus deleteProduct(@PathVariable Integer userId) {
		service.DeleteCustomerInfo(userId);
		return HttpStatus.OK;
	}

	

	public ResponseEntity<?> CreateCustomerInfo(CustomerDTO customerdto) {
		// TODO Auto-generated method stub
		CustomerDTO dto=  service.CreateCustomerInfo(customerdto);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
				}
}
