package com.g6.shareprice.domain;

/* This will eventually allow the UI to create a graph but for now it just
prints a success message to prove the request travelled through all the layers
*/

public class ComparisonResult {
    private String summary;

    //constructor
    public ComparisonResult(String summary) {
        this.summary = summary;
    }

    //getter
    public String getSummary() {
        return summary;
    }
}
