package com.sec.vip.amschaton;

import android.content.Intent;

/* renamed from: com.sec.vip.amschaton.bu */
/* loaded from: classes.dex */
class C0674bu implements InterfaceC0702e {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4295a;

    C0674bu(AMSComposerActivity aMSComposerActivity) {
        this.f4295a = aMSComposerActivity;
    }

    @Override // com.sec.vip.amschaton.InterfaceC0702e
    /* renamed from: a */
    public void mo4231a(int i) {
        switch (i) {
            case 28673:
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
                this.f4295a.startActivityForResult(intent, 8);
                break;
            case 28674:
                this.f4295a.m3714d();
                break;
        }
    }
}
