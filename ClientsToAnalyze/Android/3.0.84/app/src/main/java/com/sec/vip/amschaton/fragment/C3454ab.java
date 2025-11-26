package com.sec.vip.amschaton.fragment;

import com.sec.vip.amschaton.InterfaceC3409ak;

/* compiled from: AMSComposerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.ab */
/* loaded from: classes.dex */
class C3454ab implements InterfaceC3409ak {

    /* renamed from: a */
    final /* synthetic */ AMSComposerFragment f12814a;

    C3454ab(AMSComposerFragment aMSComposerFragment) {
        this.f12814a = aMSComposerFragment;
    }

    @Override // com.sec.vip.amschaton.InterfaceC3409ak
    public void onClick(int i, boolean z) throws Throwable {
        AMSComposerFragment.f12651a = false;
        String strM12448c = this.f12814a.f12673U;
        switch (i) {
            case 1:
                String strM12517z = this.f12814a.m12517z();
                if (strM12517z != null) {
                    if (this.f12814a.f12675W) {
                        strM12448c = this.f12814a.m12448c(false);
                    }
                    this.f12814a.m12435a(strM12448c, strM12517z, (z ? 2 : 0) | 0);
                    break;
                }
                break;
            case 2:
                this.f12814a.m12459e();
                this.f12814a.f12677Y = true;
                ((InterfaceC3474av) this.f12814a.getActivity()).mo11978c();
                break;
            default:
                if (this.f12814a.f12675W) {
                    strM12448c = this.f12814a.m12448c(true);
                }
                if (strM12448c != null) {
                    this.f12814a.m12435a(strM12448c, "", (z ? 2 : 0) | 1);
                    break;
                }
                break;
        }
    }
}
