package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4744bc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC4740az f17408a;

    DialogInterfaceOnClickListenerC4744bc(HandlerC4740az handlerC4740az) {
        this.f17408a = handlerC4740az;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f17408a.f17404a.f17208M.m9305a(this.f17408a.f17404a.f17240ai.getPath());
        this.f17408a.f17404a.f17278y.show();
    }
}
