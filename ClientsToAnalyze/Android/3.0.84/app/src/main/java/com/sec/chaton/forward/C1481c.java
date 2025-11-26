package com.sec.chaton.forward;

import com.sec.chaton.msgbox.InterfaceC1712ap;

/* compiled from: ChatForwardFragment.java */
/* renamed from: com.sec.chaton.forward.c */
/* loaded from: classes.dex */
class C1481c implements InterfaceC1712ap {

    /* renamed from: a */
    final /* synthetic */ ChatForwardFragment f5488a;

    C1481c(ChatForwardFragment chatForwardFragment) {
        this.f5488a = chatForwardFragment;
    }

    @Override // com.sec.chaton.msgbox.InterfaceC1712ap
    /* renamed from: a */
    public void mo6416a(boolean z) {
        if (this.f5488a.f5482t != null) {
            this.f5488a.f5482t.setEnabled(z);
        }
    }
}
