package com.g6.shareprice.domain;

import java.util.List;  // importing list to store PricePoints

/* PriceSeries will create an object that stores a ShareSymbol,
   and a list of PricePoints, to create a sort of logbook of price history
   for a company, within the chosen time range.
*/

public class PriceSeries {
    private ShareSymbol symbol;

    /*passing a symbol as an attribute is important so that the object is self-describing.
    the data flows through multiple layers, so instead of just getting a list of pricepoints that could be mixed up,
    we will always know what symbol goes with it */

    private List<PricePoint> points;

    //constructor to join symbol with pricepoints
    public PriceSeries(ShareSymbol symbol, List<PricePoint> points) {
        this.symbol = symbol;
        this.points = points;
    }

    //getters
    public ShareSymbol getSymbol() { return symbol; }
    public List<PricePoint> getPoints() { return points; }
}
