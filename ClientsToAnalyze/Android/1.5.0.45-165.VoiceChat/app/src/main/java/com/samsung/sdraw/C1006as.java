package com.samsung.sdraw;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* renamed from: com.samsung.sdraw.as */
/* loaded from: classes.dex */
class C1006as extends C1044cc {
    public C1006as(Context context, String str) {
        super(context, str);
    }

    /* renamed from: a */
    public Drawable[] m1394a() {
        Drawable drawableC = m1531c("/snote_popup_btn_03.png");
        Drawable drawableC2 = m1531c("/snote_popup_btn_04.png");
        Drawable drawableC3 = m1531c("/snote_popup_btn_05.png");
        Drawable drawableC4 = m1531c("/snote_popup_btn_01.png");
        Drawable drawableC5 = m1531c("/snote_popup_btn_02.png");
        Drawable[] drawableArr = new Drawable[6];
        drawableArr[0] = drawableC;
        drawableArr[1] = drawableC2;
        drawableArr[2] = drawableC5;
        drawableArr[3] = drawableC4;
        drawableArr[5] = drawableC3;
        return drawableArr;
    }
}
