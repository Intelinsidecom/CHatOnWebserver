package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.DialogInterface;

/* compiled from: AniconPackageDetailActivity.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0925h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AniconPackageDetailActivity f3473a;

    DialogInterfaceOnClickListenerC0925h(AniconPackageDetailActivity aniconPackageDetailActivity) {
        this.f3473a = aniconPackageDetailActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new AsyncTaskC0929l(this.f3473a, this.f3473a.getActivity(), this.f3473a.f3391c).execute(this.f3473a.f3390b);
    }
}
