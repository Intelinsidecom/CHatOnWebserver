package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.r */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0803r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0801p f3098a;

    DialogInterfaceOnClickListenerC0803r(HandlerC0801p handlerC0801p) {
        this.f3098a = handlerC0801p;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f3098a.f3096a.f1669Q != null) {
            this.f3098a.f3096a.f1676X.finish();
        }
    }
}
