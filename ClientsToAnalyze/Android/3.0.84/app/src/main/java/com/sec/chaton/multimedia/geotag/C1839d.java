package com.sec.chaton.multimedia.geotag;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.d */
/* loaded from: classes.dex */
class C1839d implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f6863a;

    C1839d(GeotagActivity geotagActivity) {
        this.f6863a = geotagActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 3) {
            this.f6863a.m7547b(textView.getText().toString());
            return false;
        }
        return false;
    }
}
