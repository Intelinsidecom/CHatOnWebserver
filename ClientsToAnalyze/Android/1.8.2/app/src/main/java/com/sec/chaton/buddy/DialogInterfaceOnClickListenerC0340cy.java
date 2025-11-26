package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.p015d.C0633e;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.cy */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0340cy implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0338cw f1483a;

    DialogInterfaceOnClickListenerC0340cy(HandlerC0338cw handlerC0338cw) {
        this.f1483a = handlerC0338cw;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        new C0633e(this.f1483a.f1481a.f1147i).m2868b(this.f1483a.f1481a.f1159u);
    }
}
