package com.clusus.warehouse;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "deal")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "deal_id",unique = true)
    @NotNull
    private String dealId;

    @Column(name = "from_currency_code")
    @NotNull
    private String fromCurrencyCode;

    @Column(name = "to_currency_code")
    @NotNull
    private String toCurrencyCode;

    @Column(name = "deal_time")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dealTime;

    @Column(name = "deal_amount")
    @NotNull
    @Digits(integer = 8,fraction = 3)
    private BigDecimal dealAmount;

    public Deal() {
    }

    public Deal(String dealId, String fromCurrencyCode, String toCurrencyCode, Date dealTime, BigDecimal dealAmount) {
        this.dealId = dealId;
        this.fromCurrencyCode = fromCurrencyCode;
        this.toCurrencyCode = toCurrencyCode;
        this.dealTime = dealTime;
        this.dealAmount = dealAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public BigDecimal getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount) {
        this.dealAmount = dealAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deal deal = (Deal) o;
        return Objects.equals(id, deal.id) && Objects.equals(dealId, deal.dealId) && Objects.equals(fromCurrencyCode, deal.fromCurrencyCode) && Objects.equals(toCurrencyCode, deal.toCurrencyCode) && Objects.equals(dealTime, deal.dealTime) && Objects.equals(dealAmount, deal.dealAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dealId, fromCurrencyCode, toCurrencyCode, dealTime, dealAmount);
    }
}
