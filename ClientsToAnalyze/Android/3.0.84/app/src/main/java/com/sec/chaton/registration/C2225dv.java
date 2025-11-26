package com.sec.chaton.registration;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dv */
/* loaded from: classes.dex */
class C2225dv implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f8519a;

    C2225dv(FragmentRegist fragmentRegist) {
        this.f8519a = fragmentRegist;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 || this.f8519a.f8312z.getText().length() <= 0 || this.f8519a.f8261A.m11463a().length() <= 0 || TextUtils.isEmpty(this.f8519a.f8309w)) {
            return false;
        }
        this.f8519a.m8574a("SMS");
        return true;
    }
}
