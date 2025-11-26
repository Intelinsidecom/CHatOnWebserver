package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.m */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3393m implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3391k f12354a;

    DialogInterfaceOnClickListenerC3393m(HandlerC3391k handlerC3391k) {
        this.f12354a = handlerC3391k;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f12354a.f12352a.f12118J != null) {
            this.f12354a.f12352a.m13086a(this.f12354a.f12352a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12354a.f12352a.f12130V, this.f12354a.f12352a.f12131W);
        }
        this.f12354a.f12352a.f12119K.m9390b();
    }
}
