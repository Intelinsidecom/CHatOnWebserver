package com.sec.chaton.registration;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.df */
/* loaded from: classes.dex */
class C3218df implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f11983a;

    C3218df(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f11983a = fragmentNonSelfSMS;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 || this.f11983a.f11685g.length() != 4) {
            return false;
        }
        this.f11983a.m12872b();
        return true;
    }
}
