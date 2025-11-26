package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.p025d.C1330h;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ca */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0570ca implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0568bz f2532a;

    DialogInterfaceOnClickListenerC0570ca(HandlerC0568bz handlerC0568bz) {
        this.f2532a = handlerC0568bz;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2532a.f2530a.m3262Y();
        new C1330h(this.f2532a.f2530a.f1886q).m5730b(this.f2532a.f2530a.f1802an.m3975b());
    }
}
