package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.ea */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC1059ea implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ boolean f4169a;

    /* renamed from: b */
    final /* synthetic */ ChatInfoMoreFragment f4170b;

    DialogInterfaceOnKeyListenerC1059ea(ChatInfoMoreFragment chatInfoMoreFragment, boolean z) {
        this.f4170b = chatInfoMoreFragment;
        this.f4169a = z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f4170b.f3769k.dismiss();
        if (this.f4169a) {
            ((InterfaceC1066eh) this.f4170b.getActivity()).mo5065c();
        }
        return true;
    }
}
