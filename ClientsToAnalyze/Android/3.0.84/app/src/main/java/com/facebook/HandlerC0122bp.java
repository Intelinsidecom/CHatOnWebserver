package com.facebook;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: Session.java */
/* renamed from: com.facebook.bp */
/* loaded from: classes.dex */
class HandlerC0122bp extends Handler {

    /* renamed from: a */
    private WeakReference<C0107ba> f243a;

    /* renamed from: b */
    private WeakReference<ServiceConnectionC0121bo> f244b;

    HandlerC0122bp(C0107ba c0107ba, ServiceConnectionC0121bo serviceConnectionC0121bo) {
        super(Looper.getMainLooper());
        this.f243a = new WeakReference<>(c0107ba);
        this.f244b = new WeakReference<>(serviceConnectionC0121bo);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String string = message.getData().getString("access_token");
        C0107ba c0107ba = this.f243a.get();
        if (c0107ba != null && string != null) {
            c0107ba.m310a(message.getData());
        }
        ServiceConnectionC0121bo serviceConnectionC0121bo = this.f244b.get();
        if (serviceConnectionC0121bo != null) {
            C0107ba.f200d.unbindService(serviceConnectionC0121bo);
            serviceConnectionC0121bo.m356b();
        }
    }
}
