package com.sec.chaton.chat.notification;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ContextThemeWrapper;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: ChatONNotificationManager.java */
/* renamed from: com.sec.chaton.chat.notification.b */
/* loaded from: classes.dex */
class HandlerC1106b extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1103a f4480a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerC1106b(C1103a c1103a, Looper looper) {
        super(looper);
        this.f4480a = c1103a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C1110f c1110f = (C1110f) message.obj;
        if (C1103a.f4440b == null) {
            C3250y.m11453c("Toast object is null, Make new object", this.f4480a.f4459a);
            C1103a.f4440b = (C1130z) C1130z.m5476a(new ContextThemeWrapper(CommonApplication.m11493l(), R.style.AppTheme));
        }
        C1103a.f4440b.m5478a(c1110f.f4493a, c1110f.f4494b, c1110f.f4495c, c1110f.f4496d);
    }
}
