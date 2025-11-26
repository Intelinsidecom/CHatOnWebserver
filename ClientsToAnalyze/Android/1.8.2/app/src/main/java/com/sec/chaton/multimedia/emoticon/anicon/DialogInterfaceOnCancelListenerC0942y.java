package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.DialogInterface;

/* compiled from: AniconPackageListView.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.y */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0942y implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AniconPackageListView f3505a;

    DialogInterfaceOnCancelListenerC0942y(AniconPackageListView aniconPackageListView) {
        this.f3505a = aniconPackageListView;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f3505a.m3754i();
    }
}
