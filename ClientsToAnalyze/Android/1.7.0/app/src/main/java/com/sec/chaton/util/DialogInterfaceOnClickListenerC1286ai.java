package com.sec.chaton.util;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BlackScreenNotification.java */
/* renamed from: com.sec.chaton.util.ai */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1286ai implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f4467a;

    DialogInterfaceOnClickListenerC1286ai(BlackScreenNotification blackScreenNotification) {
        this.f4467a = blackScreenNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GlobalApplication.m3104b(GlobalApplication.m3100a());
    }
}
