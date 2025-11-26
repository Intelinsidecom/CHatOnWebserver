package com.samsung.spen.settings;

import android.util.Log;
import com.samsung.sdraw.TextSettingInfo;

/* loaded from: classes.dex */
public class SettingTextInfo {

    /* renamed from: a */
    private int f2048a = -16777216;

    /* renamed from: b */
    private int f2049b = 0;

    /* renamed from: c */
    private float f2050c = 10.0f;

    /* renamed from: d */
    private String f2051d = null;

    /* renamed from: e */
    private int f2052e = 0;

    public void setTextStyle(int i) {
        if (i == 0 || (i & (-8)) == 0) {
            this.f2049b = i;
        } else {
            Log.w("SAMMLibrary", "Undefined Text Style : " + i);
            this.f2049b = 0;
        }
    }

    public int getTextStyle() {
        return this.f2049b;
    }

    public void setTextColor(int i) {
        this.f2048a = i;
    }

    public int getTextColor() {
        return this.f2048a;
    }

    public void setTextSize(float f) {
        if (f < 5.0f) {
            Log.w("SAMMLibrary", "Text size is too small. set to 5");
            f = 5.0f;
        } else if (f > 20.0f) {
            Log.w("SAMMLibrary", "Text size is too large. set to 20");
            f = 20.0f;
        }
        this.f2050c = f;
    }

    public float getTextSize() {
        return this.f2050c;
    }

    public void setTextFont(String str) {
        if (str == null) {
            this.f2051d = null;
            return;
        }
        if (!TextSettingInfo.isValidFont(str)) {
            str = null;
        }
        this.f2051d = str;
    }

    public String getTextFont() {
        return this.f2051d;
    }

    public int getTextAlignment() {
        return this.f2052e;
    }

    public boolean setTextAlign(int i) {
        if (i == 0 || i == 1 || i == 2) {
            this.f2052e = i;
            return true;
        }
        Log.e("SAMMLibrary", "Undefined Text Align Option : " + i);
        return false;
    }
}
