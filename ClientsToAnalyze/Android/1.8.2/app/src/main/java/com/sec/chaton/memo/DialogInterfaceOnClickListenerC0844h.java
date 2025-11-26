package com.sec.chaton.memo;

import android.content.DialogInterface;

/* compiled from: WriteMemoActivity.java */
/* renamed from: com.sec.chaton.memo.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0844h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0843g f3095a;

    DialogInterfaceOnClickListenerC0844h(HandlerC0843g handlerC0843g) {
        this.f3095a = handlerC0843g;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3095a.f3094a.f3072j.m2896a(new C0839c(WriteMemoActivity.f3064l, WriteMemoActivity.f3065m, this.f3095a.f3094a.f3067b.getText().toString(), String.valueOf(System.currentTimeMillis())));
        if (!this.f3095a.f3094a.isFinishing()) {
            this.f3095a.f3094a.f3073k.show();
        }
    }
}
