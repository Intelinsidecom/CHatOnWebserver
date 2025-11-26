package com.sec.vip.amschaton;

import android.app.Dialog;
import android.view.View;
import com.sec.pns.msg.MsgResultCode;

/* renamed from: com.sec.vip.amschaton.bf */
/* loaded from: classes.dex */
class ViewOnClickListenerC0659bf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSFileInfo f4273a;

    /* renamed from: b */
    final /* synthetic */ Dialog f4274b;

    /* renamed from: c */
    final /* synthetic */ AMSFileListActivity f4275c;

    ViewOnClickListenerC0659bf(AMSFileListActivity aMSFileListActivity, AMSFileInfo aMSFileInfo, Dialog dialog) {
        this.f4275c = aMSFileListActivity;
        this.f4273a = aMSFileInfo;
        this.f4274b = dialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4275c.m3910a(this.f4273a.m3898a(), MsgResultCode.UNEXPECTED_MESSAGE);
        this.f4274b.dismiss();
    }
}
