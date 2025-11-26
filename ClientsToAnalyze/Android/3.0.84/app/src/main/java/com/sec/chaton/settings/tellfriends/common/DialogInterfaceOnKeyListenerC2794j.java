package com.sec.chaton.settings.tellfriends.common;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: SnsFriendsPickerFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.j */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC2794j implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ boolean f10288a;

    /* renamed from: b */
    final /* synthetic */ SnsFriendsPickerFragment f10289b;

    DialogInterfaceOnKeyListenerC2794j(SnsFriendsPickerFragment snsFriendsPickerFragment, boolean z) {
        this.f10289b = snsFriendsPickerFragment;
        this.f10288a = z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f10289b.f10227i.dismiss();
        if (this.f10288a) {
            this.f10289b.f10222d.finish();
        }
        return true;
    }
}
