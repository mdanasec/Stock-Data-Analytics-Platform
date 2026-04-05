package org.springboot.codingpills.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springboot.codingpills.entity.Companies;
import org.springboot.codingpills.entity.ResponseStructure;
import org.springboot.codingpills.entity.StockData;
import org.springboot.codingpills.exception.CompaniesNotFoundException;
import org.springboot.codingpills.exception.StockDataNotFoundException;
import org.springboot.codingpills.repository.CompaniesRepository;
import org.springboot.codingpills.repository.StockDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StockDataService {

	@Autowired
	CompaniesRepository companiesRepository;
	@Autowired
	StockDataRepository stockDataRepository;

	// 1 Add stock data
	public ResponseEntity<ResponseStructure<StockData>> addStockData(StockData stockData, Long id) {

		ResponseStructure<StockData> structure = new ResponseStructure<>();

		// Check if company exists
		Optional<Companies> recCompanies = companiesRepository.findById(id);

		if (recCompanies.isPresent()) {

			Companies company = recCompanies.get();

			// Set company
			stockData.setCompany(company);

			// Calculate daily return automatically
			double dailyReturn = (stockData.getClosePrice() - stockData.getOpenPrice()) / stockData.getOpenPrice();

			stockData.setDailyReturn(dailyReturn);

			// Save stock data
			StockData savedStock = stockDataRepository.save(stockData);

			structure.setData(savedStock);
			structure.setMessage("Stock Data Saved Successfully");
			structure.setStatusCode(HttpStatus.CREATED.value());

			return new ResponseEntity<>(structure, HttpStatus.CREATED);
		}

		throw new CompaniesNotFoundException("Companies Not Found");
	}

	public ResponseEntity<ResponseStructure<List<StockData>>> getStockDataBySymbol(String symbol) {

		ResponseStructure<List<StockData>> structure = new ResponseStructure<>();
		List<StockData> recStockData = stockDataRepository.findTop30ByCompanySymbolOrderByDateDesc(symbol);
		if (recStockData.size() > 0) {
			structure.setData(recStockData);
			structure.setMessage("Last 30 days stock data fetched successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<StockData>>>(structure, HttpStatus.OK);
		}
		throw new StockDataNotFoundException("Stock Data Not Found");

	}

	public ResponseEntity<ResponseStructure<Map<String, Double>>> getStockSummary(String symbol) {

		ResponseStructure<Map<String, Double>> structure = new ResponseStructure<>();

		// Fetch calculated values from repository
		Double high = stockDataRepository.findMaxHighPriceByCompanySymbol(symbol);
		Double low = stockDataRepository.findMinLowPriceByCompanySymbol(symbol);
		Double avg = stockDataRepository.findAvgClosePriceByCompanySymbol(symbol);

		// Store values in map
		Map<String, Double> summary = new HashMap<>();
		summary.put("52WeekHigh", high);
		summary.put("52WeekLow", low);
		summary.put("AverageClose", avg);

		structure.setData(summary);
		structure.setMessage("Stock summary fetched successfully");
		structure.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Map<String, Double>>> compareStocks(String symbol1, String symbol2) {

		ResponseStructure<Map<String, Double>> structure = new ResponseStructure<>();

		Double avg1 = stockDataRepository.findAvgClosePriceByCompanySymbol(symbol1);
		Double avg2 = stockDataRepository.findAvgClosePriceByCompanySymbol(symbol2);

		Map<String, Double> result = new HashMap<>();
		result.put(symbol1, avg1);
		result.put(symbol2, avg2);

		structure.setData(result);
		structure.setMessage("Stock comparison fetched successfully");
		structure.setStatusCode(HttpStatus.OK.value());

		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
}
