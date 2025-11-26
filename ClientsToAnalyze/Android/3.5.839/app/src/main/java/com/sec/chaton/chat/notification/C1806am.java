package com.sec.chaton.chat.notification;

import com.sec.chaton.C1009ah;
import com.sec.chaton.util.C4904y;
import com.sec.common.p130e.InterfaceC4995d;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.am */
/* loaded from: classes.dex */
class C1806am {

    /* renamed from: a */
    final /* synthetic */ ScreenNotification2 f6817a;

    private C1806am(ScreenNotification2 screenNotification2) {
        this.f6817a = screenNotification2;
    }

    /* synthetic */ C1806am(ScreenNotification2 screenNotification2, HandlerC1835x handlerC1835x) {
        this(screenNotification2);
    }

    @InterfaceC4995d
    public void onCloseNotifition(C1009ah c1009ah) {
        if (C4904y.f17873c) {
            C4904y.m18641c("!! Receive close popup event !!", ScreenNotification2.f6727v);
        }
        this.f6817a.m8882g();
    }
}
