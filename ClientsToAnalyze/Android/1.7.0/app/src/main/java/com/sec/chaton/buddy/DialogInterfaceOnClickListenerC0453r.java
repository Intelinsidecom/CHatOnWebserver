package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.p013a.C0202ao;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.r */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0453r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0397be f1446a;

    DialogInterfaceOnClickListenerC0453r(HandlerC0397be handlerC0397be) {
        this.f1446a = handlerC0397be;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1446a.f1371a.m2270e();
        new C0202ao(this.f1446a.f1371a.f1233c).m764b(this.f1446a.f1371a.f1242m);
    }
}
