package com.sec.chaton.multimedia.geotag;

import android.view.KeyEvent;
import android.widget.TextView;

/* renamed from: com.sec.chaton.multimedia.geotag.c */
/* loaded from: classes.dex */
class C0299c implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f2168a;

    C0299c(GeotagActivity geotagActivity) {
        this.f2168a = geotagActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.f2168a.m2553a(textView.getText().toString());
        return false;
    }
}
