package com.sec.vip.amschaton;

import android.app.Dialog;
import android.view.View;

/* renamed from: com.sec.vip.amschaton.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC0705h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSFileInfo f4332a;

    /* renamed from: b */
    final /* synthetic */ Dialog f4333b;

    /* renamed from: c */
    final /* synthetic */ AMSFileListActivity f4334c;

    ViewOnClickListenerC0705h(AMSFileListActivity aMSFileListActivity, AMSFileInfo aMSFileInfo, Dialog dialog) {
        this.f4334c = aMSFileListActivity;
        this.f4332a = aMSFileInfo;
        this.f4333b = dialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4334c.m3909a(this.f4332a.m3898a());
        this.f4333b.dismiss();
    }
}
