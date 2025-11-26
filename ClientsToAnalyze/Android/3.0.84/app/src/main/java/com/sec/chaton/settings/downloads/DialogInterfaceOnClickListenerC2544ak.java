package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;
import com.sec.chaton.settings.downloads.p056a.AsyncTaskC2517h;

/* compiled from: AniconPackageDetail.java */
/* renamed from: com.sec.chaton.settings.downloads.ak */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2544ak implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDetail f9690a;

    DialogInterfaceOnClickListenerC2544ak(AniconPackageDetail aniconPackageDetail) {
        this.f9690a = aniconPackageDetail;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new AsyncTaskC2517h(this.f9690a.getActivity(), true).execute(this.f9690a.f9455c);
    }
}
