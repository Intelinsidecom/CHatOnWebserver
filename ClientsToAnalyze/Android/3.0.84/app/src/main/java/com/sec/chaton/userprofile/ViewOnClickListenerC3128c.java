package com.sec.chaton.userprofile;

import android.view.View;

/* compiled from: BirthdayFragment.java */
/* renamed from: com.sec.chaton.userprofile.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC3128c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BirthdayFragment f11361a;

    ViewOnClickListenerC3128c(BirthdayFragment birthdayFragment) {
        this.f11361a = birthdayFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws NumberFormatException {
        if (this.f11361a.f11038n == null || !this.f11361a.f11038n.isShowing()) {
            this.f11361a.m10637f();
        }
    }
}
