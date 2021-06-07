package com.consumeApiRest.endpoints;


public class ApplicationEndpoint {
    private static String TICKER = "/ticker";
    private static String PRODUCT = "product";
    private static String NEW_PRODUCT = "new_product";
    private static String ACTIVATE_PRODUCT = "activate-product";
 
    public static String getCoinPrice(String coin) {
        return TICKER.concat(String.format("?book=%s", coin));
    }

    public static String getAllProduct() {
        return PRODUCT.concat(String.format("/%s", ""));
    }
    
    public static String getProductById(String id) {
        return PRODUCT.concat(String.format("/%s", id));
    }

    public static String createNewProduct() {
        return NEW_PRODUCT.concat(String.format("%s", ""));
    }
    
    public static String activateProduct() {
        return ACTIVATE_PRODUCT.concat(String.format("%s", ""));
    }
}