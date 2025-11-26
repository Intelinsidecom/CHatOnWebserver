package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ar */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2329ar implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f8751a;

    DialogInterfaceOnClickListenerC2329ar(MainActivity mainActivity) {
        this.f8751a = mainActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8751a.f8687ai != null && this.f8751a.f8687ai.isShowing()) {
            this.f8751a.f8687ai.dismiss();
        }
    }
}
