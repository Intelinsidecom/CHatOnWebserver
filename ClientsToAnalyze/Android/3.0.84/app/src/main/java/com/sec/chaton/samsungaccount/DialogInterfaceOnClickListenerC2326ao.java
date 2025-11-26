package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2326ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2322ak f8748a;

    DialogInterfaceOnClickListenerC2326ao(HandlerC2322ak handlerC2322ak) {
        this.f8748a = handlerC2322ak;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8748a.f8744a.f8721r.mo5479a(this.f8748a.f8744a.f8678aC);
        this.f8748a.f8744a.f8678aC.m11091a(1001, 30000);
        dialogInterface.dismiss();
        if (this.f8748a.f8744a.f8714k != null) {
            this.f8748a.f8744a.m8743a(this.f8748a.f8744a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8748a.f8744a.f8650A, this.f8748a.f8744a.f8651B);
        }
    }
}
