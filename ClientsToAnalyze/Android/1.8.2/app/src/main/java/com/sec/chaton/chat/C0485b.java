package com.sec.chaton.chat;

import android.view.View;
import com.sec.widget.InterfaceC2154z;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.b */
/* loaded from: classes.dex */
class C0485b implements InterfaceC2154z {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2067a;

    C0485b(ChatFragment chatFragment) {
        this.f2067a = chatFragment;
    }

    @Override // com.sec.widget.InterfaceC2154z
    /* renamed from: a */
    public void mo2677a(View view, boolean z) {
        if (this.f2067a.f1818ag) {
            this.f2067a.f1818ag = false;
            return;
        }
        this.f2067a.f1818ag = false;
        if (z && this.f2067a.f1852bO != null && this.f2067a.f1909w) {
            this.f2067a.f1909w = false;
        }
    }
}
