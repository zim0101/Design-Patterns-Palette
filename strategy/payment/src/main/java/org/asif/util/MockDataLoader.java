package org.asif.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public final class MockDataLoader {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private MockDataLoader() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static Map<String, Map<String, Object>> loadCreditCardData() throws IOException {
        return MAPPER.readValue(
                MockDataLoader.class.getResourceAsStream("/data/credit-cards.json"),
                new TypeReference<Map<String, Map<String, Object>>>() { });
    }

    public static Map<String, String> loadPayPalCredentials() throws IOException {
        return MAPPER.readValue(
                MockDataLoader.class.getResourceAsStream("/data/paypal-credentials.json"),
                new TypeReference<Map<String, String>>() { });
    }

    public static Map<Integer, Integer> loadProductData() throws IOException {
        return MAPPER.readValue(
                MockDataLoader.class.getResourceAsStream("/data/products.json"),
                new TypeReference<Map<Integer, Integer>>() { });
    }
}
