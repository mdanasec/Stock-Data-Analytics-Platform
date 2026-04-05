package org.springboot.codingpills.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StockData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDate date;

	@Column(name = "open_price", nullable = false)
	private double openPrice;

	@Column(name = "close_price", nullable = false)
	private double closePrice;

	@Column(name = "high_price")
	private double highPrice;

	@Column(name = "low_price")
	private double lowPrice;

	@Column
	private long volume;

	@Column(name = "daily_return")
	private double dailyReturn;

	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Companies company;

	public StockData() {
		super();
	}

	public StockData(Long id, LocalDate date, double openPrice, double closePrice, double highPrice, double lowPrice,
			long volume, double dailyReturn, Companies company) {
		super();
		this.id = id;
		this.date = date;
		this.openPrice = openPrice;
		this.closePrice = closePrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.volume = volume;
		this.dailyReturn = dailyReturn;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}

	public double getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public double getDailyReturn() {
		return dailyReturn;
	}

	public void setDailyReturn(double dailyReturn) {
		this.dailyReturn = dailyReturn;
	}

	public Companies getCompany() {
		return company;
	}

	public void setCompany(Companies company) {
		this.company = company;
	}
}