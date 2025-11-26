package com.sec.chaton.settings;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: FragmentPasswordLockHint.java */
/* renamed from: com.sec.chaton.settings.er */
/* loaded from: classes.dex */
class C3608er implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FragmentPasswordLockHint f13139a;

    C3608er(FragmentPasswordLockHint fragmentPasswordLockHint) {
        this.f13139a = fragmentPasswordLockHint;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        for (int i2 = 0; i2 < this.f13139a.f12725c.length(); i2++) {
            if (this.f13139a.f12725c.getText().charAt(i2) != ' ') {
                this.f13139a.m13595b();
                return true;
            }
        }
        return false;
    }
}
