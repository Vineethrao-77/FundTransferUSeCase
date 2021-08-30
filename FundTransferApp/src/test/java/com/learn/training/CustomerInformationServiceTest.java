package com.learn.training;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.learn.training.FundTransfer.Controller.CustomRegistrationController;
import com.learn.training.FundTransfer.Model.BankAccountInfo;
import com.learn.training.FundTransfer.Model.Beneficiary;
import com.learn.training.FundTransfer.Model.Customer;
import com.learn.training.FundTransfer.Repository.CustomerInformationRepository;
import com.learn.training.FundTransfer.Service.CustomerInformationService;

@ExtendWith(MockitoExtension.class)
public class CustomerInformationServiceTest {

	@Mock
	private CustomerInformationService customerService;

	@Mock
	private CustomRegistrationController controller;

	@Mock
	CustomerInformationRepository repo;

	static Customer customerinfo;

static Beneficiary beneficiary;

static BankAccountInfo bankaccounts;

	@BeforeAll
	public static void setUp() {

		customerinfo = new Customer();
		customerinfo.setAddress("hyd");
		customerinfo.setAdharNumber((long) 123567890);
		customerinfo.setEmailId("vin@gmail.com");
		customerinfo.setMobileNumber((long) 995966850);
		customerinfo.setUserId(12);
		customerinfo.setUserName("vineeth");

		

	}

	@Test
	@DisplayName("Save customer   :: Postive Scenario")
	public void createcustomer() {
		ResponseEntity<Customer> response = controller.CreateCustomerInfo(customerinfo);
		verify(customerService).CreateCustomerInfo(customerinfo);
		assertEquals(HttpStatus.OK, controller.CreateCustomerInfo(customerinfo).getStatusCode());
		
	}
	}

	