package com.sec.chaton.calllog.view;

import android.content.DialogInterface;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.d */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1473d implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ CallLogDetailFragment f5354a;

    DialogInterfaceOnCancelListenerC1473d(CallLogDetailFragment callLogDetailFragment) {
        this.f5354a = callLogDetailFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
    }
}
