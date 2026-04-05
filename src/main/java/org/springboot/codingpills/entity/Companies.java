package org.springboot.codingpills.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Companies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String symbol;

	@Column(nullable = false)
	private String companyName;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<StockData> stockDataList;

	public Companies() {
		super();
	}

	public Companies(Long id, String symbol, String companyName, List<StockData> stockDataList) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.companyName = companyName;
		this.stockDataList = stockDataList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<StockData> getStockDataList() {
		return stockDataList;
	}

	public void setStockDataList(List<StockData> stockDataList) {
		this.stockDataList = stockDataList;
	}

}
