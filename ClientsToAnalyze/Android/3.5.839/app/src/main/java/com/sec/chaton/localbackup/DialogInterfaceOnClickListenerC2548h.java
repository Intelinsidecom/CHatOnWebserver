package com.sec.chaton.localbackup;

import android.content.DialogInterface;
import com.sec.chaton.localbackup.noti.C2555a;

/* compiled from: ActivityLocalBackup.java */
/* renamed from: com.sec.chaton.localbackup.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2548h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f9153a;

    /* renamed from: b */
    final /* synthetic */ ActivityLocalBackup f9154b;

    DialogInterfaceOnClickListenerC2548h(ActivityLocalBackup activityLocalBackup, boolean z) {
        this.f9154b = activityLocalBackup;
        this.f9153a = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f9153a) {
            this.f9154b.f8984b.m18125b("auto_backup_on", (Boolean) true);
            this.f9154b.f8991i = true;
            this.f9154b.m10829f();
            C2555a.m10957a(this.f9154b.f8985c, true);
            return;
        }
        this.f9154b.m10829f();
    }
}
