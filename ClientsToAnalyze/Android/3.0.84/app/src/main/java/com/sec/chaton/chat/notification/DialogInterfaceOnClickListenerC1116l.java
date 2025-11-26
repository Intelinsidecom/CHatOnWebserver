package com.sec.chaton.chat.notification;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.CommonApplication;

/* compiled from: FragmentScreenNotification.java */
/* renamed from: com.sec.chaton.chat.notification.l */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1116l implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentScreenNotification f4526a;

    DialogInterfaceOnClickListenerC1116l(FragmentScreenNotification fragmentScreenNotification) {
        this.f4526a = fragmentScreenNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GlobalApplication.m6449a(CommonApplication.m11493l());
    }
}
