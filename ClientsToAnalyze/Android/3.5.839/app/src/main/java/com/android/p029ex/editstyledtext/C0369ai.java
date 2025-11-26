package com.android.p029ex.editstyledtext;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.util.Log;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.ai */
/* loaded from: classes.dex */
public class C0369ai extends CharacterStyle {

    /* renamed from: a */
    private int f886a;

    /* renamed from: b */
    private int f887b;

    public C0369ai(int i, int i2) {
        this.f886a = i;
        m1320b(i);
        this.f887b = m1319a(i, i2);
    }

    /* renamed from: a */
    public void m1321a(int i) {
        this.f887b = m1319a(this.f886a, i);
    }

    /* renamed from: a */
    private int m1319a(int i, int i2) {
        int iAlpha = Color.alpha(i2);
        int iRed = Color.red(i2);
        int iGreen = Color.green(i2);
        int iBlue = Color.blue(i2);
        if (iAlpha == 0) {
            iAlpha = 128;
        }
        switch (i) {
            case 0:
                if (iRed > 128) {
                    iRed /= 2;
                    break;
                } else {
                    iRed = (255 - iRed) / 2;
                    break;
                }
            case 1:
                if (iGreen > 128) {
                    iGreen /= 2;
                    break;
                } else {
                    iGreen = (255 - iGreen) / 2;
                    break;
                }
            case 2:
                return 16777215;
            default:
                Log.e("EditStyledText", "--- getMarqueeColor: got illigal marquee ID.");
                return 16777215;
        }
        return Color.argb(iAlpha, iRed, iGreen, iBlue);
    }

    /* renamed from: b */
    private boolean m1320b(int i) {
        if (i == 0 || i == 1) {
            return true;
        }
        Log.e("EditStyledTextSpan", "--- Invalid type of MarqueeSpan");
        return false;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.bgColor = this.f887b;
    }
}
