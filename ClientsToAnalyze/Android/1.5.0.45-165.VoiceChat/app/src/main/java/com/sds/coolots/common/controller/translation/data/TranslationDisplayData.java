package com.sds.coolots.common.controller.translation.data;

import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class TranslationDisplayData extends TranslationData implements Cloneable {

    /* renamed from: h */
    private boolean f3007h;

    /* renamed from: i */
    private boolean f3008i;

    /* renamed from: j */
    private boolean f3009j;

    public TranslationDisplayData(TranslationData translationData) {
        super(translationData);
        this.f3007h = false;
        this.f3008i = false;
        this.f3009j = false;
    }

    public TranslationDisplayData(String str, String str2, int i, int i2, int i3, String str3, String str4) {
        super(str, str2, i, i2, i3, str3, str4);
        this.f3007h = false;
        this.f3008i = false;
        this.f3009j = false;
    }

    /* renamed from: a */
    private void m2902a(String str) {
        Log.m2958e("[TranslationDisplayData]" + str);
    }

    /* renamed from: b */
    private void m2903b(String str) {
        Log.m2963i("[TranslationDisplayData]" + str);
    }

    public Object clone() {
        try {
            TranslationDisplayData translationDisplayData = (TranslationDisplayData) super.clone();
            translationDisplayData.f3000a = this.f3000a;
            translationDisplayData.f3001b = this.f3001b;
            translationDisplayData.f3002c = this.f3002c;
            translationDisplayData.f3003d = this.f3003d;
            translationDisplayData.f3004e = this.f3004e;
            translationDisplayData.f3005f = this.f3005f;
            translationDisplayData.f3006g = this.f3006g;
            translationDisplayData.f3007h = this.f3007h;
            translationDisplayData.f3008i = this.f3008i;
            translationDisplayData.f3009j = this.f3009j;
            return translationDisplayData;
        } catch (CloneNotSupportedException e) {
            m2902a(new StringBuilder().append(e).toString());
            return null;
        }
    }

    @Override // com.sds.coolots.common.controller.translation.data.TranslationData
    public void dispose() {
        super.dispose();
    }

    public boolean isNowRecognizing() {
        return this.f3007h;
    }

    public boolean isNowTTSPlaying() {
        return this.f3009j;
    }

    public boolean isNowTranslating() {
        return this.f3008i;
    }

    public void setData(TranslationDisplayData translationDisplayData) {
        this.f3001b = translationDisplayData.f3001b;
        this.f3002c = translationDisplayData.f3002c;
        this.f3003d = translationDisplayData.f3003d;
        this.f3004e = translationDisplayData.f3004e;
        this.f3005f = null;
        this.f3005f = translationDisplayData.f3005f;
        this.f3006g = null;
        this.f3006g = translationDisplayData.f3006g;
        if (translationDisplayData instanceof TranslationDisplayData) {
            this.f3007h = translationDisplayData.f3007h;
            this.f3008i = translationDisplayData.f3008i;
            this.f3009j = translationDisplayData.f3009j;
        } else {
            this.f3007h = false;
            this.f3008i = false;
            this.f3009j = false;
        }
    }

    public void setNowRecognizing(boolean z) {
        this.f3007h = z;
    }

    public void setNowTTSPlaying(boolean z) {
        this.f3009j = z;
    }

    public void setNowTranslating(boolean z) {
        this.f3008i = z;
    }

    public String toString() {
        String str = String.valueOf(String.valueOf(String.valueOf(String.valueOf("\nID: " + this.f3000a + "\n") + "mUserID: " + this.f3001b + "\n") + "mInLanguage: " + this.f3002c + "\n") + "mOutLanguage: " + this.f3003d + "\n") + "mNationalFlag: " + this.f3004e + "\n";
        if (this.f3005f != null) {
            str = String.valueOf(str) + "mRecognizedText: " + this.f3005f + "\n";
        }
        if (this.f3006g != null) {
            str = String.valueOf(str) + "mTranslatedText: " + this.f3006g + "\n";
        }
        return String.valueOf(String.valueOf(String.valueOf(str) + "mNowRecognizing: " + this.f3007h + "\n") + "mNowTrnaslating" + this.f3008i + "\n") + "mNowTTSPlay: " + this.f3009j + "\n";
    }
}
