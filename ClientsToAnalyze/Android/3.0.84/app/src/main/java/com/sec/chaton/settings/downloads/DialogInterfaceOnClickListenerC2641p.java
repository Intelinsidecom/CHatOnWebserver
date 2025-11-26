package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.settings.downloads.p056a.AsyncTaskC2513d;

/* compiled from: AmsItemDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.p */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2641p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC1327e f9884a;

    /* renamed from: b */
    final /* synthetic */ String f9885b;

    /* renamed from: c */
    final /* synthetic */ AmsItemDownloads f9886c;

    DialogInterfaceOnClickListenerC2641p(AmsItemDownloads amsItemDownloads, EnumC1327e enumC1327e, String str) {
        this.f9886c = amsItemDownloads;
        this.f9884a = enumC1327e;
        this.f9885b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new AsyncTaskC2513d(this.f9886c.f9430b).execute(this.f9884a, this.f9885b);
    }
}
