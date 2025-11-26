package com.sec.chaton.smsplugin.multimedia.geotag;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: MmsGeotagActivity.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.geotag.h */
/* loaded from: classes.dex */
class C3930h implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ MmsGeotagActivity f14158a;

    C3930h(MmsGeotagActivity mmsGeotagActivity) {
        this.f14158a = mmsGeotagActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 3) {
            this.f14158a.m15176b(textView.getText().toString());
            return false;
        }
        return false;
    }
}
