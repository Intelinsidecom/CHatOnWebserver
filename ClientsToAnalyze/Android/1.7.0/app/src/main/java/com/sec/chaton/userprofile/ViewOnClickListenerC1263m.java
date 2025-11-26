package com.sec.chaton.userprofile;

import android.view.View;

/* compiled from: BirthdayActivity.java */
/* renamed from: com.sec.chaton.userprofile.m */
/* loaded from: classes.dex */
class ViewOnClickListenerC1263m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BirthdayActivity f4360a;

    ViewOnClickListenerC1263m(BirthdayActivity birthdayActivity) {
        this.f4360a = birthdayActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws NumberFormatException {
        if (this.f4360a.f4096q == null || !this.f4360a.f4096q.isShowing()) {
            this.f4360a.m4275g();
        }
    }
}
