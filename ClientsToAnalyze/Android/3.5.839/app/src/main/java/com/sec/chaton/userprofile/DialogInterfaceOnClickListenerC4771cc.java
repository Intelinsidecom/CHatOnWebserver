package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.cc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4771cc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f17489a;

    DialogInterfaceOnClickListenerC4771cc(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f17489a = profileImageHistoryFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f17489a.m18000l();
        this.f17489a.f17348p.m9307a(this.f17489a.f17315ae, true);
        this.f17489a.f17347o.show();
    }
}
