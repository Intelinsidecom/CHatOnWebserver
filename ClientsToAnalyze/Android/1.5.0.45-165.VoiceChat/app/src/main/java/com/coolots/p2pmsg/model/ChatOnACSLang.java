package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class ChatOnACSLang {
    private Integer CountryCode;
    private String LangCode;
    private String LangName;

    public String getLangCode() {
        return this.LangCode;
    }

    public void setLangCode(String langCode) {
        this.LangCode = langCode;
    }

    public String getLangName() {
        return this.LangName;
    }

    public void setLangName(String langName) {
        this.LangName = langName;
    }

    public Integer getCountryCode() {
        return this.CountryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.CountryCode = countryCode;
    }
}
