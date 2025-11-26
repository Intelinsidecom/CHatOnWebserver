package com.sec.chaton.multimedia.geotag;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.e */
/* loaded from: classes.dex */
class C0801e implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f2733a;

    C0801e(GeotagActivity geotagActivity) {
        this.f2733a = geotagActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.f2733a.m3297a(textView.getText().toString());
        return false;
    }
}
