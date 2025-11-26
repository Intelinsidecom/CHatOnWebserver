package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.sec.chaton.util.C3159aa;

/* compiled from: MainActivity.java */
/* renamed from: com.sec.chaton.samsungaccount.r */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2370r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2368p f8828a;

    DialogInterfaceOnClickListenerC2370r(HandlerC2368p handlerC2368p) {
        this.f8828a = handlerC2368p;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8828a.f8826a.f8693ao) {
            this.f8828a.f8826a.finish();
        }
        if (!this.f8828a.f8826a.f8723t || TextUtils.isEmpty(this.f8828a.f8826a.f8715l)) {
            C3159aa.m10962a().m10981a("samsung_account_email");
            this.f8828a.f8826a.finish();
        }
    }
}
