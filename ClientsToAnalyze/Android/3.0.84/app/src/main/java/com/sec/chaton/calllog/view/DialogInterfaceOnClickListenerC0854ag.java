package com.sec.chaton.calllog.view;

import android.content.DialogInterface;

/* compiled from: ShowConferenceMemberListFragment.java */
/* renamed from: com.sec.chaton.calllog.view.ag */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0854ag implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ShowConferenceMemberListFragment f3364a;

    DialogInterfaceOnClickListenerC0854ag(ShowConferenceMemberListFragment showConferenceMemberListFragment) {
        this.f3364a = showConferenceMemberListFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3364a.m4632a(new String[]{this.f3364a.f3328f.userInfo.get(this.f3364a.f3345w[0]).f3205a, this.f3364a.f3328f.userInfo.get(this.f3364a.f3345w[1]).f3205a}, this.f3364a.f3328f.userInfo.get(this.f3364a.f3345w[0]).f3206b);
    }
}
