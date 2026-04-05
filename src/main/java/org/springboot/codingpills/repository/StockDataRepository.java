package org.springboot.codingpills.repository;

import java.util.List;

import org.springboot.codingpills.entity.StockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDataRepository extends JpaRepository<StockData, Long> {

	List<StockData> findTop30ByCompanySymbolOrderByDateDesc(String symbol);

	Double findMaxHighPriceByCompanySymbol(String symbol);

	Double findMinLowPriceByCompanySymbol(String symbol);

	Double findAvgClosePriceByCompanySymbol(String symbol);
}
