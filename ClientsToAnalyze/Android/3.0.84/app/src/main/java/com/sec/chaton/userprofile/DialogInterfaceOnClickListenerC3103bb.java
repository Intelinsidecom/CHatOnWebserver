package com.sec.chaton.userprofile;

import android.content.DialogInterface;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bb */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3103bb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3098ax f11316a;

    DialogInterfaceOnClickListenerC3103bb(HandlerC3098ax handlerC3098ax) {
        this.f11316a = handlerC3098ax;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
