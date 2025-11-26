package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.settings.downloads.p056a.AsyncTaskC2520k;

/* compiled from: FontDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.bf */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2566bf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9745a;

    /* renamed from: b */
    final /* synthetic */ FontDownloads f9746b;

    DialogInterfaceOnClickListenerC2566bf(FontDownloads fontDownloads, String str) {
        this.f9746b = fontDownloads;
        this.f9745a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new AsyncTaskC2520k(this.f9746b.f9524c, false).execute(this.f9745a);
    }
}
