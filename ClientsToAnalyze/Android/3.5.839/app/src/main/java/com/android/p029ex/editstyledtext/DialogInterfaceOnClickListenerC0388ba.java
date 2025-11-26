package com.android.p029ex.editstyledtext;

import android.content.DialogInterface;
import android.util.Log;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.ba */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0388ba implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0376ap f945a;

    DialogInterfaceOnClickListenerC0388ba(C0376ap c0376ap) {
        this.f945a = c0376ap;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Log.d("EditStyledText", "mBuilder.onclick:" + i);
        this.f945a.f933o.setItemSize(this.f945a.f933o.m1266c(Integer.parseInt((String) this.f945a.f928j[i])));
    }
}
