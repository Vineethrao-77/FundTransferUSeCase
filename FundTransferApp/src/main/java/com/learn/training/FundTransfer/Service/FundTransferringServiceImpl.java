package com.learn.training.FundTransfer.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learn.training.FundTransfer.Exceptions.TransferFundException;
import com.learn.training.FundTransfer.Model.BankAccountInfo;
import com.learn.training.FundTransfer.Model.Beneficiary;
import com.learn.training.FundTransfer.Model.Response;
import com.learn.training.FundTransfer.Model.TransferBalanceRequest;
//import com.learn.training.FundTransfer.Repository.BankRepository;
import com.learn.training.FundTransfer.Repository.BankRepository;
import com.learn.training.FundTransfer.Repository.BeneficiaryRepository;

@Service
public class FundTransferringServiceImpl implements FundTransferringService {
	@Autowired
	BankRepository repo;

	@Autowired
	BeneficiaryRepository beneficiaryrepo;

	public ResponseEntity<Response> TransferBalanceRequest(TransferBalanceRequest transferBalanceRequest)
			throws TransferFundException {

		Response response = null;

		Integer fromaccountnumber = transferBalanceRequest.getFromAccountNumber();
		Integer toAccountnumber = transferBalanceRequest.getToAcccountNumber();
		BigDecimal amount = transferBalanceRequest.getAmount();
		BankAccountInfo fromAccount = repo.findByaccountNumber(fromaccountnumber);
		Beneficiary toAccount = beneficiaryrepo.findByaccountNumber(toAccountnumber);
		if (fromAccount.getAvailableBalance().compareTo(BigDecimal.ONE) == 1
				&& fromAccount.getAvailableBalance().compareTo(amount) == 1) {
			fromAccount.setAvailableBalance(fromAccount.getAvailableBalance().subtract(amount));
			repo.save(fromAccount);
			toAccount.setCurrentBalance(toAccount.getCurrentBalance().add(amount));
			beneficiaryrepo.save(toAccount);
			if (fromAccount != null && toAccount != null) {
				response = new Response();
				response.setSuccMsg("Successfully Transfer the money");
				response.setAccountNumber(toAccountnumber);
				response.setStatusCode(200);

			} else {
				throw new TransferFundException("failed to transfer the money");

			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@Override
	public List<BankAccountInfo> getAllAccounts() {
		return repo.findAll();
	}

	@Override
	public BankAccountInfo findByaccounNumber(Integer accountNumber) {

		return repo.findByaccountNumber(accountNumber);
	}

	@Override
	public BankAccountInfo CreateBankAccount(BankAccountInfo accountinfo) {
		return repo.save(accountinfo);
	}

}