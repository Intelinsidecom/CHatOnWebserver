package com.sec.vip.amschaton;

import android.app.Dialog;
import android.view.View;

/* renamed from: com.sec.vip.amschaton.bg */
/* loaded from: classes.dex */
class ViewOnClickListenerC0660bg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSFileInfo f4276a;

    /* renamed from: b */
    final /* synthetic */ Dialog f4277b;

    /* renamed from: c */
    final /* synthetic */ AMSFileListActivity f4278c;

    ViewOnClickListenerC0660bg(AMSFileListActivity aMSFileListActivity, AMSFileInfo aMSFileInfo, Dialog dialog) {
        this.f4278c = aMSFileListActivity;
        this.f4276a = aMSFileInfo;
        this.f4277b = dialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4278c.m3909a(this.f4276a.m3898a());
        this.f4277b.dismiss();
    }
}
