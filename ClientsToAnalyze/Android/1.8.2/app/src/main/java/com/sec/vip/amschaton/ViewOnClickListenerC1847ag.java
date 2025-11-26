package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSSendDialog.java */
/* renamed from: com.sec.vip.amschaton.ag */
/* loaded from: classes.dex */
class ViewOnClickListenerC1847ag implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC1841aa f6777a;

    ViewOnClickListenerC1847ag(DialogC1841aa dialogC1841aa) {
        this.f6777a = dialogC1841aa;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6777a.f6771f.onClick(view.getId(), this.f6777a.f6770e);
        this.f6777a.m6388b();
        this.f6777a.dismiss();
    }
}
