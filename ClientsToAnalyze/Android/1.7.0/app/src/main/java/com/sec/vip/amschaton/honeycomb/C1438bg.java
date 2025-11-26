package com.sec.vip.amschaton.honeycomb;

import com.sec.chaton.R;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.DialogC1379ap;
import com.sec.vip.amschaton.InterfaceC1397bg;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bg */
/* loaded from: classes.dex */
class C1438bg implements InterfaceC1397bg {

    /* renamed from: a */
    final /* synthetic */ DialogC1379ap f5072a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f5073b;

    C1438bg(AMSPlayerActivity aMSPlayerActivity, DialogC1379ap dialogC1379ap) {
        this.f5073b = aMSPlayerActivity;
        this.f5072a = dialogC1379ap;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: a */
    public boolean mo4926a() {
        return false;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1397bg
    /* renamed from: b */
    public boolean mo4927b() {
        if (!this.f5073b.m5160a(this.f5073b.f4998n, AMSActivity.f4624f + this.f5072a.m4938a() + ".jpg")) {
            this.f5073b.m4738a(R.string.ams_error_ams_file_save);
        } else {
            this.f5073b.m4738a(R.string.ams_msg_saved);
        }
        return false;
    }
}
