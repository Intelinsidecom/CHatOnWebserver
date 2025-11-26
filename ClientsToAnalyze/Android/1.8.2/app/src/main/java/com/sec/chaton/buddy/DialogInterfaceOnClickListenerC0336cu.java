package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.cu */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0336cu implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0334cs f1479a;

    DialogInterfaceOnClickListenerC0336cu(ViewOnClickListenerC0334cs viewOnClickListenerC0334cs) {
        this.f1479a = viewOnClickListenerC0334cs;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
