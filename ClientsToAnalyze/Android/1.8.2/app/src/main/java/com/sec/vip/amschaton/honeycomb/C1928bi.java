package com.sec.vip.amschaton.honeycomb;

import com.sec.chaton.R;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.DialogC1873bf;
import com.sec.vip.amschaton.InterfaceC1872be;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bi */
/* loaded from: classes.dex */
class C1928bi implements InterfaceC1872be {

    /* renamed from: a */
    final /* synthetic */ DialogC1873bf f7067a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f7068b;

    C1928bi(AMSPlayerActivity aMSPlayerActivity, DialogC1873bf dialogC1873bf) {
        this.f7068b = aMSPlayerActivity;
        this.f7067a = dialogC1873bf;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: e_ */
    public boolean mo6437e_() {
        return false;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: d_ */
    public boolean mo6436d_() {
        if (!this.f7068b.m6718a(this.f7068b.f6985q, AMSActivity.f6610c + this.f7067a.m6476a() + ".jpg")) {
            this.f7068b.m6262a(R.string.ams_error_ams_file_save);
        } else {
            this.f7068b.m6262a(R.string.ams_msg_saved);
        }
        return false;
    }
}
