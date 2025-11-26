package com.sec.vip.amschaton.fragment;

import com.sec.vip.amschaton.InterfaceC3409ak;

/* compiled from: AMSViewerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.dg */
/* loaded from: classes.dex */
class C3540dg implements InterfaceC3409ak {

    /* renamed from: a */
    final /* synthetic */ AMSViewerFragment f12966a;

    C3540dg(AMSViewerFragment aMSViewerFragment) {
        this.f12966a = aMSViewerFragment;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3409ak
    public void onClick(int i, boolean z) throws Throwable {
        this.f12966a.f12795b.m12327a(true);
        String str = this.f12966a.f12797m;
        switch (i) {
            case 1:
                String strM12692n = this.f12966a.m12692n();
                if (strM12692n != null) {
                    this.f12966a.m12697a(this.f12966a.m12685i(false), strM12692n, (z ? 2 : 0) | 0);
                    break;
                }
                break;
            case 2:
                this.f12966a.m12693o();
                this.f12966a.m12694p();
                break;
            default:
                String strM12685i = this.f12966a.m12685i(true);
                if (strM12685i != null) {
                    this.f12966a.m12697a(strM12685i, "", (z ? 2 : 0) | 1);
                    break;
                }
                break;
        }
    }
}
