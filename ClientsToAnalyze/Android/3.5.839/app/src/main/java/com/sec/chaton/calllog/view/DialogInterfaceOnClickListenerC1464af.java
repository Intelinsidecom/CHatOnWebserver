package com.sec.chaton.calllog.view;

import android.content.DialogInterface;

/* compiled from: ShowConferenceMemberListFragment.java */
/* renamed from: com.sec.chaton.calllog.view.af */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1464af implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ShowConferenceMemberListFragment f5336a;

    DialogInterfaceOnClickListenerC1464af(ShowConferenceMemberListFragment showConferenceMemberListFragment) {
        this.f5336a = showConferenceMemberListFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5336a.m7786a(this.f5336a.f5301f.userInfo.get(this.f5336a.f5318w[0]).f5175a, this.f5336a.f5301f.userInfo.get(this.f5336a.f5318w[0]).f5176b);
    }
}
