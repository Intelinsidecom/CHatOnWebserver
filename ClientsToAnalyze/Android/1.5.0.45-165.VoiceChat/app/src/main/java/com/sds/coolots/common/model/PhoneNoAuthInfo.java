package com.sds.coolots.common.model;

/* loaded from: classes.dex */
public class PhoneNoAuthInfo {

    /* renamed from: a */
    private String f3057a = null;

    /* renamed from: b */
    private Integer f3058b = null;

    /* renamed from: c */
    private String f3059c = null;

    /* renamed from: d */
    private boolean f3060d = false;

    /* renamed from: e */
    private Class f3061e = null;

    public String getAuthID() {
        return this.f3057a;
    }

    public Integer getCountryCode() {
        return this.f3058b;
    }

    public Class getParent() {
        return this.f3061e;
    }

    public String getPhoneNo() {
        return this.f3059c;
    }

    public boolean getResult() {
        return this.f3060d;
    }

    public void setAuthID(String str) {
        this.f3057a = str;
    }

    public void setCountryCode(Integer num) {
        this.f3058b = num;
    }

    public void setParent(Class cls) {
        this.f3061e = cls;
    }

    public void setPhoneNo(String str) {
        this.f3059c = str;
    }

    public void setResult(boolean z) {
        this.f3060d = z;
    }
}
