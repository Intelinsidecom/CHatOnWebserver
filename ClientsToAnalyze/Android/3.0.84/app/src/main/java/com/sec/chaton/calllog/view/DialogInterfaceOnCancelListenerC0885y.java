package com.sec.chaton.calllog.view;

import android.content.DialogInterface;

/* compiled from: DeleteCallLogFragment.java */
/* renamed from: com.sec.chaton.calllog.view.y */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0885y implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DeleteCallLogFragment f3477a;

    DialogInterfaceOnCancelListenerC0885y(DeleteCallLogFragment deleteCallLogFragment) {
        this.f3477a = deleteCallLogFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
    }
}
