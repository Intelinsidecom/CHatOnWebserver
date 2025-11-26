package com.sec.chaton.util;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: ScreenOnNotification.java */
/* renamed from: com.sec.chaton.util.bk */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1315bk implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ScreenOnNotification f4534a;

    DialogInterfaceOnClickListenerC1315bk(ScreenOnNotification screenOnNotification) {
        this.f4534a = screenOnNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GlobalApplication.m3104b(GlobalApplication.m3100a());
    }
}
