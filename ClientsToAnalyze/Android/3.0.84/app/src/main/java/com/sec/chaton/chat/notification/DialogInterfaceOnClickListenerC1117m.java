package com.sec.chaton.chat.notification;

import android.content.DialogInterface;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.CommonApplication;

/* compiled from: FragmentScreenNotification.java */
/* renamed from: com.sec.chaton.chat.notification.m */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1117m implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentScreenNotification f4527a;

    DialogInterfaceOnClickListenerC1117m(FragmentScreenNotification fragmentScreenNotification) {
        this.f4527a = fragmentScreenNotification;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GlobalApplication.m6454c(CommonApplication.m11493l());
    }
}
