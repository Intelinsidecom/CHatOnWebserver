package com.sds.coolots.login.model;

/* loaded from: classes.dex */
public class NationalCode {

    /* renamed from: a */
    private String f3215a;

    /* renamed from: b */
    private String f3216b;

    /* renamed from: c */
    private String f3217c;

    /* renamed from: d */
    private String f3218d;

    /* renamed from: f */
    private String f3220f;

    /* renamed from: g */
    private boolean f3221g;

    /* renamed from: e */
    private String f3219e = "";

    /* renamed from: h */
    private String f3222h = null;

    /* renamed from: i */
    private String f3223i = null;

    public String getAreaCode() {
        return this.f3219e;
    }

    public String getIso2() {
        return this.f3215a;
    }

    public String getMCC() {
        return this.f3220f;
    }

    public String getcountryCode() {
        return this.f3218d;
    }

    public String gethighLightedCode() {
        return this.f3223i;
    }

    public String gethighLightedName() {
        return this.f3222h;
    }

    public String getnameEng() {
        return this.f3217c;
    }

    public String getnameKor() {
        return this.f3216b;
    }

    public boolean isZeroSpace() {
        return this.f3221g;
    }

    public void setAreaCode(String str) {
        this.f3219e = str;
    }

    public void setIso2(String str) {
        this.f3215a = str;
    }

    public void setMCC(String str) {
        this.f3220f = str;
    }

    public void setZeroSpace(boolean z) {
        this.f3221g = z;
    }

    public void setcountryCode(String str) {
        this.f3218d = str;
    }

    public void sethighLightedCode(String str) {
        this.f3223i = str;
    }

    public void sethighLightedName(String str) {
        this.f3222h = str;
    }

    public void setnameEng(String str) {
        this.f3217c = str;
    }

    public void setnameKor(String str) {
        this.f3216b = str;
    }
}
