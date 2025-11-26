package com.sec.vip.amschaton.ics;

import com.sec.chaton.R;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.DialogC1873bf;
import com.sec.vip.amschaton.InterfaceC1872be;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bj */
/* loaded from: classes.dex */
class C2014bj implements InterfaceC1872be {

    /* renamed from: a */
    final /* synthetic */ DialogC1873bf f7297a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f7298b;

    C2014bj(AMSPlayerActivity aMSPlayerActivity, DialogC1873bf dialogC1873bf) {
        this.f7298b = aMSPlayerActivity;
        this.f7297a = dialogC1873bf;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: e_ */
    public boolean mo6437e_() {
        return false;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1872be
    /* renamed from: d_ */
    public boolean mo6436d_() {
        if (!this.f7298b.m7042a(this.f7298b.f7213p, AMSActivity.f6610c + this.f7297a.m6476a() + ".jpg")) {
            this.f7298b.m6262a(R.string.ams_error_ams_file_save);
        } else {
            this.f7298b.m6262a(R.string.ams_msg_saved);
        }
        return false;
    }
}
