package com.sec.vip.amschaton;

import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.pns.msg.MsgResultCode;

/* renamed from: com.sec.vip.amschaton.be */
/* loaded from: classes.dex */
class C0658be implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSFileListActivity f4272a;

    C0658be(AMSFileListActivity aMSFileListActivity) {
        this.f4272a = aMSFileListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (!this.f4272a.f3947p && i >= 1) {
            AMSFileInfo aMSFileInfoM3950d = AMSFileManager.m3931a().m3950d(i - 1);
            if (aMSFileInfoM3950d == null) {
                ChatONLogWriter.m3499a("amsFile is NULL!", getClass().getSimpleName());
            } else {
                this.f4272a.m3910a(aMSFileInfoM3950d.m3898a(), MsgResultCode.UNEXPECTED_MESSAGE);
            }
        }
    }
}
