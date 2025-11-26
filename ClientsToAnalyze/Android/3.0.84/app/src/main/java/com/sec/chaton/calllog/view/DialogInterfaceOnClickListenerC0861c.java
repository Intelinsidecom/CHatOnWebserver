package com.sec.chaton.calllog.view;

import android.content.DialogInterface;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.c */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0861c implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CallLogDetailFragment f3380a;

    DialogInterfaceOnClickListenerC0861c(CallLogDetailFragment callLogDetailFragment) {
        this.f3380a = callLogDetailFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
