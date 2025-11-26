package com.sec.chaton.settings;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: FragmentPasswordLockHint.java */
/* renamed from: com.sec.chaton.settings.dv */
/* loaded from: classes.dex */
class C2658dv implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FragmentPasswordLockHint f9923a;

    C2658dv(FragmentPasswordLockHint fragmentPasswordLockHint) {
        this.f9923a = fragmentPasswordLockHint;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        for (int i2 = 0; i2 < this.f9923a.f9166c.length(); i2++) {
            if (this.f9923a.f9166c.getText().charAt(i2) != ' ') {
                this.f9923a.m9122b();
                return true;
            }
        }
        return false;
    }
}
