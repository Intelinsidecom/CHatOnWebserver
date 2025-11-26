package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;

/* compiled from: SkinListView.java */
/* renamed from: com.sec.chaton.settings.downloads.cq */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2604cq implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ SkinListView f9831a;

    DialogInterfaceOnCancelListenerC2604cq(SkinListView skinListView) {
        this.f9831a = skinListView;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f9831a.f9558b.finish();
    }
}
