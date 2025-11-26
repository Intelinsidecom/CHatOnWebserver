package com.sec.chaton.multimedia.geotag;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.d */
/* loaded from: classes.dex */
class C2805d implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f10157a;

    C2805d(GeotagActivity geotagActivity) {
        this.f10157a = geotagActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 3) {
            this.f10157a.m11752b(textView.getText().toString());
            return false;
        }
        return false;
    }
}
