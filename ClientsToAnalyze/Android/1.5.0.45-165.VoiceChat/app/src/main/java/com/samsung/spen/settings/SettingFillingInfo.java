package com.samsung.spen.settings;

import android.util.Log;

/* loaded from: classes.dex */
public class SettingFillingInfo {

    /* renamed from: a */
    private int f2043a = -16777216;

    /* renamed from: b */
    private int f2044b = 0;

    public boolean setFillingStyle(int i) {
        if (i == 0) {
            this.f2044b = i;
            return true;
        }
        Log.e("SAMMLibrary", "Undefined Filling style: " + i);
        return false;
    }

    public int getFillingStyle() {
        return this.f2044b;
    }

    public void setFillingColor(int i) {
        this.f2043a = i;
    }

    public int getFillingColor() {
        return this.f2043a;
    }
}
