package com.sec.chaton.userprofile;

import android.view.View;

/* compiled from: BirthdayImpl.java */
/* renamed from: com.sec.chaton.userprofile.j */
/* loaded from: classes.dex */
class ViewOnClickListenerC3141j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3137f f11397a;

    ViewOnClickListenerC3141j(C3137f c3137f) {
        this.f11397a = c3137f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws NumberFormatException {
        if (this.f11397a.f11389r == null || !this.f11397a.f11389r.isShowing()) {
            this.f11397a.m10912i();
        }
    }
}
