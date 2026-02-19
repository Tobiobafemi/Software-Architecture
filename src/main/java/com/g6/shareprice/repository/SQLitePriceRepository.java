package com.g6.shareprice.repository;

import com.g6.shareprice.domain.PriceSeries;

//When provider gets data, repository will save for offline use

public class SQLitePriceRepository {
    public void save(PriceSeries series) {
        System.out.println("Prices saved for " + series.getSymbol().getValue());
        // Upcoming sprints: save offline to real database
    }
}
