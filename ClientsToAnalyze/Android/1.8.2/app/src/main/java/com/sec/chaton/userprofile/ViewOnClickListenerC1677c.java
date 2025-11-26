package com.sec.chaton.userprofile;

import android.view.View;

/* compiled from: BirthdayActivity.java */
/* renamed from: com.sec.chaton.userprofile.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC1677c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BirthdayActivity f6174a;

    ViewOnClickListenerC1677c(BirthdayActivity birthdayActivity) {
        this.f6174a = birthdayActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws NumberFormatException {
        this.f6174a.f5781l.addTextChangedListener(this.f6174a.f5791v);
        this.f6174a.m5549g();
    }
}
