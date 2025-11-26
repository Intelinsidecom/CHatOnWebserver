package com.sec.chaton.registration;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.du */
/* loaded from: classes.dex */
class C2224du implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f8518a;

    C2224du(FragmentRegist fragmentRegist) {
        this.f8518a = fragmentRegist;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            return false;
        }
        this.f8518a.f8261A.requestFocus();
        return true;
    }
}
