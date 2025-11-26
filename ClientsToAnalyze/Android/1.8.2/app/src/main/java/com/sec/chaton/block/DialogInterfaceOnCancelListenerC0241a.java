package com.sec.chaton.block;

import android.content.DialogInterface;

/* compiled from: BlockActivity.java */
/* renamed from: com.sec.chaton.block.a */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0241a implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ BlockActivity f810a;

    DialogInterfaceOnCancelListenerC0241a(BlockActivity blockActivity) {
        this.f810a = blockActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f810a.f789m.m2849b();
        this.f810a.f792p = true;
        this.f810a.finish();
    }
}
