package com.facebook;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: Session.java */
/* renamed from: com.facebook.bp */
/* loaded from: classes.dex */
class HandlerC0493bp extends Handler {

    /* renamed from: a */
    private WeakReference<C0478ba> f1212a;

    /* renamed from: b */
    private WeakReference<ServiceConnectionC0492bo> f1213b;

    HandlerC0493bp(C0478ba c0478ba, ServiceConnectionC0492bo serviceConnectionC0492bo) {
        super(Looper.getMainLooper());
        this.f1212a = new WeakReference<>(c0478ba);
        this.f1213b = new WeakReference<>(serviceConnectionC0492bo);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String string = message.getData().getString("access_token");
        C0478ba c0478ba = this.f1212a.get();
        if (c0478ba != null && string != null) {
            c0478ba.m1754a(message.getData());
        }
        ServiceConnectionC0492bo serviceConnectionC0492bo = this.f1213b.get();
        if (serviceConnectionC0492bo != null) {
            C0478ba.f1169d.unbindService(serviceConnectionC0492bo);
            serviceConnectionC0492bo.m1799b();
        }
    }
}
