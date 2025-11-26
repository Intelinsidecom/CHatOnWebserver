package com.sec.vip.amschaton;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.pns.msg.MsgResultCode;

/* renamed from: com.sec.vip.amschaton.bi */
/* loaded from: classes.dex */
class C0662bi implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSFileListActivity f4282a;

    C0662bi(AMSFileListActivity aMSFileListActivity) {
        this.f4282a = aMSFileListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.f4282a.f3947p) {
            return;
        }
        AMSFileInfo aMSFileInfoM3943a = AMSFileManager.m3931a().m3943a(i);
        if (aMSFileInfoM3943a == null) {
            ChatONLogWriter.m3499a("amsFile is NULL!", getClass().getSimpleName());
        } else {
            this.f4282a.m3910a(aMSFileInfoM3943a.m3898a(), MsgResultCode.UNKNOWN_MESSAGE_TYPE);
        }
    }
}
