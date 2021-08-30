package com.learn.training.FundTransfer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Optional;
import com.learn.training.FundTransfer.Exceptions.BankAccountNotFoundException;
import com.learn.training.FundTransfer.Exceptions.BeneficiaryNotFoundException;
import com.learn.training.FundTransfer.Model.BankAccountInfo;
import com.learn.training.FundTransfer.Model.Beneficiary;
import com.learn.training.FundTransfer.Service.BeneficiaryService;

@RestController
public class BeneficiaryController {
	@Autowired
	BeneficiaryService service;

	@PostMapping("/CreateBeneficiary")
	public ResponseEntity<Beneficiary> createBeneficiary(@RequestBody Beneficiary beneficiary) {
		Beneficiary user = service.CreateBeneficiary(beneficiary);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);

	}

	@RequestMapping(value = "/getallbeneficiaryDetails", method = RequestMethod.GET)
	public ResponseEntity<List<Beneficiary>> getAllAccountDetails() throws BeneficiaryNotFoundException {
		List<Beneficiary> getaccounts = service.GetAllBeneficiarys();
		if (getaccounts == null)
			throw new BeneficiaryNotFoundException
					("unable to find the beneficiary acocunts with the account no" + getaccounts);

		return ResponseEntity.status(HttpStatus.OK).body(getaccounts);
	}

	@RequestMapping(value = "/deleteBeneficiary/{beneficiaryId}",method=RequestMethod.DELETE)
	public HttpStatus deleteBeneficiary(@PathVariable Integer beneficiaryId) {
		service.DeleteBeneficiary(beneficiaryId);
		return HttpStatus.ACCEPTED;
	}

}
