package com.sec.chaton.registration;

import android.view.KeyEvent;
import android.widget.TextView;
import com.sec.chaton.registration.ActivityRegistPushName;

/* compiled from: ActivityRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ac */
/* loaded from: classes.dex */
class C0931ac implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegistPushName.RegistPushNameFragment f3318a;

    C0931ac(ActivityRegistPushName.RegistPushNameFragment registPushNameFragment) {
        this.f3318a = registPushNameFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 || this.f3318a.f3232a.length() <= 0) {
            return false;
        }
        this.f3318a.m3717a();
        return true;
    }
}
