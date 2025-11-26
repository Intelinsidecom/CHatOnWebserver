package com.sec.chaton.smsplugin.spam;

import android.view.View;

/* compiled from: SetupSpamNumberList.java */
/* renamed from: com.sec.chaton.smsplugin.spam.au */
/* loaded from: classes.dex */
class ViewOnClickListenerC3990au implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SetupSpamNumberList f14431a;

    ViewOnClickListenerC3990au(SetupSpamNumberList setupSpamNumberList) {
        this.f14431a = setupSpamNumberList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean zIsChecked = this.f14431a.f14374y.isChecked();
        for (int i = 0; i < this.f14431a.f14373x.getCount() - this.f14431a.f14344A; i++) {
            this.f14431a.f14373x.setItemChecked(this.f14431a.f14344A + i, !zIsChecked);
        }
        this.f14431a.f14374y.setChecked(zIsChecked ? false : true);
        this.f14431a.m15393l();
    }
}
