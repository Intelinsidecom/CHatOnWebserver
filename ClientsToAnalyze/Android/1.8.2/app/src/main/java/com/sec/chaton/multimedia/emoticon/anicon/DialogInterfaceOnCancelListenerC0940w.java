package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.DialogInterface;

/* compiled from: AniconPackageListView.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.w */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0940w implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AniconPackageListView f3503a;

    DialogInterfaceOnCancelListenerC0940w(AniconPackageListView aniconPackageListView) {
        this.f3503a = aniconPackageListView;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f3503a.getFragmentManager().popBackStack();
        this.f3503a.f3442h.m2710c();
        this.f3503a.f3451q = true;
    }
}
