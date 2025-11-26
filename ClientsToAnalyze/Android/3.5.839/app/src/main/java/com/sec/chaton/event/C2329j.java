package com.sec.chaton.event;

import android.support.v4.view.C0200cg;
import com.sec.chaton.R;

/* compiled from: UsingChatONDialogFragment.java */
/* renamed from: com.sec.chaton.event.j */
/* loaded from: classes.dex */
class C2329j extends C0200cg {

    /* renamed from: a */
    final /* synthetic */ UsingChatONDialogFragment f8281a;

    C2329j(UsingChatONDialogFragment usingChatONDialogFragment) {
        this.f8281a = usingChatONDialogFragment;
    }

    @Override // android.support.v4.view.C0200cg, android.support.v4.view.InterfaceC0196cc
    /* renamed from: b */
    public void mo622b(int i) {
    }

    @Override // android.support.v4.view.C0200cg, android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo620a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.C0200cg, android.support.v4.view.InterfaceC0196cc
    /* renamed from: a */
    public void mo619a(int i) {
        this.f8281a.f8260f = i;
        if (i == 1) {
            this.f8281a.f8264j.setBackgroundResource(R.drawable.item_using_chaton_dialog_background_second);
        } else {
            this.f8281a.f8264j.setBackgroundResource(R.drawable.item_using_chaton_dialog_background_first);
        }
        if (this.f8281a.f8261g > 1) {
            this.f8281a.m10247b();
        }
    }
}
