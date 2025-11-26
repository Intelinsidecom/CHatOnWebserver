package com.sec.chaton.localbackup.p075a;

import android.content.DialogInterface;
import com.sec.common.util.p133a.C5017a;

/* compiled from: BackupFileDownloadHelperTask.java */
/* renamed from: com.sec.chaton.localbackup.a.c */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2512c implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9042a;

    /* renamed from: b */
    final /* synthetic */ AsyncTaskC2510a f9043b;

    DialogInterfaceOnClickListenerC2512c(AsyncTaskC2510a asyncTaskC2510a, String str) {
        this.f9043b = asyncTaskC2510a;
        this.f9042a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C5017a.m19064a().m19070a(this.f9043b.f9040m, this.f9042a);
    }
}
