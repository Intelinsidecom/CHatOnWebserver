package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.net.Uri;
import com.sec.google.android.p134a.p136b.C5108d;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.dq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1663dq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6207a;

    /* renamed from: b */
    private final Uri f6208b;

    /* renamed from: c */
    private final boolean f6209c;

    public DialogInterfaceOnClickListenerC1663dq(ChatFragment chatFragment, Uri uri, boolean z) {
        this.f6207a = chatFragment;
        this.f6208b = uri;
        this.f6209c = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C5108d.m19487b().mo19484b(this.f6208b);
        this.f6207a.f5732ek.m15240a(this.f6207a.f5534aa, this.f6208b, 9700, (Object) null, this.f6209c);
        dialogInterface.dismiss();
    }
}
