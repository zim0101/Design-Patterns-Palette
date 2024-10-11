package org.asif.data;

import java.util.HashMap;
import java.util.Map;

public class Products {
    public static final Map<Integer, Integer> PRICE_ON_PRODUCTS = new HashMap<>();

    static {
        PRICE_ON_PRODUCTS.put(1, 2200);
        PRICE_ON_PRODUCTS.put(2, 1850);
        PRICE_ON_PRODUCTS.put(3, 1100);
        PRICE_ON_PRODUCTS.put(4, 890);
    }
}
