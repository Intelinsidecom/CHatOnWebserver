package com.sec.chaton.registration;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dy */
/* loaded from: classes.dex */
class C3237dy implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f12003a;

    C3237dy(FragmentRegist fragmentRegist) {
        this.f12003a = fragmentRegist;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6 && this.f12003a.f11720I.m18658a().length() > 0 && !TextUtils.isEmpty(this.f12003a.f11716E)) {
            if (!this.f12003a.f11728Q.equals("US") && !this.f12003a.f11728Q.equals("JP") && !this.f12003a.f11728Q.equals("CN") && !this.f12003a.f11728Q.equals("IN") && !this.f12003a.f11728Q.equals("EG") && !this.f12003a.f11728Q.equals("TR") && !this.f12003a.f11728Q.equals("UA") && !this.f12003a.f11728Q.equals("CZ") && !this.f12003a.f11728Q.equals("ZA")) {
                if (this.f12003a.f11728Q.equals("MM")) {
                    this.f12003a.m12918a("ACS");
                } else {
                    this.f12003a.m12918a("SMS");
                }
            } else {
                this.f12003a.m12956a();
            }
            return true;
        }
        return false;
    }
}
