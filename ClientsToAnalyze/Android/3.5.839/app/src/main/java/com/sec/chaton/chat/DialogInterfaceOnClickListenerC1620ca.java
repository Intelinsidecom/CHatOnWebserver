package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.msgsend.C2716x;
import com.sec.chaton.p057e.C2306z;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ca */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1620ca implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f6144a;

    /* renamed from: b */
    final /* synthetic */ DialogInterfaceOnClickListenerC1617by f6145b;

    DialogInterfaceOnClickListenerC1620ca(DialogInterfaceOnClickListenerC1617by dialogInterfaceOnClickListenerC1617by, String str) {
        this.f6145b = dialogInterfaceOnClickListenerC1617by;
        this.f6144a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C2716x.m11378a(this.f6144a, this.f6145b.f6139b);
        this.f6145b.f6141d.f5546ao.startDelete(3, null, C2306z.f8229a, "_id='" + this.f6145b.f6139b + "'", null);
    }
}
