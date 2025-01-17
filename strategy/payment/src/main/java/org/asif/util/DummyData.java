package org.asif.util;

import java.util.Map;

public final class DummyData {

    private static Map<String, Map<String, Object>> creditCards;
    private static Map<String, String> paypalCredentials;
    private static Map<Integer, Integer> products;

    private DummyData() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static void init() {
        try {
            creditCards = MockDataLoader.loadCreditCardData();
            paypalCredentials = MockDataLoader.loadPayPalCredentials();
            products = MockDataLoader.loadProductData();
        } catch (Exception e) {
            throw new RuntimeException("Error loading mock data", e);
        }
    }

    public static Map<String, Map<String, Object>> getCreditCards() {
        return creditCards;
    }

    public static Map<String, String> getPaypalCredentials() {
        return paypalCredentials;
    }

    public static Map<Integer, Integer> getProducts() {
        return products;
    }
}
