package com.g6.shareprice.domain;

import java.time.LocalDate;  //importing built in calendar date type from java
                             // NOT LocalDateTime because stocks change per day, so time isn't needed.

/*PricePoint class will tell us how much a share cost on a specific day.
 We create an object for this so that the date and price are stored together,
 so we don't need to keep passing two variables. Useful for PriceSeries so the list
 can just be a list of PricePoint objects.
*/

public class PricePoint {
    private LocalDate date;
    private double price;

    //constructor
    public PricePoint(LocalDate date, double price) {
        this.date = date;
        this.price = price;
    }

    //getters
    public LocalDate getDate() { return date; }
    public double getPrice() { return price; }
}
