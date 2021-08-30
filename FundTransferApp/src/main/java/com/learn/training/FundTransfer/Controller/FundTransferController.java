package com.learn.training.FundTransfer.Controller;

import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.training.FundTransfer.Exceptions.BankAccountNotFoundException;
import com.learn.training.FundTransfer.Exceptions.TransferFundException;
import com.learn.training.FundTransfer.Model.BankAccountInfo;
import com.learn.training.FundTransfer.Model.Response;
import com.learn.training.FundTransfer.Model.TransferBalanceRequest;
import com.learn.training.FundTransfer.Service.FundTransferringService;

@RestController
public class FundTransferController {

	@Autowired
	FundTransferringService service;
	
	@RequestMapping(value = "/createbankAccountInfo", method = RequestMethod.POST)
	public ResponseEntity<BankAccountInfo> createBankAccount(@RequestBody BankAccountInfo accountinfo){
		BankAccountInfo bankinfo=service.CreateBankAccount(accountinfo);
		return ResponseEntity.status(HttpStatus.CREATED).body(bankinfo);
	}



	@RequestMapping(value = "/getallbankAccountDetails", method = RequestMethod.GET)
	public ResponseEntity<List<BankAccountInfo>> getAllAccountDetails() throws BankAccountNotFoundException{
		List<BankAccountInfo> getaccounts=service.getAllAccounts();
		if(getaccounts==null)
			throw new BankAccountNotFoundException("unable to find the bank acocunts with the account no"+getaccounts);
	
		return ResponseEntity.status(HttpStatus.OK).body(getaccounts);
	}

	
	@PutMapping("/sendmoney")
	public ResponseEntity<ResponseEntity<Response>> SendMoney(
			@RequestBody TransferBalanceRequest transferBalanceRequest) throws TransferFundException {

		ResponseEntity<Response> transfer = service.TransferBalanceRequest(transferBalanceRequest);
		return ResponseEntity.status(HttpStatus.OK).body(transfer);

	}

}
