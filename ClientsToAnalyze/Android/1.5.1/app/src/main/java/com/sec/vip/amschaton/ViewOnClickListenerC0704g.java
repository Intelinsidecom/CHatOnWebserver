package com.sec.vip.amschaton;

import android.app.Dialog;
import android.view.View;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.vip.amschaton.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC0704g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSFileInfo f4329a;

    /* renamed from: b */
    final /* synthetic */ Dialog f4330b;

    /* renamed from: c */
    final /* synthetic */ AMSFileListActivity f4331c;

    ViewOnClickListenerC0704g(AMSFileListActivity aMSFileListActivity, AMSFileInfo aMSFileInfo, Dialog dialog) {
        this.f4331c = aMSFileListActivity;
        this.f4329a = aMSFileInfo;
        this.f4330b = dialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f4331c.m3916b(this.f4329a.m3898a())) {
            ChatONLogWriter.m3499a("deleteOneUserItem() returns false!", getClass().getSimpleName());
        }
        this.f4330b.dismiss();
    }
}
