package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.settings.ActivityMultiDeviceView;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.v */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3402v implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3401u f12363a;

    DialogInterfaceOnClickListenerC3402v(HandlerC3401u handlerC3401u) {
        this.f12363a = handlerC3401u;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.f12363a.f12362a.f12118J, (Class<?>) ActivityMultiDeviceView.class);
        intent.putExtra("request_max_device", true);
        this.f12363a.f12362a.startActivityForResult(intent, 3);
    }
}
