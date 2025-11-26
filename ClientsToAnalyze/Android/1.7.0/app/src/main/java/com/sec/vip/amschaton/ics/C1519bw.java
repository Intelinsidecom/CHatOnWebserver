package com.sec.vip.amschaton.ics;

import com.sec.chaton.R;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.DialogC1379ap;
import com.sec.vip.amschaton.InterfaceC1397bg;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bw */
/* loaded from: classes.dex */
class C1519bw implements InterfaceC1397bg {

    /* renamed from: a */
    final /* synthetic */ DialogC1379ap f5345a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f5346b;

    C1519bw(AMSPlayerActivity aMSPlayerActivity, DialogC1379ap dialogC1379ap) {
        this.f5346b = aMSPlayerActivity;
        this.f5345a = dialogC1379ap;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: a */
    public boolean mo4926a() {
        return false;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: b */
    public boolean mo4927b() {
        if (!this.f5346b.m5483a(this.f5346b.f5242n, AMSActivity.f4624f + this.f5345a.m4938a() + ".jpg")) {
            this.f5346b.m4738a(R.string.ams_error_ams_file_save);
        } else {
            this.f5346b.m4738a(R.string.ams_msg_saved);
        }
        return false;
    }
}
