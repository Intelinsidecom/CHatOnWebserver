package com.sec.chaton.calllog.view;

import android.content.DialogInterface;

/* compiled from: CallLogDetailFragment.java */
/* renamed from: com.sec.chaton.calllog.view.d */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0862d implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ CallLogDetailFragment f3381a;

    DialogInterfaceOnCancelListenerC0862d(CallLogDetailFragment callLogDetailFragment) {
        this.f3381a = callLogDetailFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
    }
}
