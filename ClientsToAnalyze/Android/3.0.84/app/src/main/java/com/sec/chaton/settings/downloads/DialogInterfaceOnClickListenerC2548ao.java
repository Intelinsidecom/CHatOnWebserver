package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.settings.downloads.p056a.AsyncTaskC2517h;

/* compiled from: AniconPackageDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2548ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9694a;

    /* renamed from: b */
    final /* synthetic */ AniconPackageDownloads f9695b;

    DialogInterfaceOnClickListenerC2548ao(AniconPackageDownloads aniconPackageDownloads, String str) {
        this.f9695b = aniconPackageDownloads;
        this.f9694a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new AsyncTaskC2517h(this.f9695b.f9480b, false).execute(this.f9694a);
    }
}
