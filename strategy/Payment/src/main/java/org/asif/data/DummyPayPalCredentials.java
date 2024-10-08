package org.asif.data;

import java.util.HashMap;
import java.util.Map;

public class DummyPayPalCredentials {
    public static final Map<String, String> CREDENTIALS = new HashMap<>();

    static {
        CREDENTIALS.put("amanda1985", "amanda@ya.com");
        CREDENTIALS.put("qwerty", "john@amazon.eu");
    }
}
