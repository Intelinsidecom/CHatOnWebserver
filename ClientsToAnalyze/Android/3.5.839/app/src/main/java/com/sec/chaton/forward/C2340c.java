package com.sec.chaton.forward;

import com.sec.chaton.msgbox.InterfaceC2652bq;

/* compiled from: ChatForwardFragment.java */
/* renamed from: com.sec.chaton.forward.c */
/* loaded from: classes.dex */
class C2340c implements InterfaceC2652bq {

    /* renamed from: a */
    final /* synthetic */ ChatForwardFragment f8323a;

    C2340c(ChatForwardFragment chatForwardFragment) {
        this.f8323a = chatForwardFragment;
    }

    @Override // com.sec.chaton.msgbox.InterfaceC2652bq
    /* renamed from: a */
    public void mo10259a(boolean z) {
        if (this.f8323a.f8317t != null) {
            this.f8323a.f8317t.setEnabled(z);
        }
    }
}
