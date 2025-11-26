package com.samsung.sdraw;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class PresetTabletPenTypeImages extends C1044cc {
    @Override // com.samsung.sdraw.C1044cc
    public /* bridge */ /* synthetic */ int getThumbPaddingTop() {
        return super.getThumbPaddingTop();
    }

    public PresetTabletPenTypeImages(Context context, String assetPath) {
        super(context, assetPath);
    }

    public Drawable[] getPenTypeList() {
        Drawable drawableC = m1531c("/snote_tablet_popup_btn_03.png");
        Drawable drawableC2 = m1531c("/snote_tablet_popup_btn_04.png");
        Drawable drawableC3 = m1531c("/snote_tablet_popup_btn_05.png");
        Drawable drawableC4 = m1531c("/snote_tablet_popup_btn_01.png");
        Drawable drawableC5 = m1531c("/snote_tablet_popup_btn_02.png");
        Drawable[] drawableArr = new Drawable[6];
        drawableArr[0] = drawableC;
        drawableArr[1] = drawableC2;
        drawableArr[2] = drawableC5;
        drawableArr[3] = drawableC4;
        drawableArr[5] = drawableC3;
        return drawableArr;
    }
}
