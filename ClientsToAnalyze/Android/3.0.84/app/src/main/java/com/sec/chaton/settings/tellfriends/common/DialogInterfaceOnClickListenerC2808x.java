package com.sec.chaton.settings.tellfriends.common;

import android.content.DialogInterface;

/* compiled from: SnsSubMenuFragment.java */
/* renamed from: com.sec.chaton.settings.tellfriends.common.x */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2808x implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f10320a;

    /* renamed from: b */
    final /* synthetic */ SnsSubMenuFragment f10321b;

    DialogInterfaceOnClickListenerC2808x(SnsSubMenuFragment snsSubMenuFragment, boolean z) {
        this.f10321b = snsSubMenuFragment;
        this.f10320a = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f10320a) {
            this.f10321b.f10255h.finish();
        }
    }
}
