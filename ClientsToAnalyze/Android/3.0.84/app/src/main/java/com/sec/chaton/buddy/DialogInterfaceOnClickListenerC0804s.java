package com.sec.chaton.buddy;

import android.content.DialogInterface;
import android.content.res.Resources;
import java.io.UnsupportedEncodingException;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.s */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0804s implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f3099a;

    /* renamed from: b */
    final /* synthetic */ HandlerC0801p f3100b;

    DialogInterfaceOnClickListenerC0804s(HandlerC0801p handlerC0801p, boolean z) {
        this.f3100b = handlerC0801p;
        this.f3099a = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException, UnsupportedEncodingException {
        this.f3100b.f3096a.m3175a(this.f3099a);
    }
}
