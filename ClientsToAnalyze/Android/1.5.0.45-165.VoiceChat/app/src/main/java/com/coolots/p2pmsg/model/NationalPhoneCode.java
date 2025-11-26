package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class NationalPhoneCode {
    private Integer CountryCode;
    private String Iso2Code;
    private String NationalCode;
    private String NationalNameEng;
    private String NationalNameKor;

    public String getNationalCode() {
        return this.NationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.NationalCode = nationalCode;
    }

    public String getNationalNameKor() {
        return this.NationalNameKor;
    }

    public void setNationalNameKor(String nationalNameKor) {
        this.NationalNameKor = nationalNameKor;
    }

    public String getNationalNameEng() {
        return this.NationalNameEng;
    }

    public void setNationalNameEng(String nationalNameEng) {
        this.NationalNameEng = nationalNameEng;
    }

    public Integer getCountryCode() {
        return this.CountryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.CountryCode = countryCode;
    }

    public String getIso2Code() {
        return this.Iso2Code;
    }

    public void setIso2Code(String iso2Code) {
        this.Iso2Code = iso2Code;
    }
}
