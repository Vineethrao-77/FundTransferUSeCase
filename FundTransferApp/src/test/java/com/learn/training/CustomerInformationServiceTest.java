package com.learn.training;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.learn.training.FundTransfer.Controller.CustomRegistrationController;
import com.learn.training.FundTransfer.DTO.CustomerDTO;
import com.learn.training.FundTransfer.Model.Customer;
import com.learn.training.FundTransfer.Repository.CustomerInformationRepository;
import com.learn.training.FundTransfer.Service.CustomerInformationService;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerInformationServiceTest {
	@Mock
	CustomerInformationService customerservice;
	@Mock
	CustomerInformationRepository repo;
	
	@InjectMocks
	CustomRegistrationController customercontroller;
	
	
	static Customer customer;
	static CustomerDTO customerdto;
	
	@BeforeAll
	public void setUp() {
		customerdto =new CustomerDTO();
		
		customerdto.setAddress("Hyderabad");
		customerdto.setAdharNumber("123456789");
		customerdto.setEmailId("vineeth@gmail.com");
		customerdto.setMobileNo("9959668508");
		customerdto.setState("Telangana");
		customerdto.setUserName("vineeth");
		
	}
		@Test
		@DisplayName("Customer creation :: Postive Scenario")
		@Order(1)
		public void customercreationtest() {
		when(customerservice.CreateCustomerInfo(customerdto)).thenReturn(customerdto);
			ResponseEntity<?> result = customercontroller.CreateCustomerInfo(customerdto);
			assertEquals(HttpStatus.OK, result.getStatusCode());
		}
		
	
}
	
	


