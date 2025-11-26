package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.sec.chaton.R;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.n */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3394n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3391k f12355a;

    DialogInterfaceOnClickListenerC3394n(HandlerC3391k handlerC3391k) {
        this.f12355a = handlerC3391k;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        NetworkInfo activeNetworkInfo;
        if (this.f12355a.f12352a.f12118J != null && (activeNetworkInfo = ((ConnectivityManager) this.f12355a.f12352a.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnectedOrConnecting()) {
            this.f12355a.f12352a.m13086a(this.f12355a.f12352a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12355a.f12352a.f12130V, this.f12355a.f12352a.f12131W);
        }
        if (!this.f12355a.f12352a.f12169w) {
            this.f12355a.f12352a.f12119K.m9390b();
        } else {
            this.f12355a.f12352a.mo12790j();
        }
    }
}
