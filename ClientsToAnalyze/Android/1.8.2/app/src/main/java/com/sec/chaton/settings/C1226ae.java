package com.sec.chaton.settings;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: ActivityPasswordLockHint.java */
/* renamed from: com.sec.chaton.settings.ae */
/* loaded from: classes.dex */
class C1226ae implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ActivityPasswordLockHint f4765a;

    C1226ae(ActivityPasswordLockHint activityPasswordLockHint) {
        this.f4765a = activityPasswordLockHint;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 || this.f4765a.f4514c.length() <= 0) {
            return false;
        }
        this.f4765a.m4522a();
        return true;
    }
}
