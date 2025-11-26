package com.sec.chaton.registration;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dw */
/* loaded from: classes.dex */
class C2226dw implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f8520a;

    C2226dw(FragmentRegist fragmentRegist) {
        this.f8520a = fragmentRegist;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6 && this.f8520a.f8261A.m11463a().length() > 0 && !TextUtils.isEmpty(this.f8520a.f8309w)) {
            if (!this.f8520a.f8268H.equals("US") && !this.f8520a.f8268H.equals("JP") && !this.f8520a.f8268H.equals("CN") && !this.f8520a.f8268H.equals("IN") && !this.f8520a.f8268H.equals("EG") && !this.f8520a.f8268H.equals("TR") && !this.f8520a.f8268H.equals("UA") && !this.f8520a.f8268H.equals("CZ") && !this.f8520a.f8268H.equals("ZA")) {
                if (this.f8520a.f8268H.equals("MM")) {
                    this.f8520a.m8574a("ACS");
                } else {
                    this.f8520a.m8574a("SMS");
                }
            } else {
                this.f8520a.m8605a();
            }
            return true;
        }
        return false;
    }
}
