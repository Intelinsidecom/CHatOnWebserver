package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.settings.downloads.p056a.AsyncTaskC2533x;

/* compiled from: SoundDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.db */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2616db implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9840a;

    /* renamed from: b */
    final /* synthetic */ SoundDownloads f9841b;

    DialogInterfaceOnClickListenerC2616db(SoundDownloads soundDownloads, String str) {
        this.f9841b = soundDownloads;
        this.f9840a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new AsyncTaskC2533x(this.f9841b.f9593b, false).execute(this.f9840a);
    }
}
