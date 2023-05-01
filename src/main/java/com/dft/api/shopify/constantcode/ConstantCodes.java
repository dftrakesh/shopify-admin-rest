package com.dft.api.shopify.constantcode;

public class ConstantCodes {

    public static final int TIME_OUT_DURATION = 5000;
    public static final int MAX_ATTEMPTS = 50;

    public static final String HTTPS = "https://";
    public static final String ACCESS_TOKEN_HEADER = "X-Shopify-Access-Token";
    public static final String HTTP_HEADER_CONTENT_TYPE = "content-type";
    public static final String HTTP_HEADER_VALUE_APPLICATION_JSON = "application/json";
    public static final String VERSION_2023_01 = "/admin/api/2023-01/";

    public static final String ACCESS_TOKEN_END_POINT_WITH_JSON = "/admin/oauth/access_token.json";
    public static final String SHOP_END_POINT_WITH_JSON = "shop.json";
    public static final String PRODUCTS_END_POINT_WITH_JSON = "products.json";
    public static final String SMART_COLLECTIONS_END_POINT_WITH_JSON = "smart_collections.json";
    public static final String WEBHOOK_END_POINT_WITH_JSON = "webhooks.json";

    public static final String WEBHOOK_END_POINT = "webhooks";
    public static final String CUSTOMERS = "customers";
    public static final String ADDRESSES = "/addresses/";
    public static final String JSON = ".json";

    public static final String ACCESS_SCOPES = "/admin/oauth/access_scopes";
}