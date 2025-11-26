package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.p013a.C0202ao;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.af */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0371af implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0443h f1339a;

    DialogInterfaceOnClickListenerC0371af(HandlerC0443h handlerC0443h) {
        this.f1339a = handlerC0443h;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1339a.f1435a.m2085D();
        new C0202ao(this.f1339a.f1435a.f1147e).m764b(this.f1339a.f1435a.f1112V.m2314b());
    }
}
