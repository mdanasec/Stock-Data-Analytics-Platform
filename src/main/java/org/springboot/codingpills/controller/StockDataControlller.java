package org.springboot.codingpills.controller;

import java.util.List;
import java.util.Map;

import org.springboot.codingpills.entity.ResponseStructure;
import org.springboot.codingpills.entity.StockData;
import org.springboot.codingpills.service.StockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockDataControlller {


	@Autowired
	StockDataService stockDataService;

	@PostMapping("/addStockData/{id}")
	public ResponseEntity<ResponseStructure<StockData>> addStockData(@RequestBody StockData stockData,
			@PathVariable Long id) {
		return stockDataService.addStockData(stockData, id);
	}

	@GetMapping("/data/{symbol}")
	public ResponseEntity<ResponseStructure<List<StockData>>> getStockDataBySymbol(@PathVariable String symbol) {
		return stockDataService.getStockDataBySymbol(symbol);
	}

	@GetMapping("/summary/{symbol}")
	public ResponseEntity<ResponseStructure<Map<String, Double>>> getStockSummary(@PathVariable String symbol) {
		return stockDataService.getStockSummary(symbol);
	}
	
	@GetMapping("/compare")
	public ResponseEntity<ResponseStructure<Map<String, Double>>> compareStocks(
	        @RequestParam String symbol1,
	        @RequestParam String symbol2){

	    return stockDataService.compareStocks(symbol1, symbol2);
	}
	
	
}
