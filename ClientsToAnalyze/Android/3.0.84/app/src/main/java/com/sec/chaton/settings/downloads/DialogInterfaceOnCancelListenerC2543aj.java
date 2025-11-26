package com.sec.chaton.settings.downloads;

import android.content.DialogInterface;

/* compiled from: AniconPackageDetail.java */
/* renamed from: com.sec.chaton.settings.downloads.aj */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2543aj implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDetail f9689a;

    DialogInterfaceOnCancelListenerC2543aj(AniconPackageDetail aniconPackageDetail) {
        this.f9689a = aniconPackageDetail;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ((ActivityAniconPackageDetail) this.f9689a.getActivity()).m9262c();
    }
}
