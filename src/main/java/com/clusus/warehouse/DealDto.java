package com.clusus.warehouse;

public class DealDto {

    private String dealId;
    private String fromCurrencyCode;
    private String toCurrencyCode;
    private String dealTime;
    private String dealAmount;

    public DealDto() {
    }

    public DealDto(String dealId, String fromCurrencyCode, String toCurrencyCode, String dealTime, String dealAmount) {
        this.dealId = dealId;
        this.fromCurrencyCode = fromCurrencyCode;
        this.toCurrencyCode = toCurrencyCode;
        this.dealTime = dealTime;
        this.dealAmount = dealAmount;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getFromCurrencyCode() {
        return fromCurrencyCode;
    }

    public void setFromCurrencyCode(String fromCurrencyCode) {
        this.fromCurrencyCode = fromCurrencyCode;
    }

    public String getToCurrencyCode() {
        return toCurrencyCode;
    }

    public void setToCurrencyCode(String toCurrencyCode) {
        this.toCurrencyCode = toCurrencyCode;
    }

    public String getDealTime() {
        return dealTime;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(String dealAmount) {
        this.dealAmount = dealAmount;
    }
}
