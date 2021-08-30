package com.learn.training.FundTransfer.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.training.FundTransfer.Exceptions.BeneficiaryNotFoundException;
import com.learn.training.FundTransfer.Model.Beneficiary;
import com.learn.training.FundTransfer.Service.BeneficiaryService;

@RestController
public class BeneficiaryController {

	private static final Logger logger = LoggerFactory.getLogger(BeneficiaryController.class);
	@Autowired
	BeneficiaryService service;

	@PostMapping("/CreateBeneficiary")
	public ResponseEntity<Beneficiary> createBeneficiary(@Valid @RequestBody Beneficiary beneficiary) {
		Beneficiary user = service.CreateBeneficiary(beneficiary);
		if (user == null)
			throw new BeneficiaryNotFoundException("unable to create Beneficairy");
		logger.info("Inside the CreateBeneficiary Account Method");
		return ResponseEntity.status(HttpStatus.CREATED).body(user);

	}

	@RequestMapping(value = "/getallbeneficiaryDetails", method = RequestMethod.GET)
	public ResponseEntity<List<Beneficiary>> getAllAccountDetails() throws BeneficiaryNotFoundException {
		List<Beneficiary> getaccounts = service.GetAllBeneficiarys();
		if (getaccounts == null)
			throw new BeneficiaryNotFoundException(
					"unable to find the beneficiary acocunts with the account no" + getaccounts);
		logger.info("Inside the getAllBeneficiaryAccountDetails method");
		return ResponseEntity.status(HttpStatus.OK).body(getaccounts);
	}

	@RequestMapping(value = "/deleteBeneficiary/{beneficiaryId}", method = RequestMethod.DELETE)
	public HttpStatus deleteBeneficiary(@PathVariable Integer beneficiaryId) {
		service.DeleteBeneficiary(beneficiaryId);
		logger.info("Inside the DeleteBeneficiary Method");
		return HttpStatus.ACCEPTED;
	}

}
