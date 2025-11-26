package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.sec.chaton.R;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.o */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3395o implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3391k f12356a;

    DialogInterfaceOnClickListenerC3395o(HandlerC3391k handlerC3391k) {
        this.f12356a = handlerC3391k;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        NetworkInfo activeNetworkInfo;
        this.f12356a.f12352a.f12124P.mo9077a(this.f12356a.f12352a.f12160az);
        this.f12356a.f12352a.f12160az.m18263a(1001, 30000);
        dialogInterface.dismiss();
        if (this.f12356a.f12352a.f12118J != null && (activeNetworkInfo = ((ConnectivityManager) this.f12356a.f12352a.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnectedOrConnecting()) {
            this.f12356a.f12352a.m13086a(this.f12356a.f12352a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12356a.f12352a.f12130V, this.f12356a.f12352a.f12131W);
        }
    }
}
