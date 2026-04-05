package org.springboot.codingpills.service;

import java.util.List;

import org.springboot.codingpills.entity.Companies;
import org.springboot.codingpills.entity.ResponseStructure;
import org.springboot.codingpills.exception.CompaniesNotFoundException;
import org.springboot.codingpills.repository.CompaniesRepository;
import org.springboot.codingpills.repository.StockDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompaniesService {

	@Autowired
	CompaniesRepository companiesRepository;
	@Autowired
	StockDataRepository stockDataRepository;

	public ResponseEntity<ResponseStructure<Companies>> createCompany(Companies companies) {
		ResponseStructure<Companies> structure = new ResponseStructure<>();
		structure.setData(companiesRepository.save(companies));
		structure.setMessage("Saved Sucessfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Companies>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Companies>>> getAllCompanies() {
		ResponseStructure<List<Companies>> structure = new ResponseStructure<>();
		List<Companies> recCompanies = companiesRepository.findAll();
		if (recCompanies.size() > 0) {

			structure.setData(recCompanies);
			structure.setMessage("Saved Sucessfully");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<List<Companies>>>(structure, HttpStatus.CREATED);
		}
		throw new CompaniesNotFoundException("! Companies Not Found");
	}

}




















