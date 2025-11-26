package com.sec.chaton.localbackup;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BackupListView.java */
/* renamed from: com.sec.chaton.localbackup.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1649k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BackupListView f6112a;

    DialogInterfaceOnClickListenerC1649k(BackupListView backupListView) {
        this.f6112a = backupListView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6112a.m6819a();
        if (!GlobalApplication.m6456e()) {
            this.f6112a.m6813a(EnumC1652n.NORMAL);
        } else if (this.f6112a.f5957b.size() < 1) {
            this.f6112a.getActivity().finish();
            return;
        }
        this.f6112a.f5959d.invalidateViews();
    }
}
