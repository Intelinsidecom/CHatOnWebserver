package com.sec.chaton.registration;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.df */
/* loaded from: classes.dex */
class C2209df implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f8502a;

    C2209df(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f8502a = fragmentNonSelfSMS;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 || this.f8502a.f8239g.length() != 4) {
            return false;
        }
        this.f8502a.m8539b();
        return true;
    }
}
