package com.learn.training.Testcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.learn.training.FundTransfer.Controller.BeneficiaryController;
import com.learn.training.FundTransfer.DTO.BeneficiaryDTO;
import com.learn.training.FundTransfer.Model.Beneficiary;
import com.learn.training.FundTransfer.Repository.BeneficiaryRepository;
import com.learn.training.FundTransfer.Service.BeneficiaryService;

@ExtendWith(MockitoExtension.class)
public class BeneficiaryTestController {

	@Mock
	BeneficiaryService beneficiaryservice;

	@InjectMocks
	BeneficiaryController controller;
	static Beneficiary beneficiary;
	static BeneficiaryDTO dto;

	@BeforeAll
	public static void setUp() {
		beneficiary = new Beneficiary();
		beneficiary.setAccountNumber(11);
		beneficiary.setAccountOwner("vineeth");
		beneficiary.setBeneficiaryId(1);
		beneficiary.setBranchName("HDFC");
		beneficiary.setCurrentBalance(new BigDecimal(50000));
		beneficiary.setCustomerinformation(null);
		beneficiary.setIFSCCode("HDFC12");

	}

	@Test
	@DisplayName("Save Beneficiary   :: Postive Scenario")
	public void addBeneficiaryTest() {
		controller.createBeneficiary(beneficiary);
		verify(beneficiaryservice).CreateBeneficiary(beneficiary);
	}
	
	@Test
	@Order(2)
	@DisplayName("get all beneficiarys   :: Postive Scenario")
	public void getallbeneficiaryDetailsTest() {
		controller.getAllAccountDetails();
		verify(beneficiaryservice).GetAllBeneficiarys();
	}

}


