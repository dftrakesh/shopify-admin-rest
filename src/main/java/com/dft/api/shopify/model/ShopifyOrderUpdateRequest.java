package com.dft.api.shopify.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopifyOrderUpdateRequest {

    private String id;
    private String tags;

    public ShopifyOrderUpdateRequest(String id, String tags) {
        this.id = id;
        this.tags = tags;
        this.shippingAddress = null;
    }

    @JsonProperty("shipping_address")
    private ShopifyAddressUpdateRequest shippingAddress;

    public static interface BuildStep {
        ShopifyOrderUpdateRequest build();
    }

    public static interface LongitudeStep {
        BuildStep withLongitude(final BigDecimal longitude);
    }

    public static interface LatitudeStep {
        LongitudeStep withLatitude(final BigDecimal latitude);
    }

    public static interface CompanyStep {
        LatitudeStep withCompany(final String company);
    }

    public static interface LastNameStep {
        CompanyStep withLastName(final String lastName);
    }

    public static interface FirstNameStep {
        LastNameStep withFirstName(final String firstName);
    }

    public static interface PhoneStep {
        FirstNameStep withPhone(final String phone);
    }

    public static interface CountryCodeStep {
        PhoneStep withCountryCode(final String countryCode);
    }

    public static interface CountryStep {
        CountryCodeStep withCountry(final String country);
    }

    public static interface ZipCodeStep {
        CountryStep withZip(final String zip);
    }

    public static interface ProvinceCodeStep {
        ZipCodeStep withProvinceCode(final String province);
    }

    public static interface ProvinceStep {
        ProvinceCodeStep withProvince(final String province);
    }

    public static interface CityStep {
        ProvinceStep withCity(final String city);
    }

    public static interface Address2Step {
        CityStep withAddress2(final String address2);
    }

    public static interface Address1Step {
        Address2Step withAddress1(final String address1);
    }

    public static interface IdStep {
        Address1Step withId(final String id);
    }

    public static IdStep newBuilder() {
        return new Steps();
    }

    private ShopifyOrderUpdateRequest(final Steps steps) {
        this.id = steps.id;
        this.shippingAddress = steps.shippingAddress;
        this.tags = steps.tags;
    }

    private static class Steps implements IdStep, Address1Step, Address2Step, CityStep, ProvinceStep, ProvinceCodeStep,
        ZipCodeStep, CountryStep, CountryCodeStep, PhoneStep, LatitudeStep, CompanyStep, LongitudeStep,
        LastNameStep, FirstNameStep, BuildStep {
        private String id;
        private String tags;
        private final ShopifyAddressUpdateRequest shippingAddress = new ShopifyAddressUpdateRequest();

        @Override
        public ShopifyOrderUpdateRequest build() {
            return new ShopifyOrderUpdateRequest(this);
        }

        @Override
        public LastNameStep withFirstName(final String firstName) {
            this.shippingAddress.setFirstName(firstName);
            return this;
        }

        @Override
        public CompanyStep withLastName(final String lastName) {
            this.shippingAddress.setLastname(lastName);
            return this;
        }

        @Override
        public BuildStep withLongitude(final BigDecimal longitude) {
            this.shippingAddress.setLongitude(longitude);
            return this;
        }

        @Override
        public LongitudeStep withLatitude(final BigDecimal latitude) {
            this.shippingAddress.setLatitude(latitude);
            return this;
        }

        @Override
        public FirstNameStep withPhone(final String phone) {
            this.shippingAddress.setPhone(phone);
            return this;
        }

        @Override
        public PhoneStep withCountryCode(final String countryCode) {
            this.shippingAddress.setCountryCode(countryCode);
            return this;
        }

        @Override
        public CountryCodeStep withCountry(final String country) {
            this.shippingAddress.setCountry(country);
            return this;
        }

        @Override
        public CountryStep withZip(final String zip) {
            this.shippingAddress.setZip(zip);
            return this;
        }

        @Override
        public ZipCodeStep withProvinceCode(final String provinceCode) {
            this.shippingAddress.setProvinceCode(provinceCode);
            return this;
        }

        @Override
        public ProvinceStep withCity(final String city) {
            this.shippingAddress.setCity(city);
            return this;
        }

        @Override
        public CityStep withAddress2(final String address2) {
            this.shippingAddress.setAddress2(address2);
            return this;
        }

        @Override
        public Address2Step withAddress1(final String address1) {
            this.shippingAddress.setAddress1(address1);
            return this;
        }

        @Override
        public Address1Step withId(final String id) {
            this.id = id;
            return this;
        }

        @Override
        public ProvinceCodeStep withProvince(final String province) {
            this.shippingAddress.setProvince(province);
            return this;
        }

        @Override
        public LatitudeStep withCompany(final String company) {
            this.shippingAddress.setCompany(company);
            return this;
        }

    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public ShopifyAddressUpdateRequest getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(final ShopifyAddressUpdateRequest shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "ShopifyOrderUpdateRequest{" +
            "id='" + id + '\'' +
            ", tags='" + tags + '\'' +
            ", shippingAddress=" + shippingAddress +
            '}';
    }
}
