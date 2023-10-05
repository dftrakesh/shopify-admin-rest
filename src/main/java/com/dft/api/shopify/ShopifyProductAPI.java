package com.dft.api.shopify;

import com.dft.api.shopify.model.Pagination;
import com.dft.api.shopify.model.ShopifyPage;
import com.dft.api.shopify.model.ShopifyProduct;
import com.dft.api.shopify.model.ShopifyProducts;
import com.dft.api.shopify.model.auth.AccessCredential;
import com.dft.api.shopify.model.order.v202307.ShopifyOrder;
import com.dft.api.shopify.model.product.ShopifyProductWrapper;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static com.dft.api.shopify.constantcode.ConstantCodes.HTTPS;
import static com.dft.api.shopify.constantcode.ConstantCodes.PRODUCTS_END_POINT_WITH_JSON;
import static com.dft.api.shopify.constantcode.ConstantCodes.VERSION_2023_01;
import static com.dft.api.shopify.constantcode.ConstantCodes.DEFAULT_REQUEST_LIMIT;
import static com.dft.api.shopify.constantcode.ConstantCodes.LIMIT;
import static com.dft.api.shopify.constantcode.ConstantCodes.PAGE_INFO;

@Log4j2
public class ShopifyProductAPI extends ShopifySdkNew {

    public ShopifyProductAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ShopifyProductWrapper getProducts(HashMap<String, String> params) {
        URI uri = addParameters(new URI(HTTPS + accessCredential.getStoreDomain() + VERSION_2023_01 + PRODUCTS_END_POINT_WITH_JSON), params);
        HttpRequest request = get(uri);
        return getRequestWrapped(request, ShopifyProductWrapper.class);
    }

    private List<ShopifyProduct> getAllProducts() {
        HashMap<String, String> params = new HashMap<>();
        params.put(LIMIT, DEFAULT_REQUEST_LIMIT);

        ShopifyProductWrapper shopifyProductWrapper = getProducts(params);
        List<ShopifyProduct> shopifyProductList = new ArrayList<>(shopifyProductWrapper.getProducts());

        Pagination pagination = shopifyProductWrapper.getPagination();
        while (pagination.getNext() != null) {
            params.put(PAGE_INFO, pagination.getNext());
            shopifyProductWrapper = getProducts(params);
            shopifyProductList.addAll(shopifyProductWrapper.getProducts());
            pagination = shopifyProductWrapper.getPagination();
        }
        return shopifyProductList;
    }
}