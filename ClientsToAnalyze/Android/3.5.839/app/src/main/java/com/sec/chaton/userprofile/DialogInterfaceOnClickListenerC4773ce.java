package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: ProfileImageHistoryFragment.java */
/* renamed from: com.sec.chaton.userprofile.ce */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4773ce implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProfileImageHistoryFragment f17491a;

    DialogInterfaceOnClickListenerC4773ce(ProfileImageHistoryFragment profileImageHistoryFragment) {
        this.f17491a = profileImageHistoryFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f17491a.m18000l();
        this.f17491a.f17348p.m9307a(this.f17491a.f17315ae, false);
        this.f17491a.f17347o.show();
        this.f17491a.f17344l = true;
    }
}
