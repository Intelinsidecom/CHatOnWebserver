package com.sec.vip.amschaton;

import android.view.View;
import android.widget.AdapterView;
import com.sec.pns.msg.MsgResultCode;

/* renamed from: com.sec.vip.amschaton.au */
/* loaded from: classes.dex */
class C0647au implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionDialog f4257a;

    C0647au(AMSStampSelectionDialog aMSStampSelectionDialog) {
        this.f4257a = aMSStampSelectionDialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2 = this.f4257a.f4052h[i];
        if (i2 >= 1000) {
            this.f4257a.f4050f = (i2 + this.f4257a.f4057m.m4063b()) - MsgResultCode.SUCCESS;
        } else {
            this.f4257a.f4050f = i2;
        }
        if (this.f4257a.f4085e != null) {
            this.f4257a.f4085e.mo4161b();
        }
        this.f4257a.dismiss();
    }
}
