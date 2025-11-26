package com.sec.chaton.calllog.view;

import android.content.DialogInterface;

/* compiled from: DeleteCallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.y */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1496y implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DeleteCallLogFragment f5422a;

    DialogInterfaceOnCancelListenerC1496y(DeleteCallLogFragment deleteCallLogFragment) {
        this.f5422a = deleteCallLogFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
    }
}
