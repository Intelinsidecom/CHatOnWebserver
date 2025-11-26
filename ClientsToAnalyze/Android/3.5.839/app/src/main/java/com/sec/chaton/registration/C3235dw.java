package com.sec.chaton.registration;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dw */
/* loaded from: classes.dex */
class C3235dw implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f12001a;

    C3235dw(FragmentRegist fragmentRegist) {
        this.f12001a = fragmentRegist;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            return false;
        }
        this.f12001a.f11720I.requestFocus();
        return true;
    }
}
