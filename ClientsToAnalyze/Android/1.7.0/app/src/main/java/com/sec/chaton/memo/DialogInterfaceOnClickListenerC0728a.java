package com.sec.chaton.memo;

import android.content.DialogInterface;

/* compiled from: WriteMemoActivity.java */
/* renamed from: com.sec.chaton.memo.a */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0728a implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0731d f2466a;

    DialogInterfaceOnClickListenerC0728a(HandlerC0731d handlerC0731d) {
        this.f2466a = handlerC0731d;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2466a.f2474a.f2462e.m863a(new C0734g(WriteMemoActivity.f2456g, WriteMemoActivity.f2457i, this.f2466a.f2474a.f2459b.getText().toString(), String.valueOf(System.currentTimeMillis())));
        if (!this.f2466a.f2474a.isFinishing()) {
            this.f2466a.f2474a.f2463f.show();
        }
    }
}
