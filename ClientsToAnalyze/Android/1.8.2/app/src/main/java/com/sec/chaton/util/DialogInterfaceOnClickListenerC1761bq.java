package com.sec.chaton.util;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1761bq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f6399a;

    DialogInterfaceOnClickListenerC1761bq(ScreenOnNotification screenOnNotification) {
        this.f6399a = screenOnNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GlobalApplication.m3261b(GlobalApplication.m3260b());
    }
}
