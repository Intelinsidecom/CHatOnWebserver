package com.sec.chaton.util;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: BlackScreenNotification.java */
/* renamed from: com.sec.chaton.util.j */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1778j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BlackScreenNotification f6437a;

    DialogInterfaceOnClickListenerC1778j(BlackScreenNotification blackScreenNotification) {
        this.f6437a = blackScreenNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GlobalApplication.m3261b(GlobalApplication.m3260b());
    }
}
