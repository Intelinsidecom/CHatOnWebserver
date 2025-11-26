package com.sec.chaton.registration;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.el */
/* loaded from: classes.dex */
class C2242el implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegistPushName f8537a;

    C2242el(FragmentRegistPushName fragmentRegistPushName) {
        this.f8537a = fragmentRegistPushName;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 || this.f8537a.f8313a.length() <= 0 || this.f8537a.f8313a.getText().toString().trim().length() <= 0) {
            return false;
        }
        this.f8537a.m8642a();
        return true;
    }
}
