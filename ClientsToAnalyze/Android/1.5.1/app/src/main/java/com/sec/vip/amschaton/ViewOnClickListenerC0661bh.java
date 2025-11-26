package com.sec.vip.amschaton;

import android.app.Dialog;
import android.view.View;
import com.sec.pns.msg.MsgResultCode;

/* renamed from: com.sec.vip.amschaton.bh */
/* loaded from: classes.dex */
class ViewOnClickListenerC0661bh implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSFileInfo f4279a;

    /* renamed from: b */
    final /* synthetic */ Dialog f4280b;

    /* renamed from: c */
    final /* synthetic */ AMSFileListActivity f4281c;

    ViewOnClickListenerC0661bh(AMSFileListActivity aMSFileListActivity, AMSFileInfo aMSFileInfo, Dialog dialog) {
        this.f4281c = aMSFileListActivity;
        this.f4279a = aMSFileInfo;
        this.f4280b = dialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4281c.m3910a(this.f4279a.m3898a(), MsgResultCode.UNKNOWN_MESSAGE_TYPE);
        this.f4280b.dismiss();
    }
}
