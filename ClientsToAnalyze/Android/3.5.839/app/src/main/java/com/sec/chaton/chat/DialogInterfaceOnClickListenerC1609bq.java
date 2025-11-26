package com.sec.chaton.chat;

import android.content.ContentUris;
import android.content.DialogInterface;
import android.net.Uri;
import com.sec.chaton.smsplugin.p112ui.C4108aq;
import com.sec.chaton.smsplugin.p112ui.C4132bn;
import com.sec.chaton.smsplugin.p112ui.C4149cd;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1609bq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C4108aq f6125a;

    /* renamed from: b */
    final /* synthetic */ HandlerC1608bp f6126b;

    DialogInterfaceOnClickListenerC1609bq(HandlerC1608bp handlerC1608bp, C4108aq c4108aq) {
        this.f6126b = handlerC1608bp;
        this.f6125a = c4108aq;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                if (new C4132bn(this.f6126b.f6124a.f5624cN, this.f6126b.f6124a.f5624cN, this.f6125a, this.f6125a.m16307j(), this.f6125a.f15267b).m16386a(this.f6125a, this.f6126b.f6124a.f5731ej, false)) {
                    ((InterfaceC1668dv) this.f6126b.f6124a.getActivity()).mo7821f();
                    break;
                }
                break;
            case 1:
                Uri uriM16302e = this.f6125a.m16302e();
                if (this.f6125a.m16309l()) {
                    uriM16302e = ContentUris.withAppendedId(C4149cd.f15441b, this.f6125a.m16307j());
                }
                this.f6126b.f6124a.m7898a(new DialogInterfaceOnClickListenerC1663dq(this.f6126b.f6124a, uriM16302e, this.f6125a.m16304g()), this.f6125a.m16304g());
                break;
        }
        dialogInterface.cancel();
    }
}
