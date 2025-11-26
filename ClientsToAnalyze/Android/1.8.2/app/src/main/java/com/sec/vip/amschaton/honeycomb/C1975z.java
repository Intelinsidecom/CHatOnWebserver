package com.sec.vip.amschaton.honeycomb;

import com.sec.vip.amschaton.InterfaceC1848ah;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.z */
/* loaded from: classes.dex */
class C1975z implements InterfaceC1848ah {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7127a;

    C1975z(AMSComposerActivity aMSComposerActivity) {
        this.f7127a = aMSComposerActivity;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1848ah
    public void onClick(int i, boolean z) throws Throwable {
        AMSComposerActivity.f6910l = false;
        String strM6589c = this.f7127a.f6930S;
        switch (i) {
            case 1:
                String strM6663z = this.f7127a.m6663z();
                if (strM6663z != null) {
                    if (this.f7127a.f6932U) {
                        this.f7127a.m6589c(false);
                    }
                    this.f7127a.m6578a(strM6663z, (z ? 2 : 0) | 0);
                    break;
                }
                break;
            case 2:
                this.f7127a.m6625j();
                this.f7127a.f6934W = true;
                this.f7127a.m6620i();
                break;
            default:
                if (this.f7127a.f6932U) {
                    strM6589c = this.f7127a.m6589c(true);
                }
                if (strM6589c != null) {
                    this.f7127a.m6578a(strM6589c, (z ? 2 : 0) | 1);
                    break;
                }
                break;
        }
    }
}
