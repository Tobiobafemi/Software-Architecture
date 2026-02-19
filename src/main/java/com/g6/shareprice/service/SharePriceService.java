package com.g6.shareprice.service;

import com.g6.shareprice.domain.ComparisonResult;
import com.g6.shareprice.domain.PriceSeries;
import com.g6.shareprice.domain.ShareSymbol;
import com.g6.shareprice.provider.IMarketDataProvider;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*Service layer will decide what happens, check the validity of dates and range
and ask another later to get the prices. It's a co-ordinator of other components,
so will call on the provider and return the results.
*/

public class SharePriceService {
    private IMarketDataProvider provider;
    //service depends on interface not implementation

    //constructor
    public SharePriceService(IMarketDataProvider provider) {
        this.provider = provider;
    }

    public ComparisonResult compare(String s1, String s2, LocalDate from, LocalDate to) {

        if (ChronoUnit.DAYS.between(from, to) > 730)
            throw new IllegalArgumentException("Select a maximum of 2 year range");
        // Enforcing rules for appropriate range

        PriceSeries a = provider.getPrices(new ShareSymbol(s1), from, to);
        PriceSeries b = provider.getPrices(new ShareSymbol(s2), from, to);
        //gets price series from provider

        return new ComparisonResult("Compared " + a.getSymbol().getValue() + " vs " + b.getSymbol().getValue());
        //later, include actual metrics, but now just returns string
    }
}
