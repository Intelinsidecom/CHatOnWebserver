package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.bm */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3361bm implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f12299a;

    DialogInterfaceOnClickListenerC3361bm(MainActivity mainActivity) {
        this.f12299a = mainActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f12299a.f12222af != null && this.f12299a.f12222af.isShowing()) {
            this.f12299a.f12222af.dismiss();
        }
    }
}
