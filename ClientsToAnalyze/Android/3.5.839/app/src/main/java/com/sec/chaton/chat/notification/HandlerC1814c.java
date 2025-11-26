package com.sec.chaton.chat.notification;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ContextThemeWrapper;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: ChatONNotificationManager.java */
/* renamed from: com.sec.chaton.chat.notification.c */
/* loaded from: classes.dex */
class HandlerC1814c extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1813b f6867a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1814c(C1813b c1813b, Looper looper) {
        super(looper);
        this.f6867a = c1813b;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C1817f c1817f = (C1817f) message.obj;
        if (C1813b.f6833b == null) {
            C4904y.m18641c("Toast object is null, Make new object", this.f6867a.f6851a);
            C1813b.f6833b = (C1810aq) C1810aq.m8897a(new ContextThemeWrapper(CommonApplication.m18732r(), R.style.AppTheme));
        }
        C1813b.f6833b.m8899a(c1817f.f6876a, c1817f.f6877b, c1817f.f6878c, c1817f.f6879d, c1817f.f6880e);
    }
}
