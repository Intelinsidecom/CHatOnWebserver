package com.samsung.samm.common;

import android.util.Log;

/* loaded from: classes.dex */
public class SObjectText extends SObject {
    public static final byte SAMM_DEFAULT_MAX_TEXTSIZE = 20;
    public static final byte SAMM_DEFAULT_MIN_TEXTSIZE = 5;
    public static final int SAMM_TEXT_STYLE_BOLD = 1;
    public static final int SAMM_TEXT_STYLE_ITALIC = 2;
    public static final int SAMM_TEXT_STYLE_NONE = 0;
    public static final int SAMM_TEXT_STYLE_UNDERLINE = 4;

    /* renamed from: a */
    private String f417a;

    /* renamed from: b */
    private String f418b;

    /* renamed from: c */
    private int f419c;

    /* renamed from: d */
    private int f420d;

    /* renamed from: e */
    private int f421e;

    public SObjectText() {
        this.mColor = -16777216;
        this.mSize = 10.0f;
        this.f417a = null;
        this.f418b = null;
        this.f419c = 0;
        this.f420d = 0;
        this.f421e = 0;
    }

    @Override // com.samsung.samm.common.SObject
    public boolean setStyle(int i) {
        if (i == 0 || (i & (-8)) == 0) {
            this.mStyle = i;
            return true;
        }
        Log.e("SAMMLibrary", "Undefined Text Style : " + i);
        return false;
    }

    public void setTextData(String str, String str2) {
        setText(str);
        setFontName(str2);
    }

    public String getText() {
        return this.f417a;
    }

    public void setText(String str) {
        this.f417a = str;
    }

    public String getFontName() {
        return this.f418b;
    }

    public void setFontName(String str) {
        this.f418b = str;
    }

    public int getBGColor() {
        return this.f419c;
    }

    public void setBGColor(int i) {
        this.f419c = i;
    }

    public int getHorizTextAlign() {
        return this.f420d;
    }

    public int getVertTextAlign() {
        return this.f421e;
    }

    public boolean setTextAlign(int i, int i2) {
        if ((i == 0 || i == 1 || i == 2) && (i2 == 0 || i2 == 1 || i2 == 2)) {
            this.f420d = i;
            this.f421e = i2;
            return true;
        }
        Log.e("SAMMLibrary", "Undefined Text Align Option : " + i + ", " + i2);
        return false;
    }

    @Override // com.samsung.samm.common.SObject
    public SObject copyObject() {
        SObjectText sObjectText = new SObjectText();
        copyObjectGeneral(sObjectText);
        sObjectText.setText(getText());
        sObjectText.setTextAlign(getHorizTextAlign(), getVertTextAlign());
        sObjectText.setFontName(getFontName());
        sObjectText.setBGColor(getBGColor());
        return sObjectText;
    }

    @Override // com.samsung.samm.common.SObject
    public boolean changeObject(SObject sObject) {
        if (!super.changeObjectGeneral(sObject)) {
            return false;
        }
        SObjectText sObjectText = (SObjectText) sObject;
        setText(sObjectText.getText());
        setTextAlign(sObjectText.getHorizTextAlign(), sObjectText.getVertTextAlign());
        setFontName(sObjectText.getFontName());
        setBGColor(sObjectText.getBGColor());
        return true;
    }

    @Override // com.samsung.samm.common.SObject
    public String getObjectInfo() {
        return "\"" + getText() + "\"";
    }
}
