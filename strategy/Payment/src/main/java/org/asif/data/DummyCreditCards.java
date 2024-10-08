package org.asif.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Dummy credit card class.
 */
public class DummyCreditCards {
    public static final Map<String, Map<String, Object>> CREDIT_CARD = new HashMap<>();

    static {
        // Adding some dummy credit card credentials to simulate a DB
        Map<String, Object> card1Details = new HashMap<>();
        card1Details.put("expiryDate", "12/24");
        card1Details.put("cvv", "123");
        card1Details.put("pin", "1234");
        CREDIT_CARD.put("4111111111111111", card1Details);

        Map<String, Object> card2Details = new HashMap<>();
        card2Details.put("expiryDate", "11/23");
        card2Details.put("cvv", "456");
        card2Details.put("pin", "9876");
        CREDIT_CARD.put("5555555555554444", card2Details);

        Map<String, Object> card3Details = new HashMap<>();
        card3Details.put("expiryDate", "10/25");
        card3Details.put("cvv", "789");
        card3Details.put("pin", "4321");
        CREDIT_CARD.put("378282246310005", card3Details);
    }
}
