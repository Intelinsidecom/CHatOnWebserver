package com.facebook.p009c;

import android.view.View;

/* compiled from: WebDialog.java */
/* renamed from: com.facebook.c.r */
/* loaded from: classes.dex */
class ViewOnClickListenerC0150r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC0147o f345a;

    ViewOnClickListenerC0150r(DialogC0147o dialogC0147o) {
        this.f345a = dialogC0147o;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f345a.m444a();
        this.f345a.dismiss();
    }
}
