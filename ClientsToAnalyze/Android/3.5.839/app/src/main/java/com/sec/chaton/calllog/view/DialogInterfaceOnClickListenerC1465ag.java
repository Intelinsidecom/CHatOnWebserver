package com.sec.chaton.calllog.view;

import android.content.DialogInterface;

/* compiled from: ShowConferenceMemberListFragment.java */
/* renamed from: com.sec.chaton.calllog.view.ag */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1465ag implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ShowConferenceMemberListFragment f5337a;

    DialogInterfaceOnClickListenerC1465ag(ShowConferenceMemberListFragment showConferenceMemberListFragment) {
        this.f5337a = showConferenceMemberListFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5337a.m7788a(new String[]{this.f5337a.f5301f.userInfo.get(this.f5337a.f5318w[0]).f5175a, this.f5337a.f5301f.userInfo.get(this.f5337a.f5318w[1]).f5175a}, this.f5337a.f5301f.userInfo.get(this.f5337a.f5318w[0]).f5176b);
    }
}
