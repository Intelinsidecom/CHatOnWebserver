package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.am */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2324am implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2322ak f8746a;

    DialogInterfaceOnClickListenerC2324am(HandlerC2322ak handlerC2322ak) {
        this.f8746a = handlerC2322ak;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8746a.f8744a.f8714k != null) {
            this.f8746a.f8744a.m8743a(this.f8746a.f8744a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8746a.f8744a.f8650A, this.f8746a.f8744a.f8651B);
        }
        this.f8746a.f8744a.f8716m.m5617b();
    }
}
