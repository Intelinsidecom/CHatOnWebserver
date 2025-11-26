package com.sec.chaton.multimedia.skin;

import android.content.DialogInterface;

/* compiled from: SkinListView.java */
/* renamed from: com.sec.chaton.multimedia.skin.n */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1016n implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ SkinListView f3713a;

    DialogInterfaceOnCancelListenerC1016n(SkinListView skinListView) {
        this.f3713a = skinListView;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f3713a.getFragmentManager().popBackStack();
        this.f3713a.f3674i.m2710c();
    }
}
