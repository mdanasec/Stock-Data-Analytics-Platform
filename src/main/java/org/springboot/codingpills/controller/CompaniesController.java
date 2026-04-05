package org.springboot.codingpills.controller;

import java.util.List;

import org.springboot.codingpills.entity.Companies;
import org.springboot.codingpills.entity.ResponseStructure;
import org.springboot.codingpills.service.CompaniesService;
import org.springboot.codingpills.service.StockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

	@Autowired
	CompaniesService companiesService;

	@PostMapping("/createCompany")
	public ResponseEntity<ResponseStructure<Companies>> createCompany(@RequestBody Companies companies) {
		return companiesService.createCompany(companies);

	}

	@GetMapping("/")
	public ResponseEntity<ResponseStructure<List<Companies>>> getAllCompanies() {
		return companiesService.getAllCompanies();
	}

}
