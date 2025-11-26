package com.sec.chaton.localbackup.p045a;

import android.content.DialogInterface;
import com.sec.common.util.p070a.C3332a;

/* compiled from: BackupFileDownloadHelperTask.java */
/* renamed from: com.sec.chaton.localbackup.a.c */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1612c implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f6000a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC1610a f6001b;

    DialogInterfaceOnClickListenerC1612c(AsyncTaskC1610a asyncTaskC1610a, String str) {
        this.f6001b = asyncTaskC1610a;
        this.f6000a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C3332a.m11750a().m11756a(this.f6001b.f5998m, this.f6000a);
    }
}
