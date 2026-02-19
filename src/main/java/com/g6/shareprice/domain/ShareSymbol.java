package com.g6.shareprice.domain;


/* ShareSymbol class represents a ticker symbol of a company.

   By wrapping the string inside an object, instead of passing strings,
   we can easily validate the label for a company in one go.

   No capitalisation issues, empty string issues etc.
*/

public class ShareSymbol {
    private final String value;
    //IMMUTABLE: can't change after initialization

    //constructor
    public ShareSymbol(String value) {

        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Symbol empty");
        //ensures value is assigned and not left empty

        this.value = value.toUpperCase();
        //standardizes to uppercase
    }

    //getter
    public String getValue() {
        return value;
    }
}
