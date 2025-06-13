package com.in28minutes.microservices.currencyconversionservice.beans;

import java.math.BigDecimal;

public class CurrencyConversion {

    private long id;

    private String from;

    private String to;

    private BigDecimal conversionMultiple;

    private String environment;

    private BigDecimal totalAmount;

    private BigDecimal quantity;

    public CurrencyConversion() {
    }

    public CurrencyConversion(long id, String from, String to, BigDecimal conversionMultiple, String environment, BigDecimal totalAmount, BigDecimal quantity) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.environment = environment;
        this.totalAmount = totalAmount;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
