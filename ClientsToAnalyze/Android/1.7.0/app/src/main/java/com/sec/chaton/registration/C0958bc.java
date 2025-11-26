package com.sec.chaton.registration;

import android.view.KeyEvent;
import android.widget.TextView;
import com.sec.chaton.registration.ActivityNonSelfSMS;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.bc */
/* loaded from: classes.dex */
class C0958bc implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS.NonSelfSMSFragment f3350a;

    C0958bc(ActivityNonSelfSMS.NonSelfSMSFragment nonSelfSMSFragment) {
        this.f3350a = nonSelfSMSFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 || this.f3350a.f3160f.length() != 4) {
            return false;
        }
        this.f3350a.m3659a();
        return true;
    }
}
