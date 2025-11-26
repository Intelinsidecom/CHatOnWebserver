package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.sec.chaton.settings.ActivityMultiDeviceView;
import com.sec.chaton.util.C4809aa;

/* compiled from: AbstractMultiDeviceActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.w */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3403w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3401u f12364a;

    DialogInterfaceOnClickListenerC3403w(HandlerC3401u handlerC3401u) {
        this.f12364a = handlerC3401u;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.f12364a.f12362a.f12118J, (Class<?>) ActivityMultiDeviceView.class);
        intent.putExtra("request_max_device", true);
        this.f12364a.f12362a.startActivityForResult(intent, 3);
        if (!this.f12364a.f12362a.f12168v || TextUtils.isEmpty(this.f12364a.f12362a.f12167u)) {
            C4809aa.m18104a().m18123a("samsung_account_email");
        }
    }
}
