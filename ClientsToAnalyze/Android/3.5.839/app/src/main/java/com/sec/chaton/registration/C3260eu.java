package com.sec.chaton.registration;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.eu */
/* loaded from: classes.dex */
class C3260eu implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegistPushName f12027a;

    C3260eu(FragmentRegistPushName fragmentRegistPushName) {
        this.f12027a = fragmentRegistPushName;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 || this.f12027a.f11787a.length() <= 0 || this.f12027a.f11787a.getText().toString().trim().length() <= 0) {
            return false;
        }
        this.f12027a.m12995a();
        return true;
    }
}
