package com.sec.chaton.localbackup;

import android.content.DialogInterface;

/* compiled from: BackupListView.java */
/* renamed from: com.sec.chaton.localbackup.m */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2553m implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BackupListView f9160a;

    DialogInterfaceOnClickListenerC2553m(BackupListView backupListView) {
        this.f9160a = backupListView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f9160a.m10847b();
        this.f9160a.m10841a(EnumC2557p.NORMAL);
        this.f9160a.f9000d.invalidateViews();
    }
}
