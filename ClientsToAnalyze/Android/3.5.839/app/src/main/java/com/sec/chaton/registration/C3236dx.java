package com.sec.chaton.registration;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dx */
/* loaded from: classes.dex */
class C3236dx implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f12002a;

    C3236dx(FragmentRegist fragmentRegist) {
        this.f12002a = fragmentRegist;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5 || this.f12002a.f11719H.getText().length() <= 0 || this.f12002a.f11720I.m18658a().length() <= 0 || TextUtils.isEmpty(this.f12002a.f11716E)) {
            return false;
        }
        if (this.f12002a.f11759ar != null) {
            this.f12002a.f11759ar.requestFocus();
        }
        return true;
    }
}
