package com.sec.chaton.registration;

import android.view.KeyEvent;
import android.widget.TextView;
import com.sec.chaton.registration.ActivityRegist;

/* compiled from: ActivityRegist.java */
/* renamed from: com.sec.chaton.registration.w */
/* loaded from: classes.dex */
class C0991w implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegistFragment f3387a;

    C0991w(ActivityRegist.RegistFragment registFragment) {
        this.f3387a = registFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 || this.f3387a.f3220o.length() <= 0) {
            return false;
        }
        this.f3387a.m3691a("SMS");
        return true;
    }
}
