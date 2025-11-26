package com.sec.chaton.calllog.view;

import android.content.DialogInterface;

/* compiled from: ShowConferenceMemberListFragment.java */
/* renamed from: com.sec.chaton.calllog.view.af */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0853af implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ShowConferenceMemberListFragment f3363a;

    DialogInterfaceOnClickListenerC0853af(ShowConferenceMemberListFragment showConferenceMemberListFragment) {
        this.f3363a = showConferenceMemberListFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3363a.m4630a(this.f3363a.f3328f.userInfo.get(this.f3363a.f3345w[0]).f3205a, this.f3363a.f3328f.userInfo.get(this.f3363a.f3345w[0]).f3206b);
    }
}
