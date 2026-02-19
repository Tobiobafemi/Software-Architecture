package com.g6.shareprice.provider;

import com.g6.shareprice.domain.PriceSeries;
import com.g6.shareprice.domain.ShareSymbol;
import java.time.LocalDate;

/* IMarketDataProvider lets us ask for prices from multiple sources,
   online application programming interfaces, local databases etc, so long
   as they implement the required method.
* */

public interface IMarketDataProvider {
    PriceSeries getPrices(ShareSymbol symbol, LocalDate from, LocalDate to);
}
