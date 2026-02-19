package com.g6.shareprice.provider;

import com.g6.shareprice.domain.PricePoint;
import com.g6.shareprice.domain.PriceSeries;
import com.g6.shareprice.domain.ShareSymbol;
import com.g6.shareprice.repository.SQLitePriceRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/* MarketDataProvider will eventually get data from cache or fetches with API,
   and then it will save it for future offline use.
   As it's supposed to obtain price data, we just use placeholder data for sprint 1
   */


//implements contract required
public class MarketDataProvider implements IMarketDataProvider {
    private SQLitePriceRepository repository;
    //passes repository as an attribute so the marketprovider stores data, not the service component

    //constructor with injected repository
    public MarketDataProvider(SQLitePriceRepository repository) {
        this.repository = repository;
    }


    //overriding method defined in IMarketDataProvider
    @Override
    public PriceSeries getPrices(ShareSymbol symbol, LocalDate from, LocalDate to) {

        List<PricePoint> points = new ArrayList<>();
        LocalDate fromDate = from;

        while (!fromDate.isAfter(to)) {
            points.add(new PricePoint(fromDate, 100.0)); // fake data
            fromDate = fromDate.plusDays(1);
        }
        //until the 'from' date passes the 'to' date, it will create a PricePoint with price of 100, and then add that to the new arraylist we made

        PriceSeries series = new PriceSeries(symbol, points);
        //then creates a priceseries object that passes the points list we just created
        repository.save(series);
        //persist the results eventually in later sprints
        return series;
        //and returns assembled pricehistory to service layer
    }
}
