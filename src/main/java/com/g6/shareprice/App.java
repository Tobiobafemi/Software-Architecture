package com.g6.shareprice;

import com.g6.shareprice.controller.SharePriceController;
import com.g6.shareprice.provider.MarketDataProvider;
import com.g6.shareprice.repository.SQLitePriceRepository;
import com.g6.shareprice.service.SharePriceService;

public class App {
    public static void main(String[] args) {

        var repo = new SQLitePriceRepository();
        //build repository, storage component
        var provider = new MarketDataProvider(repo);
        //build provider, and give it the repo to store its data
        var service = new SharePriceService(provider);
        //build service, and give it provider to supply prices
        var controller = new SharePriceController(service);
        //build controller, and give it service to fulfill requests

        var result = controller.compare("KO","XOM","2024-01-01","2024-01-05");
        System.out.println(result.getSummary());
        //simulate and output user request
    }
}
