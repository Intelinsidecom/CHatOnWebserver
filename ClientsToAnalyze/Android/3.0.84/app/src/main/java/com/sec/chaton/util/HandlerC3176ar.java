package com.sec.chaton.util;

import android.os.Handler;
import android.os.Message;

/* compiled from: HandlerTimeOut.java */
/* renamed from: com.sec.chaton.util.ar */
/* loaded from: classes.dex */
public class HandlerC3176ar extends Handler {

    /* renamed from: b */
    boolean f11497b;

    /* renamed from: c */
    final int f11498c = -9999;

    /* renamed from: d */
    final int f11499d = -1;

    /* renamed from: e */
    final String f11500e = HandlerC3176ar.class.getSimpleName();

    /* renamed from: a */
    public void m11090a(int i) {
        if (C3250y.f11734b) {
            C3250y.m11450b("startTimer : " + i, this.f11500e);
        }
        this.f11497b = false;
        Message message = new Message();
        message.what = -9999;
        message.obj = false;
        message.arg1 = -1;
        sendMessageDelayed(message, i);
    }

    /* renamed from: a */
    public void m11091a(int i, int i2) {
        if (C3250y.f11734b) {
            C3250y.m11450b("startTimer : " + i2 + ", what : " + i, this.f11500e);
        }
        this.f11497b = false;
        Message message = new Message();
        message.what = -9999;
        message.obj = false;
        message.arg1 = i;
        sendMessageDelayed(message, i2);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (C3250y.f11734b) {
            C3250y.m11450b("didTimeOut " + this.f11497b + " , what : " + message.what + ", arg1 : " + message.arg1, this.f11500e);
        }
        if (message.what != -9999) {
            if (this.f11497b) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("Already time out, so ignore reponse about original msg", this.f11500e);
                    return;
                }
                return;
            } else {
                if (C3250y.f11734b) {
                    C3250y.m11450b("Excepted msg was came, so cancel to timer", this.f11500e);
                }
                removeMessages(-9999);
                mo3031a(message);
                return;
            }
        }
        this.f11497b = true;
        if (message.arg1 != -1) {
            message.what = message.arg1;
        }
        mo3031a(message);
    }

    /* renamed from: a */
    public void mo3031a(Message message) {
    }
}
