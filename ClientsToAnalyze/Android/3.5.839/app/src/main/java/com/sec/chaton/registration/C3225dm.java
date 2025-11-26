package com.sec.chaton.registration;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dm */
/* loaded from: classes.dex */
class C3225dm implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f11991a;

    C3225dm(FragmentRegist fragmentRegist) {
        this.f11991a = fragmentRegist;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 || this.f11991a.f11759ar.length() <= 0 || this.f11991a.f11759ar.getText().toString().trim().length() <= 0) {
            return false;
        }
        this.f11991a.m12918a("SMS");
        return true;
    }
}
