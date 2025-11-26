package com.sec.vip.amschaton.ics;

import com.sec.vip.amschaton.InterfaceC1848ah;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.j */
/* loaded from: classes.dex */
class C2043j implements InterfaceC1848ah {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7337a;

    C2043j(AMSComposerActivity aMSComposerActivity) {
        this.f7337a = aMSComposerActivity;
    }

    @Override // com.sec.vip.amschaton.InterfaceC1848ah
    public void onClick(int i, boolean z) throws Throwable {
        AMSComposerActivity.f7138l = false;
        String strM6924d = this.f7337a.f7165Z;
        switch (i) {
            case 1:
                String strM6884D = this.f7337a.m6884D();
                if (strM6884D != null) {
                    if (this.f7337a.f7167ab) {
                        this.f7337a.m6924d(false);
                    }
                    this.f7337a.m6907a(strM6884D, (z ? 2 : 0) | 0);
                    break;
                }
                break;
            case 2:
                this.f7337a.m6956j();
                this.f7337a.f7152M = true;
                this.f7337a.m6950i();
                break;
            default:
                if (this.f7337a.f7167ab) {
                    strM6924d = this.f7337a.m6924d(true);
                }
                if (strM6924d != null) {
                    this.f7337a.m6907a(strM6924d, (z ? 2 : 0) | 1);
                    break;
                }
                break;
        }
    }
}
