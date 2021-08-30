package com.learn.training.FundTransfer.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.training.FundTransfer.Exceptions.BankAccountNotFoundException;
import com.learn.training.FundTransfer.Exceptions.TransferFundException;
import com.learn.training.FundTransfer.Model.BankAccount;
import com.learn.training.FundTransfer.Model.Response;
import com.learn.training.FundTransfer.Model.TransferBalanceRequest;
import com.learn.training.FundTransfer.Service.FundTransferringService;

@RestController
public class FundTransferController {
	private static final Logger logger = LoggerFactory.getLogger(BeneficiaryController.class);

	@Autowired
	FundTransferringService service;
	
	@RequestMapping(value = "/createbankAccountInfo", method = RequestMethod.POST)
	public ResponseEntity<BankAccount> createBankAccount(@Valid @RequestBody BankAccount accountinfo){
		BankAccount bankinfo=service.CreateBankAccount(accountinfo);
		logger.info("Inside the createbankAccountInfo method ");
		return ResponseEntity.status(HttpStatus.CREATED).body(bankinfo);
	}



	@RequestMapping(value = "/getallbankAccountDetails", method = RequestMethod.GET)
	public ResponseEntity<List<BankAccount>> getAllAccountDetails() throws BankAccountNotFoundException{
		List<BankAccount> getaccounts=service.getAllAccounts();
		if(getaccounts==null)
			throw new BankAccountNotFoundException("unable to find the bank acocunts with the account no"+getaccounts);
	logger.info("Inside the GetAll BankAccount Details method");
		return ResponseEntity.status(HttpStatus.OK).body(getaccounts);
	}

	
	@PutMapping("/fundTransfer")
	public ResponseEntity<ResponseEntity<Response>> SendMoney(
			@RequestBody TransferBalanceRequest transferBalanceRequest) throws TransferFundException {

		ResponseEntity<Response> transfer = service.TransferBalanceRequest(transferBalanceRequest);
		
		logger.info("Inside the Transfer Fund Method");
		return ResponseEntity.status(HttpStatus.OK).body(transfer);

	}

}
