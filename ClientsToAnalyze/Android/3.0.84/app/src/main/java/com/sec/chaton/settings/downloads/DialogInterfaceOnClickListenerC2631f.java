package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.settings.downloads.p056a.AsyncTaskC2513d;

/* compiled from: AmsItemBackgroundDetail.java */
/* renamed from: com.sec.chaton.settings.downloads.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2631f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AmsItemBackgroundDetail f9874a;

    DialogInterfaceOnClickListenerC2631f(AmsItemBackgroundDetail amsItemBackgroundDetail) {
        this.f9874a = amsItemBackgroundDetail;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new AsyncTaskC2513d(this.f9874a.f9415c, true).execute(EnumC1327e.Background, this.f9874a.f9420h);
    }
}
