package com.sec.chaton.sns.p115ui;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* compiled from: SnsFriendsPickerFragment.java */
/* renamed from: com.sec.chaton.sns.ui.w */
/* loaded from: classes.dex */
class DialogInterfaceOnKeyListenerC4518w implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ boolean f16267a;

    /* renamed from: b */
    final /* synthetic */ SnsFriendsPickerFragment f16268b;

    DialogInterfaceOnKeyListenerC4518w(SnsFriendsPickerFragment snsFriendsPickerFragment, boolean z) {
        this.f16268b = snsFriendsPickerFragment;
        this.f16267a = z;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f16268b.f16029n.dismiss();
        if (this.f16267a) {
            this.f16268b.f16019d.finish();
        }
        return true;
    }
}
