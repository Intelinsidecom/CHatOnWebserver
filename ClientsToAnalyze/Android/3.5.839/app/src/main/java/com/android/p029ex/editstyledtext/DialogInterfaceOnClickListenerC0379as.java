package com.android.p029ex.editstyledtext;

import android.content.DialogInterface;
import android.util.Log;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.as */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0379as implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0376ap f936a;

    DialogInterfaceOnClickListenerC0379as(C0376ap c0376ap) {
        this.f936a = c0376ap;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Log.d("EditStyledText", "mBuilder.onclick:" + i);
        this.f936a.f933o.setMarquee(i);
    }
}
