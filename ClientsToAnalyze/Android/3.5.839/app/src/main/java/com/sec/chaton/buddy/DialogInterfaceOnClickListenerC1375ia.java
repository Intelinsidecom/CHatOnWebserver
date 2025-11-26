package com.sec.chaton.buddy;

import android.content.DialogInterface;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ia */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1375ia implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1373hz f4975a;

    DialogInterfaceOnClickListenerC1375ia(HandlerC1373hz handlerC1373hz) {
        this.f4975a = handlerC1373hz;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4975a.f4973a.f4151j.finish();
    }
}
