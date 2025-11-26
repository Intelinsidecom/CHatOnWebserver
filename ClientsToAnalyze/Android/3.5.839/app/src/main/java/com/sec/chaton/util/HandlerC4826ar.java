package com.sec.chaton.util;

import android.os.Handler;
import android.os.Message;

/* compiled from: HandlerTimeOut.java */
/* renamed from: com.sec.chaton.util.ar */
/* loaded from: classes.dex */
public class HandlerC4826ar extends Handler {

    /* renamed from: b */
    boolean f17612b;

    /* renamed from: c */
    final int f17613c = -9999;

    /* renamed from: d */
    final int f17614d = -1;

    /* renamed from: e */
    final String f17615e = HandlerC4826ar.class.getSimpleName();

    /* renamed from: a */
    public void m18262a(int i) {
        if (C4904y.f17872b) {
            C4904y.m18639b("startTimer : " + i, this.f17615e);
        }
        this.f17612b = false;
        Message message = new Message();
        message.what = -9999;
        message.obj = false;
        message.arg1 = -1;
        sendMessageDelayed(message, i);
    }

    /* renamed from: a */
    public void m18263a(int i, int i2) {
        if (C4904y.f17872b) {
            C4904y.m18639b("startTimer : " + i2 + ", what : " + i, this.f17615e);
        }
        this.f17612b = false;
        Message message = new Message();
        message.what = -9999;
        message.obj = false;
        message.arg1 = i;
        sendMessageDelayed(message, i2);
    }

    /* renamed from: a */
    public void m18261a() {
        Message message = new Message();
        message.obj = true;
        sendMessage(message);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (C4904y.f17872b) {
            C4904y.m18639b("didTimeOut " + this.f17612b + " , what : " + message.what + ", arg1 : " + message.arg1, this.f17615e);
        }
        if (message.what != -9999) {
            if (this.f17612b) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Already time out, so ignore reponse about original msg", this.f17615e);
                    return;
                }
                return;
            } else {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Excepted msg was came, so cancel to timer", this.f17615e);
                }
                removeMessages(-9999);
                mo6050a(message);
                return;
            }
        }
        this.f17612b = true;
        if (message.arg1 != -1) {
            message.what = message.arg1;
        }
        mo6050a(message);
    }

    /* renamed from: a */
    public void mo6050a(Message message) {
    }
}
