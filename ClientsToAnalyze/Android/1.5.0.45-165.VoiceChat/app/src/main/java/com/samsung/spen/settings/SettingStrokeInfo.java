package com.samsung.spen.settings;

import android.util.Log;

/* loaded from: classes.dex */
public class SettingStrokeInfo {

    /* renamed from: a */
    private int f2045a = -16777216;

    /* renamed from: b */
    private int f2046b = 0;

    /* renamed from: c */
    private float f2047c = 10.0f;

    public void setStrokeStyle(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 100) {
            this.f2046b = i;
        } else {
            Log.w("SAMMLibrary", "Undefined Stroke Style : " + i + " , The stroke style is set as solid style.");
            this.f2046b = 0;
        }
    }

    public int getStrokeStyle() {
        return this.f2046b;
    }

    public void setStrokeColor(int i) {
        this.f2045a = i;
    }

    public int getStrokeColor() {
        return this.f2045a;
    }

    public void setStrokeAlpha(int i) {
        if (this.f2046b == 2) {
            if (i < 0 || i > 255) {
                i = 255;
            }
            this.f2045a = (i << 24) | (this.f2045a & 16777215);
        }
    }

    public int getStrokeAlpha() {
        return (this.f2045a >> 24) & 255;
    }

    public void setStrokeWidth(float f) {
        if (this.f2046b == 4) {
            if (f < 1.0f) {
                Log.w("SAMMLibrary", "Stroke(Eraser) size is too small. set to 1");
                f = 1.0f;
            } else if (f > 89.0f) {
                Log.w("SAMMLibrary", "Stroke(Eraser) size is too large. set to 89");
                f = 89.0f;
            }
        } else if (f < 1.0f) {
            Log.w("SAMMLibrary", "Stroke(Pen) size is too small. set to 1");
            f = 1.0f;
        } else if (f > 72.0f) {
            Log.w("SAMMLibrary", "Stroke(Pen) size is too large. set to 72");
            f = 72.0f;
        }
        this.f2047c = f;
    }

    public float getStrokeWidth() {
        return this.f2047c;
    }
}
