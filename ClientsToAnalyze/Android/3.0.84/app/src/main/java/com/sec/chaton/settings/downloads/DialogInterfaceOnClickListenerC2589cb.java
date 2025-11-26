package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.settings.downloads.p056a.AsyncTaskC2530u;

/* compiled from: SkinDetail.java */
/* renamed from: com.sec.chaton.settings.downloads.cb */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2589cb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SkinDetail f9813a;

    DialogInterfaceOnClickListenerC2589cb(SkinDetail skinDetail) {
        this.f9813a = skinDetail;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new AsyncTaskC2530u(this.f9813a.f9554u, true).execute(this.f9813a.f9537d);
    }
}
