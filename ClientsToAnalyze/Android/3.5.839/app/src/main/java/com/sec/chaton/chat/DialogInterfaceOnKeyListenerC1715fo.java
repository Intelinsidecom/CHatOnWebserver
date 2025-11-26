package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.fo */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1715fo implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ boolean f6319a;

    /* renamed from: b */
    final /* synthetic */ ChatInfoMoreFragment f6320b;

    DialogInterfaceOnKeyListenerC1715fo(ChatInfoMoreFragment chatInfoMoreFragment, boolean z) {
        this.f6320b = chatInfoMoreFragment;
        this.f6319a = z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f6320b.f5825j.dismiss();
        if (this.f6319a) {
            ((InterfaceC1722fv) this.f6320b.getActivity()).mo8333h();
        }
        return true;
    }
}
