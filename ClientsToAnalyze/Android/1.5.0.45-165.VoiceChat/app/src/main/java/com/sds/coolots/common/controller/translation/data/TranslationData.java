package com.sds.coolots.common.controller.translation.data;

/* loaded from: classes.dex */
public class TranslationData {
    public static final int LANGUAGE_CHINESE = 30;
    public static final int LANGUAGE_CHINESE_HK = 31;
    public static final int LANGUAGE_ENGLISH_UK = 21;
    public static final int LANGUAGE_ENGLISH_US = 20;
    public static final int LANGUAGE_JAPANESE = 40;
    public static final int LANGUAGE_KOREAN = 10;
    public static final int LANGUAGE_NONE = 0;
    public static final int LANGUAGE_OTHERS = 50;

    /* renamed from: a */
    protected String f3000a;

    /* renamed from: b */
    protected String f3001b;

    /* renamed from: c */
    protected int f3002c;

    /* renamed from: d */
    protected int f3003d;

    /* renamed from: e */
    protected int f3004e;

    /* renamed from: f */
    protected String f3005f;

    /* renamed from: g */
    protected String f3006g;

    public TranslationData(TranslationData translationData) {
        this.f3000a = translationData.f3000a;
        this.f3001b = translationData.f3001b;
        this.f3002c = translationData.f3002c;
        this.f3003d = translationData.f3003d;
        this.f3004e = translationData.f3004e;
        this.f3005f = translationData.f3005f;
        this.f3006g = translationData.f3006g;
    }

    public TranslationData(String str, String str2, int i, int i2, int i3, String str3, String str4) {
        this.f3000a = str;
        this.f3001b = str2;
        this.f3002c = i;
        this.f3003d = i2;
        this.f3004e = i3;
        this.f3005f = str3;
        this.f3006g = str4;
    }

    public void dispose() {
        this.f3005f = null;
        this.f3006g = null;
    }

    public String getID() {
        return this.f3000a;
    }

    public int getInLanguage() {
        return this.f3002c;
    }

    public int getNatinalFlag() {
        return this.f3004e;
    }

    public int getOutLanguage() {
        return this.f3003d;
    }

    public String getRecognizedText() {
        return this.f3005f;
    }

    public String getTranslatedText() {
        return this.f3006g;
    }

    public String getUserID() {
        return this.f3001b;
    }

    public void setID(String str) {
        this.f3000a = str;
    }

    public void setInLanguage(int i) {
        this.f3002c = i;
    }

    public void setNatinalFlag(int i) {
        this.f3004e = i;
    }

    public void setOutLanguage(int i) {
        this.f3003d = i;
    }

    public void setRecognizedText(String str) {
        this.f3005f = str;
    }

    public void setTranslatedText(String str) {
        this.f3006g = str;
    }

    public void setUserID(String str) {
        this.f3001b = str;
    }
}
