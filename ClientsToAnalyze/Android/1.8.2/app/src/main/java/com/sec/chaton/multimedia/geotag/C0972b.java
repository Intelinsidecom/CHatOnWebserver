package com.sec.chaton.multimedia.geotag;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.b */
/* loaded from: classes.dex */
class C0972b implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f3591a;

    C0972b(GeotagActivity geotagActivity) {
        this.f3591a = geotagActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.f3591a.m3853a(textView.getText().toString());
        return false;
    }
}
