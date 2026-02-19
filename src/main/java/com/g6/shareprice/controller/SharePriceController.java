package com.g6.shareprice.controller;

//The controller receives input and passes it inside the system to the service layer

import com.g6.shareprice.domain.ComparisonResult;
import com.g6.shareprice.service.SharePriceService;

import java.time.LocalDate; //importing built in calendar date type from java

public class SharePriceController {
    private SharePriceService service;
    //reference to service

    public SharePriceController(SharePriceService service) {
        this.service = service;
    }  //controller exists alongside service

    public ComparisonResult compare(String s1, String s2, String from, String to) {
        return service.compare(s1, s2, LocalDate.parse(from), LocalDate.parse(to));
        // parses date string into objects and routes to service
    }
}
