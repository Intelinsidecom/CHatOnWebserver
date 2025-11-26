package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class EWalletInfo {
    private String Amount;
    private String Country;
    private String CurHigh;
    private String CurLow;
    private String CurSymbol;
    private String Currency;
    private String ServiceType;
    private String Type;

    public String getType() {
        return this.Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getCurrency() {
        return this.Currency;
    }

    public void setCurrency(String currency) {
        this.Currency = currency;
    }

    public String getAmount() {
        return this.Amount;
    }

    public void setAmount(String amount) {
        this.Amount = amount;
    }

    public String getCountry() {
        return this.Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getServiceType() {
        return this.ServiceType;
    }

    public void setServiceType(String serviceType) {
        this.ServiceType = serviceType;
    }

    public String getCurSymbol() {
        return this.CurSymbol;
    }

    public void setCurSymbol(String curSymbol) {
        this.CurSymbol = curSymbol;
    }

    public String getCurLow() {
        return this.CurLow;
    }

    public void setCurLow(String curLow) {
        this.CurLow = curLow;
    }

    public String getCurHigh() {
        return this.CurHigh;
    }

    public void setCurHigh(String curHigh) {
        this.CurHigh = curHigh;
    }
}
