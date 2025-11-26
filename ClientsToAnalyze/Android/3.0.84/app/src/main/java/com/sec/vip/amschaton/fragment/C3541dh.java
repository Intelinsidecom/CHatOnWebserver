package com.sec.vip.amschaton.fragment;

import com.sec.chaton.R;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.DialogC3435bj;
import com.sec.vip.amschaton.InterfaceC3434bi;

/* compiled from: AMSViewerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.dh */
/* loaded from: classes.dex */
class C3541dh implements InterfaceC3434bi {

    /* renamed from: a */
    final /* synthetic */ DialogC3435bj f12967a;

    /* renamed from: b */
    final /* synthetic */ AMSViewerFragment f12968b;

    C3541dh(AMSViewerFragment aMSViewerFragment, DialogC3435bj dialogC3435bj) {
        this.f12968b = aMSViewerFragment;
        this.f12967a = dialogC3435bj;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3434bi
    /* renamed from: a */
    public boolean mo12234a() {
        return false;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3434bi
    /* renamed from: b */
    public boolean mo12235b() {
        if (!this.f12968b.m12662a(this.f12968b.f12797m, AMSActivity.f12270c + this.f12967a.m12298a() + ".jpg")) {
            this.f12968b.m12524a(R.string.ams_error_ams_file_save);
        } else {
            this.f12968b.m12524a(R.string.ams_msg_saved);
        }
        return false;
    }
}
