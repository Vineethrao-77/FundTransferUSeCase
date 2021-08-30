package com.learn.training.FundTransfer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.training.FundTransfer.Model.Beneficiary;
import com.learn.training.FundTransfer.Repository.BeneficiaryRepository;

@Service
public class BeneficiaryService {
	
	@Autowired 
	BeneficiaryRepository repository;
	
	public Beneficiary CreateBeneficiary(Beneficiary beneficiary) {
		return repository.save(beneficiary);
		
	}
public List<Beneficiary> GetAllBeneficiarys() {
	return repository.findAll();
}

public void DeleteBeneficiary(Integer beneficiaryId) {
	repository.deleteById(beneficiaryId);
}

}
